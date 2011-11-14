/*
 * generated by Xtext
 */
package de.bmw.carit.jnario.spec;

import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticMethodsFeatureForTypeProvider.ExtensionClassNameProvider;
import org.eclipse.xtext.xtend2.compiler.Xtend2OutputConfigurationProvider;
import org.eclipse.xtext.xtend2.resource.Xtend2Resource;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import de.bmw.carit.jnario.common.scoping.JnarioExtensionClassNameProvider;
import de.bmw.carit.jnario.spec.jvmmodel.ExtendedJvmTypesBuilder;
import de.bmw.carit.jnario.spec.scoping.SpecImportedNamespaceScopeProvider;
import de.bmw.carit.jnario.spec.scoping.SpecScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SpecRuntimeModule extends de.bmw.carit.jnario.spec.AbstractSpecRuntimeModule {

	
	public Class<? extends JvmTypesBuilder> bindJvmTypesBuilder(){
		return ExtendedJvmTypesBuilder.class;
	}
	
	@Override
	public java.lang.Class<? extends IScopeProvider> bindIScopeProvider() {
		return SpecScopeProvider.class;
	}
	

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
		.to(SpecImportedNamespaceScopeProvider.class);
	}
	
	
	public Class<? extends OutputConfigurationProvider> bindOutputConfigurationProvider() {
		return Xtend2OutputConfigurationProvider.class;
	}
	
	public Class<? extends ExtensionClassNameProvider> bindExtensionClassNameProvider(){
		return JnarioExtensionClassNameProvider.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return Xtend2Resource.class;
	}
	
	
}
