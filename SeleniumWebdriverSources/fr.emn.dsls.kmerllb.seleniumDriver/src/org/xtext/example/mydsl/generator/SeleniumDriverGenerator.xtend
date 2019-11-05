/*
 * generated by Xtext 2.17.0
 */
package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.mydsl.seleniumDriver.*

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class SeleniumDriverGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (ts : resource.allContents.toIterable.filter(TestSuite)) {
			//TODO force fisrt letter to uppercase
			fsa.generateFile(ts.suiteName+"Test" + ".java", ts.generateTestSuite)
		
		}
	
	}
	
	def generateTestSuite(TestSuite ts) '''
	import seleniumDriver.TestSuite;
	
	public class �ts.suiteName�Test {
	
		public static void main(String[] args) { 
			
			�FOR tc : ts.cases�
				�tc.caseName�();
			�ENDFOR�
						
		} 
		
		�FOR tc : ts.cases�
		 	�tc.generateTestCaseBody�
		�ENDFOR�
	}
	'''
	

	def generateTestCaseBody(TestCase tc) '''
	private static void  �tc.caseName�() {
		�FOR line : tc.lines�
			�IF line instanceof Action�
						�line.parseLigne�
			�ENDIF�
			�IF line instanceof VariableAssignation�
						�line.parseLigne�
			�ENDIF�
		�ENDFOR�
	}
	'''
	
	def parseLigne(VariableAssignation line) '''
		//Todo capitalize first letter
		�line.value.type� �line.^var.name� = driver.todo;
	'''
	def parseLigne(Action action) '''
		
		�action.elem.parseElement�
		�action.command.parseCommand(action.param)�
			
		

	'''
	
	def parseElement(Element elem)
	{	if( elem instanceof WebElement)
		{	return "todo webelement"}

		if( elem instanceof VariableRef)
		{	return "todo variableref";}
	}
	
	def parseCommand(String command,Parameter param){
	    switch command {
     		case "open" 	: 
     		''' 
     			WebDriver driver = new ChromeDriver();
     			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
     		'''
      		case 'click'	: "It's some string."
      		case 'goTo' 	: ''' driver.get(�param.parseParameter�);''' 
      		case 'exist' 	: "It's some string."
      		case 'write' 	: ''' write(�param.parseParameter�);''' 
      		case 'select' 	: "It's some string."
      		case 'check' 	: "It's some string."
      		case 'uncheck' 	: "It's some string."
      		case 'parent'  	: "It's some string."
      		default : ""
   		 }
    }
    
    def parseParameter(Parameter param)
    {
    	if( param instanceof WebElement)
		{	return "todo webelement"}

		if( param instanceof VariableRef)
		{	return "todo variableref";}
	
		return ''' "param.param" ''' ;
		
    }
	
		

	
	
	
	
}
