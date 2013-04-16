/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package org.jnario.suite.ui;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtend.core.formatting.FormatterPreferenceValuesProvider;
import org.eclipse.xtend.ide.XtendPreferenceStoreInitializer;
import org.eclipse.xtend.ide.XtendResourceUiServiceProvider;
import org.eclipse.xtend.ide.autoedit.AutoEditStrategyProvider;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtend.ide.builder.JavaProjectPreferencesInitializer;
import org.eclipse.xtend.ide.contentassist.EscapeSequenceAwarePrefixMatcher;
import org.eclipse.xtend.ide.contentassist.TemplateProposalProvider;
import org.eclipse.xtend.ide.contentassist.XtendContentAssistFactory;
import org.eclipse.xtend.ide.editor.InitiallyCollapsableAwareFoldingStructureProvider;
import org.eclipse.xtend.ide.editor.OccurrenceComputer;
import org.eclipse.xtend.ide.editor.OverrideIndicatorModelListener;
import org.eclipse.xtend.ide.editor.OverrideIndicatorRulerAction;
import org.eclipse.xtend.ide.editor.RichStringAwareSourceViewer;
import org.eclipse.xtend.ide.editor.RichStringAwareToggleCommentAction;
import org.eclipse.xtend.ide.editor.SingleLineCommentHelper;
import org.eclipse.xtend.ide.editor.XtendFoldingRegionProvider;
import org.eclipse.xtend.ide.editor.XtendNatureAddingEditorCallback;
import org.eclipse.xtend.ide.editor.XtendSourceViewerConfiguration;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtend.ide.formatting.preferences.FormatterResourceProvider;
import org.eclipse.xtend.ide.highlighting.RichStringAwareTokenScanner;
import org.eclipse.xtend.ide.highlighting.ShowWhitespaceCharactersActionContributor;
import org.eclipse.xtend.ide.hover.XtendAnnotationHover;
import org.eclipse.xtend.ide.hover.XtendHoverDocumentationProvider;
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider;
import org.eclipse.xtend.ide.hyperlinking.XtendHyperlinkHelper;
import org.eclipse.xtend.ide.outline.ShowSyntheticMembersContribution;
import org.eclipse.xtend.ide.outline.XtendOutlineNodeComparator;
import org.eclipse.xtend.ide.outline.XtendOutlinePage;
import org.eclipse.xtend.ide.outline.XtendQuickOutlineFilterAndSorter;
import org.eclipse.xtend.ide.refactoring.XtendDependentElementsCalculator;
import org.eclipse.xtend.ide.refactoring.XtendJdtRenameParticipantProcessor;
import org.eclipse.xtend.ide.refactoring.XtendRefactoringPreferences;
import org.eclipse.xtend.ide.refactoring.XtendRenameContextFactory;
import org.eclipse.xtend.ide.refactoring.XtendRenameElementProcessor;
import org.eclipse.xtend.ide.refactoring.XtendRenameStrategy;
import org.eclipse.xtend.ide.refactoring.XtendRenameStrategyProvider;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.trace.TraceForStorageProvider;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.IContextInformationProvider;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingStructureProvider;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ToggleSLCommentAction;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.formatting.IFormattingPreferenceValuesProvider;
import org.eclipse.xtext.xbase.ui.contentassist.ParameterContextInformationProvider;
import org.eclipse.xtext.xbase.ui.editor.XbaseEditor;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.JdtRenameRefactoringParticipantProcessor;
import org.eclipse.xtext.xbase.ui.launching.JavaElementDelegate;
import org.eclipse.xtext.xbase.ui.validation.XbaseIssueSeveritiesProvider;
import org.jnario.suite.generator.SuiteGenerator;
import org.jnario.suite.ui.editor.SuiteDoubleClickStrategyProvider;
import org.jnario.suite.ui.highlighting.SuiteHighlightingCalculator;
import org.jnario.suite.ui.highlighting.SuiteHighlightingConfiguration;
import org.jnario.suite.ui.highlighting.SuiteTokenHighlighting;
import org.jnario.suite.ui.hover.SuiteHoverProvider;
import org.jnario.suite.ui.launching.SuiteJavaElementDelegate;
import org.jnario.ui.builder.JnarioBuilderParticipant;
import org.jnario.ui.builder.JnarioSourceRelativeFileSystemAccess;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("restriction")
public class SuiteUiModule extends org.jnario.suite.ui.AbstractSuiteUiModule {
	public SuiteUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	@Override
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SuiteHighlightingCalculator.class;
	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		return TokenTypeToPartitionMapper.class;
	}
	
	@Override
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SuiteHighlightingConfiguration.class;
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return SuiteTokenHighlighting.class;
	}
	
	@Override
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return SuiteHoverProvider.class;
	}
	
	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return XtendFoldingRegionProvider.class;
	}

	@Override
	public Class<? extends IOccurrenceComputer> bindIOccurrenceComputer() {
		return OccurrenceComputer.class;
	}
	

	public Class<? extends XbaseDeclarativeHoverSignatureProvider> bindXbaseDeclarativeHoverSignatureProvider(){
		return XtendHoverSignatureProvider.class;
	}
	
	@Override
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider(){
		return XtendHoverDocumentationProvider.class;
	}

	
	
	@Override
	public Class<? extends IAnnotationHover> bindIAnnotationHover () {
		return XtendAnnotationHover.class;
	}


	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}

	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return SuiteDoubleClickStrategyProvider.class;
	}

	@Override
	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
		return XtendOutlineNodeComparator.class;
	}

	public Class<? extends QuickOutlineFilterAndSorter> bindQuickOutlineFilterAndSorter() {
		return XtendQuickOutlineFilterAndSorter.class;
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return XtendOutlinePage.class;
	}

	@Override
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return XtendHyperlinkHelper.class;
	}

	
	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
		return JnarioSourceRelativeFileSystemAccess.class;
	}
	
	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return JnarioBuilderParticipant.class;
	}
	
	@Override
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361385
		return null;
	}
	
	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return XtendNatureAddingEditorCallback.class;
	}
	
	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
		return XtendResourceUiServiceProvider.class;
	}

	@Override
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class)
					.to(DerivedMemberAwareEditorOpener.class);
			binder.bind(IDerivedMemberAwareEditorOpener.class).to(DerivedMemberAwareEditorOpener.class);
		}
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.XtextEditor> bindXtextEditor() {
		return XbaseEditor.class;
	}
	
	public Class<? extends JavaElementDelegate> bindJavaElementDelegate(){
		return SuiteJavaElementDelegate.class;
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return SuiteGenerator.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return org.jnario.suite.ui.quickfix.SuiteQuickfixProvider.class;
	}
	@Override
	public void configureIPreferenceStoreInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class)
			.annotatedWith(Names.named("RefactoringPreferences"))
			.to(XtendRefactoringPreferences.Initializer.class);
	}

	public Class<? extends RenameElementProcessor> bindRenameElementProcessor() {
		return XtendRenameElementProcessor.class;
	}

	@Override
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return XtendRenameStrategy.class;
	}

	@Override
	public java.lang.Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return XtendDependentElementsCalculator.class;
	}
	
	@Override
	public void configureJvmMemberRenameStrategy$Provider$Delegate(Binder binder) {
		binder.bind(IRenameStrategy.Provider.class)
			.annotatedWith(JvmMemberRenameStrategy.Provider.Delegate.class)
			.to(XtendRenameStrategyProvider.class);
	}
		
	public Class<? extends JdtRenameRefactoringParticipantProcessor> bindJdtRenameRefactoringParticipantProcessor() {
		return XtendJdtRenameParticipantProcessor.class;
	}
	
	public void configureDebugMode(Binder binder) {
		if (Boolean.getBoolean("org.eclipse.xtext.xtend.debug")) {
			binder.bindConstant().annotatedWith(Names.named(AbstractEditStrategy.DEBUG)).to(true);
		}
		// matches ID of org.eclipse.ui.contexts extension registered in plugin.xml
		binder.bindConstant().annotatedWith(Names.named(XtextEditor.KEY_BINDING_SCOPE))
				.to("org.eclipse.xtend.ide.XtendEditorScope");
	}

	public void configureOverrideIndicatorSupport(Binder binder) {
		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("OverrideIndicatorModelListener")) //$NON-NLS-1$
				.to(OverrideIndicatorModelListener.class);
		binder.bind(IActionContributor.class).annotatedWith(Names.named("OverrideIndicatorRulerAction")).to( //$NON-NLS-1$
				OverrideIndicatorRulerAction.class);
	}
	
	public Class<? extends IFormattingPreferenceValuesProvider> bindIFormattingPreferenceValuesProvider() {
		return FormatterPreferenceValuesProvider.class;
	}

	@Override
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return RichStringAwareTokenScanner.class;
	}

	public Class<? extends TerminalsTokenTypeToPartitionMapper> bindTerminalsTokenTypeToPartitionMapper() {
		return TokenTypeToPartitionMapper.class;
	}

	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace"))
				.to(ShowWhitespaceCharactersActionContributor.class);
	}

	@Override
	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return SingleLineCommentHelper.class;
	}

	public Class<? extends XtextSourceViewer.Factory> bindSourceViewerFactory() {
		return RichStringAwareSourceViewer.Factory.class;
	}

	public Class<? extends ToggleSLCommentAction.Factory> bindToggleCommentFactory() {
		return RichStringAwareToggleCommentAction.Factory.class;
	}

	public Class<? extends IFoldingStructureProvider> bindIFoldingStructureProvider() {
		return InitiallyCollapsableAwareFoldingStructureProvider.class;
	}

	@Override
	public ICharacterPairMatcher bindICharacterPairMatcher() {
		return new DefaultCharacterPairMatcher(new char[] { '(', ')', '{', '}', '[', ']', '´', 'ª' });
	}


	@Override
	public Class<? extends IRenameContextFactory> bindIRenameContextFactory() {
		return XtendRenameContextFactory.class;
	}


	@Override
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return TemplateProposalProvider.class;
	}

	public Class<? extends ITraceForStorageProvider> bindTraceInformation() {
		return TraceForStorageProvider.class;
	}

	public Class<? extends IEditedResourceProvider> bindIEditedResourceProvider() {
		return FormatterResourceProvider.class;
	}

	public void configureFilterSyntheticMembersContribution(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("FilterSyntheticsContribution"))
				.to(ShowSyntheticMembersContribution.class);
	}

	@Override
	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator> bindXbaseUIValidator() {
		return org.eclipse.xtend.ide.validator.XtendUIValidator.class;
	}
	
	@SingletonBinding(eager = true)
	public Class<? extends JavaProjectPreferencesInitializer> bindJavaProjectPreferencesInitializer() {
		return JavaProjectPreferencesInitializer.class;
	}

	@Override
	public void configureSmartCaretPreferenceInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("smartCaretPreferenceInitializer")) //$NON-NLS-1$
				.to(XtendPreferenceStoreInitializer.class);
	}
	
	public Class<? extends IssueSeveritiesProvider> bindIssueSeverityServiceProvider() {
		return XbaseIssueSeveritiesProvider.class;
	}
	
	public Class<? extends XtextSourceViewerConfiguration> bindSourceViewerConfiguration(){
		return XtendSourceViewerConfiguration.class;
	}

	public Class<? extends DocumentTokenSource> bindDocumentTokenSource(){
		return XtendDocumentTokenSource.class;
	}
	

	@Override
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return XtendContentAssistFactory.class;
	}
	
	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return XbaseResourceForEditorInputFactory.class;
	}
	
	public Class<? extends IContextInformationProvider> bindIContextInformationProvider() {
		return ParameterContextInformationProvider.class;
	}
	
	public Class<? extends PrefixMatcher.CamelCase> bindCamelCasePrefixMatcher() {
		return EscapeSequenceAwarePrefixMatcher.class;
	}
}