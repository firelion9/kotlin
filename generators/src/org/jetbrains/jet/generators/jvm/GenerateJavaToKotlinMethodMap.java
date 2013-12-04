/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.generators.jvm;

import com.google.common.collect.Lists;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiSubstitutor;
import com.intellij.psi.impl.file.impl.JavaFileManager;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiFormatUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.cli.jvm.compiler.JetCoreEnvironment;
import org.jetbrains.jet.config.CompilerConfiguration;
import org.jetbrains.jet.di.GeneratorsFileUtil;
import org.jetbrains.jet.lang.descriptors.ClassDescriptor;
import org.jetbrains.jet.lang.descriptors.DeclarationDescriptor;
import org.jetbrains.jet.lang.descriptors.FunctionDescriptor;
import org.jetbrains.jet.lang.resolve.DescriptorUtils;
import org.jetbrains.jet.lang.resolve.java.mapping.JavaToKotlinClassMapBuilder;
import org.jetbrains.jet.lang.types.lang.KotlinBuiltIns;
import org.jetbrains.jet.renderer.DescriptorRenderer;
import org.jetbrains.jet.utils.PathUtil;
import org.jetbrains.jet.utils.Printer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.intellij.psi.util.PsiFormatUtilBase.*;
import static org.jetbrains.jet.cli.jvm.JVMConfigurationKeys.CLASSPATH_KEY;
import static org.jetbrains.jet.lang.resolve.java.kotlinSignature.JavaToKotlinMethodMap.serializeFunction;

public class GenerateJavaToKotlinMethodMap {

    public static final String BUILTINS_FQNAME_PREFIX = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.asString() + ".";

    public static final File TARGET_FILE =
            new File("compiler/frontend.java/src/org/jetbrains/jet/lang/resolve/java/kotlinSignature/JavaToKotlinMethodMapGenerated.java");

    public static void main(String[] args) throws IOException {
        GeneratorsFileUtil.writeFileIfContentChanged(TARGET_FILE, generateText().toString());
    }

    public static CharSequence generateText() throws IOException {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.add(CLASSPATH_KEY, PathUtil.findRtJar());

        Disposable disposable = Disposer.newDisposable();
        try {
            JetCoreEnvironment coreEnvironment = JetCoreEnvironment.createForProduction(disposable, configuration);

            StringBuilder buf = new StringBuilder();
            Printer printer = new Printer(buf);

            printer.print(FileUtil.loadFile(new File("injector-generator/copyright.txt")))
                    .println()
                    .println("package org.jetbrains.jet.lang.resolve.java.kotlinSignature;")
                    .println()
                    .println("import com.google.common.collect.ImmutableMultimap;")
                    .println()
                    .println("import static org.jetbrains.jet.lang.resolve.java.kotlinSignature.JavaToKotlinMethodMap.*;")
                    .println()
                    .println("/* This file is generated by ", GenerateJavaToKotlinMethodMap.class.getName(), ". DO NOT EDIT! */")
                    .println("@SuppressWarnings(\"unchecked\")")
                    .println("class JavaToKotlinMethodMapGenerated {").pushIndent()
                    .println("final ImmutableMultimap<String, JavaToKotlinMethodMap.ClassData> map;")
                    .println()
                    .println("JavaToKotlinMethodMapGenerated() {").pushIndent()
                    .println("ImmutableMultimap.Builder<String, JavaToKotlinMethodMap.ClassData> b = ImmutableMultimap.builder();")
                    .println();

            MyMapBuilder builder = new MyMapBuilder(coreEnvironment.getProject());
            printer.printWithNoIndent(builder.toString());

            printer.println("map = b.build();");
            printer.popIndent().println("}");
            printer.popIndent().println("}");
            return buf;
        }
        finally {
            Disposer.dispose(disposable);
        }

    }

    private static class MyMapBuilder extends JavaToKotlinClassMapBuilder {
        private final Project project;
        private final StringBuilder buf = new StringBuilder();
        private final Printer printer = new Printer(buf).pushIndent().pushIndent();

        public MyMapBuilder(@NotNull Project project) {
            this.project = project;
            init();
        }

        @Override
        protected void register(@NotNull Class<?> javaClass, @NotNull ClassDescriptor kotlinDescriptor, @NotNull Direction direction) {
            processClass(javaClass, kotlinDescriptor);
        }

        @Override
        protected void register(@NotNull Class<?> javaClass,
                @NotNull ClassDescriptor kotlinDescriptor,
                @NotNull ClassDescriptor kotlinMutableDescriptor,
                @NotNull Direction direction) {
            processClass(javaClass, kotlinDescriptor);
            processClass(javaClass, kotlinMutableDescriptor);
        }

