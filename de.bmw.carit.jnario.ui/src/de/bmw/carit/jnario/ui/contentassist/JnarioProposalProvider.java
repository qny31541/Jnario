/*
 * generated by Xtext
 */
package de.bmw.carit.jnario.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import de.bmw.carit.jnario.ui.contentassist.AbstractJnarioProposalProvider;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class JnarioProposalProvider extends AbstractJnarioProposalProvider {

	@Override
	public void complete_FEATURE_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Feature: ", context));
	}
	
	@Override
	public void complete_BACKGROUND_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Background: ", context));
	}
	
	@Override
	public void complete_SCENARIO_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Scenario: ", context));
	}
	
	@Override
	public void complete_GIVEN_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Given ", context));
	}
	
	@Override
	public void complete_WHEN_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("When ", context));
	}
	
	@Override
	public void complete_THEN_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Then ", context));
	}
	
	@Override
	public void complete_EXAMPLE_TEXT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Examples: ", context));
	}
}
