package org.jnario.suite.unit

import org.jnario.suite.naming.SuiteQualifiedNameProvider
import com.google.inject.Inject
import org.jnario.jnario.test.util.ModelStore
import org.jnario.runner.CreateWith
import org.jnario.jnario.test.util.SuiteTestCreator

@CreateWith(typeof(SuiteTestCreator))
describe SuiteQualifiedNameProvider {

	@Inject extension ModelStore

	fact "removes suite prefix"{
		parseSuite('''
			#My Suite''')
		qualifiedName => "My Suite"
	}
	
	fact "removes suite trailing text"{
		parseSuite('''
			#My Suite
			with description''')
		qualifiedName => "My Suite"
	}
	
	fact "add suite package"{
		parseSuite('''
			package test
			#My Suite''')
		qualifiedName => "test.My Suite"
	}
	
	def qualifiedName(){
		subject.getFullyQualifiedName(firstSuite).toString		
	}
}