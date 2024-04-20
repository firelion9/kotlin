/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.incremental;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class IncrementalK1JsKlibCompilerRunnerTestGenerated extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
  @TestMetadata("jps/jps-plugin/testData/incremental/pureKotlin")
  @TestDataPath("$PROJECT_ROOT")
  @RunWith(JUnit3RunnerWithInners.class)
  public static class PureKotlin extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
    private void runTest(String testDataFilePath) {
      KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("accessingFunctionsViaPackagePart")
    public void testAccessingFunctionsViaPackagePart() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/accessingFunctionsViaPackagePart/");
    }

    @TestMetadata("accessingPropertiesViaField")
    public void testAccessingPropertiesViaField() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/accessingPropertiesViaField/");
    }

    @TestMetadata("addClass")
    public void testAddClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/addClass/");
    }

    @TestMetadata("addFileWithFunctionOverload")
    public void testAddFileWithFunctionOverload() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/addFileWithFunctionOverload/");
    }

    @TestMetadata("addMemberTypeAlias")
    public void testAddMemberTypeAlias() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/addMemberTypeAlias/");
    }

    @TestMetadata("addSimpleConflictingFunction")
    public void testAddSimpleConflictingFunction() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/addSimpleConflictingFunction/");
    }

    @TestMetadata("addTopLevelTypeAlias")
    public void testAddTopLevelTypeAlias() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/addTopLevelTypeAlias/");
    }

    public void testAllFilesPresentInPureKotlin() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/pureKotlin"), Pattern.compile("^([^\\.]+)$"), Pattern.compile("(^sealed.*)|(.*SinceK2)"), false);
    }

    @TestMetadata("annotations")
    public void testAnnotations() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/annotations/");
    }

    @TestMetadata("anonymousObjectChanged")
    public void testAnonymousObjectChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/anonymousObjectChanged/");
    }

    @TestMetadata("changeTypeImplicitlyWithCircularDependency")
    public void testChangeTypeImplicitlyWithCircularDependency() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/changeTypeImplicitlyWithCircularDependency/");
    }

    @TestMetadata("changeWithRemovingUsage")
    public void testChangeWithRemovingUsage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/changeWithRemovingUsage/");
    }

    @TestMetadata("checkConstants")
    public void testCheckConstants() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/checkConstants/");
    }

    @TestMetadata("classInlineFunctionChanged")
    public void testClassInlineFunctionChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classInlineFunctionChanged/");
    }

    @TestMetadata("classObjectConstantChanged")
    public void testClassObjectConstantChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classObjectConstantChanged/");
    }

    @TestMetadata("classRecreated")
    public void testClassRecreated() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classRecreated/");
    }

    @TestMetadata("classRemoved")
    public void testClassRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classRemoved/");
    }

    @TestMetadata("classSignatureChanged")
    public void testClassSignatureChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classSignatureChanged/");
    }

    @TestMetadata("classSignatureUnchanged")
    public void testClassSignatureUnchanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/classSignatureUnchanged/");
    }

    @TestMetadata("companionConstantChanged")
    public void testCompanionConstantChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/companionConstantChanged/");
    }

    @TestMetadata("compilationErrorThenFixedOtherPackage")
    public void testCompilationErrorThenFixedOtherPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/compilationErrorThenFixedOtherPackage/");
    }

    @TestMetadata("compilationErrorThenFixedSamePackage")
    public void testCompilationErrorThenFixedSamePackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/compilationErrorThenFixedSamePackage/");
    }

    @TestMetadata("compilationErrorThenFixedWithPhantomPart")
    public void testCompilationErrorThenFixedWithPhantomPart() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/compilationErrorThenFixedWithPhantomPart/");
    }

    @TestMetadata("compilationErrorThenFixedWithPhantomPart2")
    public void testCompilationErrorThenFixedWithPhantomPart2() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/compilationErrorThenFixedWithPhantomPart2/");
    }

    @TestMetadata("compilationErrorThenFixedWithPhantomPart3")
    public void testCompilationErrorThenFixedWithPhantomPart3() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/compilationErrorThenFixedWithPhantomPart3/");
    }

    @TestMetadata("constantRemoved")
    public void testConstantRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/constantRemoved/");
    }

    @TestMetadata("constantValueChanged")
    public void testConstantValueChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/constantValueChanged/");
    }

    @TestMetadata("constantsUnchanged")
    public void testConstantsUnchanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/constantsUnchanged/");
    }

    @TestMetadata("defaultArgumentInConstructorAdded")
    public void testDefaultArgumentInConstructorAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultArgumentInConstructorAdded/");
    }

    @TestMetadata("defaultArgumentInConstructorRemoved")
    public void testDefaultArgumentInConstructorRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultArgumentInConstructorRemoved/");
    }

    @TestMetadata("defaultValueAdded")
    public void testDefaultValueAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueAdded/");
    }

    @TestMetadata("defaultValueChanged")
    public void testDefaultValueChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueChanged/");
    }

    @TestMetadata("defaultValueInConstructorChanged")
    public void testDefaultValueInConstructorChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueInConstructorChanged/");
    }

    @TestMetadata("defaultValueInConstructorRemoved")
    public void testDefaultValueInConstructorRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueInConstructorRemoved/");
    }

    @TestMetadata("defaultValueRemoved1")
    public void testDefaultValueRemoved1() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueRemoved1/");
    }

    @TestMetadata("defaultValueRemoved2")
    public void testDefaultValueRemoved2() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/defaultValueRemoved2/");
    }

    @TestMetadata("delegatedPropertyInlineExtensionAccessor")
    public void testDelegatedPropertyInlineExtensionAccessor() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/delegatedPropertyInlineExtensionAccessor/");
    }

    @TestMetadata("delegatedPropertyInlineMethodAccessor")
    public void testDelegatedPropertyInlineMethodAccessor() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/delegatedPropertyInlineMethodAccessor/");
    }

    @TestMetadata("dependencyClassReferenced")
    public void testDependencyClassReferenced() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/dependencyClassReferenced/");
    }

    @TestMetadata("entriesMappings")
    public void testEntriesMappings() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/entriesMappings/");
    }

    @TestMetadata("fileWithConstantRemoved")
    public void testFileWithConstantRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/fileWithConstantRemoved/");
    }

    @TestMetadata("fileWithInlineFunctionRemoved")
    public void testFileWithInlineFunctionRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/fileWithInlineFunctionRemoved/");
    }

    @TestMetadata("filesExchangePackages")
    public void testFilesExchangePackages() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/filesExchangePackages/");
    }

    @TestMetadata("funRedeclaration")
    public void testFunRedeclaration() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/funRedeclaration/");
    }

    @TestMetadata("funVsConstructorOverloadConflict")
    public void testFunVsConstructorOverloadConflict() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/funVsConstructorOverloadConflict/");
    }

    @TestMetadata("functionBecameInline")
    public void testFunctionBecameInline() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/functionBecameInline/");
    }

    @TestMetadata("functionReferencingClass")
    public void testFunctionReferencingClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/functionReferencingClass/");
    }

    @TestMetadata("genericContextReceiver")
    public void testGenericContextReceiver() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/genericContextReceiver/");
    }

    @TestMetadata("independentClasses")
    public void testIndependentClasses() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/independentClasses/");
    }

    @TestMetadata("inlineFunctionBecomesNonInline")
    public void testInlineFunctionBecomesNonInline() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineFunctionBecomesNonInline/");
    }

    @TestMetadata("inlineFunctionUsageAdded")
    public void testInlineFunctionUsageAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineFunctionUsageAdded/");
    }

    @TestMetadata("inlineFunctionsCircularDependency")
    public void testInlineFunctionsCircularDependency() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineFunctionsCircularDependency/");
    }

    @TestMetadata("inlineFunctionsUnchanged")
    public void testInlineFunctionsUnchanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineFunctionsUnchanged/");
    }

    @TestMetadata("inlineLinesChanged")
    public void testInlineLinesChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineLinesChanged/");
    }

    @TestMetadata("inlineModifiedWithUsage")
    public void testInlineModifiedWithUsage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineModifiedWithUsage/");
    }

    @TestMetadata("inlinePrivateFunctionAdded")
    public void testInlinePrivateFunctionAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlinePrivateFunctionAdded/");
    }

    @TestMetadata("inlinePropertyInClass")
    public void testInlinePropertyInClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlinePropertyInClass/");
    }

    @TestMetadata("inlinePropertyOnTopLevel")
    public void testInlinePropertyOnTopLevel() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlinePropertyOnTopLevel/");
    }

    @TestMetadata("inlineSuspendFunctionChanged")
    public void testInlineSuspendFunctionChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineSuspendFunctionChanged/");
    }

    @TestMetadata("inlineTwoFunctionsOneChanged")
    public void testInlineTwoFunctionsOneChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineTwoFunctionsOneChanged/");
    }

    @TestMetadata("inlineUsedWhereDeclared")
    public void testInlineUsedWhereDeclared() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/inlineUsedWhereDeclared/");
    }

    @TestMetadata("innerClassesFromSupertypes")
    public void testInnerClassesFromSupertypes() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/innerClassesFromSupertypes/");
    }

    @TestMetadata("internalClassChanged")
    public void testInternalClassChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/internalClassChanged/");
    }

    @TestMetadata("internalMemberInClassChanged")
    public void testInternalMemberInClassChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/internalMemberInClassChanged/");
    }

    @TestMetadata("internalTypealias")
    public void testInternalTypealias() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/internalTypealias/");
    }

    @TestMetadata("internalTypealiasConstructor")
    public void testInternalTypealiasConstructor() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/internalTypealiasConstructor/");
    }

    @TestMetadata("internalTypealiasObject")
    public void testInternalTypealiasObject() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/internalTypealiasObject/");
    }

    @TestMetadata("localClassChanged")
    public void testLocalClassChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/localClassChanged/");
    }

    @TestMetadata("moveClass")
    public void testMoveClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/moveClass/");
    }

    @TestMetadata("moveFileWithChangingPackage")
    public void testMoveFileWithChangingPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/moveFileWithChangingPackage/");
    }

    @TestMetadata("moveFileWithoutChangingPackage")
    public void testMoveFileWithoutChangingPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/moveFileWithoutChangingPackage/");
    }

    @TestMetadata("multiplePackagesModified")
    public void testMultiplePackagesModified() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/multiplePackagesModified/");
    }

    @TestMetadata("objectConstantChanged")
    public void testObjectConstantChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/objectConstantChanged/");
    }

    @TestMetadata("ourClassReferenced")
    public void testOurClassReferenced() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/ourClassReferenced/");
    }

    @TestMetadata("overloadInlined")
    public void testOverloadInlined() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/overloadInlined/");
    }

    @TestMetadata("overloadReturnTypeChanged")
    public void testOverloadReturnTypeChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/overloadReturnTypeChanged/");
    }

    @TestMetadata("packageConstantChanged")
    public void testPackageConstantChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageConstantChanged/");
    }

    @TestMetadata("packageFileAdded")
    public void testPackageFileAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageFileAdded/");
    }

    @TestMetadata("packageFileChangedPackage")
    public void testPackageFileChangedPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageFileChangedPackage/");
    }

    @TestMetadata("packageFileChangedThenOtherRemoved")
    public void testPackageFileChangedThenOtherRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageFileChangedThenOtherRemoved/");
    }

    @TestMetadata("packageFileRemoved")
    public void testPackageFileRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageFileRemoved/");
    }

    @TestMetadata("packageFilesChangedInTurn")
    public void testPackageFilesChangedInTurn() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageFilesChangedInTurn/");
    }

    @TestMetadata("packageInlineFunctionAccessingField")
    public void testPackageInlineFunctionAccessingField() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageInlineFunctionAccessingField/");
    }

    @TestMetadata("packageInlineFunctionFromOurPackage")
    public void testPackageInlineFunctionFromOurPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageInlineFunctionFromOurPackage/");
    }

    @TestMetadata("packagePrivateOnlyChanged")
    public void testPackagePrivateOnlyChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packagePrivateOnlyChanged/");
    }

    @TestMetadata("packageRecreated")
    public void testPackageRecreated() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageRecreated/");
    }

    @TestMetadata("packageRecreatedAfterRenaming")
    public void testPackageRecreatedAfterRenaming() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageRecreatedAfterRenaming/");
    }

    @TestMetadata("packageRemoved")
    public void testPackageRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/packageRemoved/");
    }

    @TestMetadata("parameterWithDefaultValueAdded")
    public void testParameterWithDefaultValueAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/parameterWithDefaultValueAdded/");
    }

    @TestMetadata("parameterWithDefaultValueRemoved")
    public void testParameterWithDefaultValueRemoved() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/parameterWithDefaultValueRemoved/");
    }

    @TestMetadata("privateConstantsChanged")
    public void testPrivateConstantsChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateConstantsChanged/");
    }

    @TestMetadata("privateMethodAdded")
    public void testPrivateMethodAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateMethodAdded/");
    }

    @TestMetadata("privateMethodDeleted")
    public void testPrivateMethodDeleted() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateMethodDeleted/");
    }

    @TestMetadata("privateMethodSignatureChanged")
    public void testPrivateMethodSignatureChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateMethodSignatureChanged/");
    }

    @TestMetadata("privateOverloadAdded")
    public void testPrivateOverloadAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateOverloadAdded/");
    }

    @TestMetadata("privateSecondaryConstructorAdded")
    public void testPrivateSecondaryConstructorAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateSecondaryConstructorAdded/");
    }

    @TestMetadata("privateSecondaryConstructorDeleted")
    public void testPrivateSecondaryConstructorDeleted() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateSecondaryConstructorDeleted/");
    }

    @TestMetadata("privateValAccessorChanged")
    public void testPrivateValAccessorChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateValAccessorChanged/");
    }

    @TestMetadata("privateValAdded")
    public void testPrivateValAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateValAdded/");
    }

    @TestMetadata("privateValDeleted")
    public void testPrivateValDeleted() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateValDeleted/");
    }

    @TestMetadata("privateValSignatureChanged")
    public void testPrivateValSignatureChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateValSignatureChanged/");
    }

    @TestMetadata("privateVarAdded")
    public void testPrivateVarAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateVarAdded/");
    }

    @TestMetadata("privateVarDeleted")
    public void testPrivateVarDeleted() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateVarDeleted/");
    }

    @TestMetadata("privateVarSignatureChanged")
    public void testPrivateVarSignatureChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/privateVarSignatureChanged/");
    }

    @TestMetadata("propertyRedeclaration")
    public void testPropertyRedeclaration() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/propertyRedeclaration/");
    }

    @TestMetadata("publicPropertyWithPrivateSetter")
    public void testPublicPropertyWithPrivateSetter() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/publicPropertyWithPrivateSetter/");
    }

    @TestMetadata("removeAndRestoreCompanion")
    public void testRemoveAndRestoreCompanion() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeAndRestoreCompanion/");
    }

    @TestMetadata("removeAndRestoreCompanionWithImplicitUsages")
    public void testRemoveAndRestoreCompanionWithImplicitUsages() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeAndRestoreCompanionWithImplicitUsages/");
    }

    @TestMetadata("removeClass")
    public void testRemoveClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeClass/");
    }

    @TestMetadata("removeClassInDefaultPackage")
    public void testRemoveClassInDefaultPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeClassInDefaultPackage/");
    }

    @TestMetadata("removeFileWithFunctionOverload")
    public void testRemoveFileWithFunctionOverload() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeFileWithFunctionOverload/");
    }

    @TestMetadata("removeMemberTypeAlias")
    public void testRemoveMemberTypeAlias() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeMemberTypeAlias/");
    }

    @TestMetadata("removeTopLevelTypeAlias")
    public void testRemoveTopLevelTypeAlias() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeTopLevelTypeAlias/");
    }

    @TestMetadata("removeUnusedFile")
    public void testRemoveUnusedFile() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/removeUnusedFile/");
    }

    @TestMetadata("renameClass")
    public void testRenameClass() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/renameClass/");
    }

    @TestMetadata("renameFileWithClassesOnly")
    public void testRenameFileWithClassesOnly() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/renameFileWithClassesOnly/");
    }

    @TestMetadata("renameFileWithFunctionOverload")
    public void testRenameFileWithFunctionOverload() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/renameFileWithFunctionOverload/");
    }

    @TestMetadata("returnTypeChanged")
    public void testReturnTypeChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/returnTypeChanged/");
    }

    @TestMetadata("samConversion")
    public void testSamConversion() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/samConversion/");
    }

    @TestMetadata("secondaryConstructorInlined")
    public void testSecondaryConstructorInlined() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/secondaryConstructorInlined/");
    }

    @TestMetadata("sequentualAddingAndDeletingOfPropertyAndUsage")
    public void testSequentualAddingAndDeletingOfPropertyAndUsage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/sequentualAddingAndDeletingOfPropertyAndUsage/");
    }

    @TestMetadata("serializedSubClassAndChangedInterfaces")
    public void testSerializedSubClassAndChangedInterfaces() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/serializedSubClassAndChangedInterfaces/");
    }

    @TestMetadata("simpleClassDependency")
    public void testSimpleClassDependency() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/simpleClassDependency/");
    }

    @TestMetadata("soleFileChangesPackage")
    public void testSoleFileChangesPackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/soleFileChangesPackage/");
    }

    @TestMetadata("subpackage")
    public void testSubpackage() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/subpackage/");
    }

    @TestMetadata("suspendWithStateMachine")
    public void testSuspendWithStateMachine() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/suspendWithStateMachine/");
    }

    @TestMetadata("topLevelFunctionSameSignature")
    public void testTopLevelFunctionSameSignature() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/topLevelFunctionSameSignature/");
    }

    @TestMetadata("topLevelMembersInTwoFiles")
    public void testTopLevelMembersInTwoFiles() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/topLevelMembersInTwoFiles/");
    }

    @TestMetadata("topLevelPrivateValUsageAdded")
    public void testTopLevelPrivateValUsageAdded() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/topLevelPrivateValUsageAdded/");
    }

    @TestMetadata("traitClassObjectConstantChanged")
    public void testTraitClassObjectConstantChanged() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/traitClassObjectConstantChanged/");
    }

    @TestMetadata("transitiveReturnType")
    public void testTransitiveReturnType() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/transitiveReturnType/");
    }

    @TestMetadata("valAddCustomAccessor")
    public void testValAddCustomAccessor() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/valAddCustomAccessor/");
    }

    @TestMetadata("valRemoveCustomAccessor")
    public void testValRemoveCustomAccessor() {
      runTest("jps/jps-plugin/testData/incremental/pureKotlin/valRemoveCustomAccessor/");
    }
  }

  @TestMetadata("jps/jps-plugin/testData/incremental/classHierarchyAffected")
  @TestDataPath("$PROJECT_ROOT")
  @RunWith(JUnit3RunnerWithInners.class)
  public static class ClassHierarchyAffected extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
    private void runTest(String testDataFilePath) {
      KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInClassHierarchyAffected() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/classHierarchyAffected"), Pattern.compile("^([^\\.]+)$"), null, false);
    }

    @TestMetadata("annotationFlagRemoved")
    public void testAnnotationFlagRemoved() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/annotationFlagRemoved/");
    }

    @TestMetadata("annotationListChanged")
    public void testAnnotationListChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/annotationListChanged/");
    }

    @TestMetadata("bridgeGenerated")
    public void testBridgeGenerated() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/bridgeGenerated/");
    }

    @TestMetadata("classBecameFinal")
    public void testClassBecameFinal() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classBecameFinal/");
    }

    @TestMetadata("classBecameInterface")
    public void testClassBecameInterface() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classBecameInterface/");
    }

    @TestMetadata("classBecamePrivate")
    public void testClassBecamePrivate() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classBecamePrivate/");
    }

    @TestMetadata("classMovedIntoOtherClass")
    public void testClassMovedIntoOtherClass() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classMovedIntoOtherClass/");
    }

    @TestMetadata("classRemoved")
    public void testClassRemoved() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classRemoved/");
    }

    @TestMetadata("classRemovedAndRestored")
    public void testClassRemovedAndRestored() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/classRemovedAndRestored/");
    }

    @TestMetadata("companionObjectInheritedMemberChanged")
    public void testCompanionObjectInheritedMemberChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/companionObjectInheritedMemberChanged/");
    }

    @TestMetadata("companionObjectMemberChanged")
    public void testCompanionObjectMemberChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/companionObjectMemberChanged/");
    }

    @TestMetadata("companionObjectNameChanged")
    public void testCompanionObjectNameChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/companionObjectNameChanged/");
    }

    @TestMetadata("companionObjectToSimpleObject")
    public void testCompanionObjectToSimpleObject() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/companionObjectToSimpleObject/");
    }

    @TestMetadata("constructorVisibilityChanged")
    public void testConstructorVisibilityChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/constructorVisibilityChanged/");
    }

    @TestMetadata("enumEntryAdded")
    public void testEnumEntryAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/enumEntryAdded/");
    }

    @TestMetadata("enumEntryRemoved")
    public void testEnumEntryRemoved() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/enumEntryRemoved/");
    }

    @TestMetadata("enumMemberChanged")
    public void testEnumMemberChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/enumMemberChanged/");
    }

    @TestMetadata("flagsAndMemberInDifferentClassesChanged")
    public void testFlagsAndMemberInDifferentClassesChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/flagsAndMemberInDifferentClassesChanged/");
    }

    @TestMetadata("flagsAndMemberInSameClassChanged")
    public void testFlagsAndMemberInSameClassChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/flagsAndMemberInSameClassChanged/");
    }

    @TestMetadata("implcitUpcast")
    public void testImplcitUpcast() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/implcitUpcast/");
    }

    @TestMetadata("inferredTypeArgumentChanged")
    public void testInferredTypeArgumentChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/inferredTypeArgumentChanged/");
    }

    @TestMetadata("inferredTypeChanged")
    public void testInferredTypeChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/inferredTypeChanged/");
    }

    @TestMetadata("interfaceAnyMethods")
    public void testInterfaceAnyMethods() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/interfaceAnyMethods/");
    }

    @TestMetadata("lambdaParameterAffected")
    public void testLambdaParameterAffected() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/lambdaParameterAffected/");
    }

    @TestMetadata("methodAdded")
    public void testMethodAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/methodAdded/");
    }

    @TestMetadata("methodAnnotationAdded")
    public void testMethodAnnotationAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/methodAnnotationAdded/");
    }

    @TestMetadata("methodNullabilityChanged")
    public void testMethodNullabilityChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/methodNullabilityChanged/");
    }

    @TestMetadata("methodParameterWithDefaultValueAdded")
    public void testMethodParameterWithDefaultValueAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/methodParameterWithDefaultValueAdded/");
    }

    @TestMetadata("methodRemoved")
    public void testMethodRemoved() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/methodRemoved/");
    }

    @TestMetadata("overrideExplicit")
    public void testOverrideExplicit() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/overrideExplicit/");
    }

    @TestMetadata("overrideImplicit")
    public void testOverrideImplicit() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/overrideImplicit/");
    }

    @TestMetadata("propertyNullabilityChanged")
    public void testPropertyNullabilityChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/propertyNullabilityChanged/");
    }

    @TestMetadata("sealedClassImplAdded")
    public void testSealedClassImplAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/sealedClassImplAdded/");
    }

    @TestMetadata("sealedClassIndirectImplAdded")
    public void testSealedClassIndirectImplAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/sealedClassIndirectImplAdded/");
    }

    @TestMetadata("sealedClassNestedImplAdded")
    public void testSealedClassNestedImplAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/sealedClassNestedImplAdded/");
    }

    @TestMetadata("secondaryConstructorAdded")
    public void testSecondaryConstructorAdded() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/secondaryConstructorAdded/");
    }

    @TestMetadata("starProjectionUpperBoundChanged")
    public void testStarProjectionUpperBoundChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/starProjectionUpperBoundChanged/");
    }

    @TestMetadata("supertypesListChanged")
    public void testSupertypesListChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/supertypesListChanged/");
    }

    @TestMetadata("typeParameterListChanged")
    public void testTypeParameterListChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/typeParameterListChanged/");
    }

    @TestMetadata("varianceChanged")
    public void testVarianceChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/varianceChanged/");
    }

    @TestMetadata("withIntermediateBodiesChanged")
    public void testWithIntermediateBodiesChanged() {
      runTest("jps/jps-plugin/testData/incremental/classHierarchyAffected/withIntermediateBodiesChanged/");
    }
  }

  @TestMetadata("jps/jps-plugin/testData/incremental/js")
  @TestDataPath("$PROJECT_ROOT")
  @RunWith(JUnit3RunnerWithInners.class)
  public static class Js extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
    private void runTest(String testDataFilePath) {
      KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInJs() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/js"), Pattern.compile("^([^\\.]+)$"), null, true);
    }

    @TestMetadata("inlineFunctionLocalDeclarationChanges")
    public void testInlineFunctionLocalDeclarationChanges() {
      runTest("jps/jps-plugin/testData/incremental/js/inlineFunctionLocalDeclarationChanges/");
    }

    @TestMetadata("jps/jps-plugin/testData/incremental/js/friendsModuleDisabled")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class FriendsModuleDisabled extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
      private void runTest(String testDataFilePath) {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
      }

      public void testAllFilesPresentInFriendsModuleDisabled() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/js/friendsModuleDisabled"), Pattern.compile("^([^\\.]+)$"), null, true);
      }

      @TestMetadata("internalInlineFunctionIsChanged")
      public void testInternalInlineFunctionIsChanged() {
        runTest("jps/jps-plugin/testData/incremental/js/friendsModuleDisabled/internalInlineFunctionIsChanged/");
      }

      @TestMetadata("jps/jps-plugin/testData/incremental/js/friendsModuleDisabled/internalInlineFunctionIsChanged")
      @TestDataPath("$PROJECT_ROOT")
      @RunWith(JUnit3RunnerWithInners.class)
      public static class InternalInlineFunctionIsChanged extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
        private void runTest(String testDataFilePath) {
          KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInInternalInlineFunctionIsChanged() {
          KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/js/friendsModuleDisabled/internalInlineFunctionIsChanged"), Pattern.compile("^([^\\.]+)$"), null, true);
        }
      }
    }

    @TestMetadata("jps/jps-plugin/testData/incremental/js/inlineFunctionLocalDeclarationChanges")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class InlineFunctionLocalDeclarationChanges extends AbstractIncrementalK1JsKlibCompilerRunnerTest {
      private void runTest(String testDataFilePath) {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
      }

      public void testAllFilesPresentInInlineFunctionLocalDeclarationChanges() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("jps/jps-plugin/testData/incremental/js/inlineFunctionLocalDeclarationChanges"), Pattern.compile("^([^\\.]+)$"), null, true);
      }
    }
  }
}