        private void processClass(@NotNull Class<?> javaClass, @NotNull ClassDescriptor kotlinClass) {
            JavaFileManager javaFileManager = ServiceManager.getService(project, JavaFileManager.class);
            PsiClass psiClass = javaFileManager.findClass(javaClass.getCanonicalName(), GlobalSearchScope.allScope(project));
            assert psiClass != null;

            List<Pair<PsiMethod, FunctionDescriptor>> methods2Functions = getClassMethods2Functions(kotlinClass, psiClass);
            if (!methods2Functions.isEmpty()) {
                appendBeforeClass(kotlinClass, psiClass);
                appendClass(methods2Functions);
                appendAfterClass();
            }
        }

        private static List<Pair<PsiMethod, FunctionDescriptor>> getClassMethods2Functions(
                @NotNull ClassDescriptor kotlinClass,
                @NotNull PsiClass psiClass
        ) {
            PsiMethod[] methods = psiClass.getMethods();

            List<Pair<PsiMethod, FunctionDescriptor>> result = Lists.newArrayList();

            for (DeclarationDescriptor member : kotlinClass.getDefaultType().getMemberScope().getAllDescriptors()) {
                if (!(member instanceof FunctionDescriptor) || member.getContainingDeclaration() != kotlinClass) {
                    continue;
                }

                FunctionDescriptor fun = (FunctionDescriptor) member;
                PsiMethod foundMethod = findMethod(methods, fun);
                if (foundMethod != null) {
                    result.add(Pair.create(foundMethod, fun));
                }
            }

            Collections.sort(result, new Comparator<Pair<PsiMethod, FunctionDescriptor>>() {
                @Override
                public int compare(Pair<PsiMethod, FunctionDescriptor> pair1, Pair<PsiMethod, FunctionDescriptor> pair2) {
                    PsiMethod method1 = pair1.first;
                    PsiMethod method2 = pair2.first;

                    String name1 = method1.getName();
                    String name2 = method2.getName();
                    if (!name1.equals(name2)) {
                        return name1.compareTo(name2);
                    }

                    String serialized1 = serializePsiMethod(method1);
                    String serialized2 = serializePsiMethod(method2);
                    return serialized1.compareTo(serialized2);
                }
            });
            return result;
        }

        private static boolean match(@NotNull PsiMethod method, @NotNull FunctionDescriptor fun) {
            // Compare method an function by name and parameters count. For all methods except one (List.remove) it is enough.
            // If this changes, there will be assertion error in findMethod()
            if (method.getName().equals(fun.getName().getIdentifier())
                && method.getParameterList().getParametersCount() == fun.getValueParameters().size()) {

                // "special case": remove(Int) and remove(Any?) in MutableList
                if (method.getName().equals("remove") && method.getContainingClass().getName().equals("List")) {
                    String psiType = method.getParameterList().getParameters()[0].getType().getPresentableText();
                    String jetType = DescriptorRenderer.SHORT_NAMES_IN_TYPES.renderType(fun.getValueParameters().get(0).getType());
                    String string = psiType + "|" + jetType;

                    return "int|Int".equals(string) || "Object|Any?".equals(string);
                }

                return true;
            }
            return false;
        }

        @NotNull
        private static String serializePsiMethod(@NotNull PsiMethod psiMethod) {
            return PsiFormatUtil.formatMethod(psiMethod, PsiSubstitutor.EMPTY, SHOW_NAME | SHOW_PARAMETERS,
                                              SHOW_TYPE | SHOW_FQ_CLASS_NAMES);
        }

        @Nullable
        private static PsiMethod findMethod(@NotNull PsiMethod[] methods, @NotNull FunctionDescriptor fun) {
            PsiMethod found = null;
            for (PsiMethod method : methods) {
                if (match(method, fun)) {
                    if (found != null) {
                        throw new AssertionError("Duplicate for " + fun);
                    }

                    found = method;
                }
            }

            return found;
        }

        private void appendBeforeClass(@NotNull ClassDescriptor kotlinClass, @NotNull PsiClass psiClass) {
            String psiFqName = psiClass.getQualifiedName();
            String kotlinFqName = DescriptorUtils.getFqNameSafe(kotlinClass).asString();

            assert kotlinFqName.startsWith(BUILTINS_FQNAME_PREFIX);
            String kotlinSubQualifiedName = kotlinFqName.substring(BUILTINS_FQNAME_PREFIX.length());
            printer.println("put(b, \"", psiFqName, "\", \"", kotlinSubQualifiedName, "\",").pushIndent();
        }

        private void appendClass(@NotNull List<Pair<PsiMethod, FunctionDescriptor>> methods2Functions) {
            int index = 0;
            for (Pair<PsiMethod, FunctionDescriptor> method2Function : methods2Functions) {
                printer.print("pair(\"", serializePsiMethod(method2Function.first), "\", \"", serializeFunction(method2Function.second),
                              "\")");

                if (index != methods2Functions.size() - 1) {
                    printer.printWithNoIndent(",");
                }

                printer.println();

                index++;
            }
        }

        private void appendAfterClass() {
            printer.popIndent().println(");").println();
        }


        public String toString() {
            return buf.toString();
        }
    }

    private GenerateJavaToKotlinMethodMap() {
    }
}
