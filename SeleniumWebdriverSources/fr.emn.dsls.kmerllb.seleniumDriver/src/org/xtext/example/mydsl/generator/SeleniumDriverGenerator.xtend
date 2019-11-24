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

	private static int variableIt = 0;
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (ts : resource.allContents.toIterable.filter(TestSuite)) {
			fsa.generateFile(FirstUpperCase(ts.suiteName)+"Test" + ".java", ts.generateTestSuite)
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

	def generateTestCaseBody(TestCase tc) {
		variableIt = 0
		
		return '''
	private static void  �tc.caseName�() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		�FOR line : tc.lines�
			�IF line instanceof Action�
				�line.parseLigne�
			�ENDIF�
			�IF line instanceof VariableAssignation�
				�line.parseLigne�
			�ENDIF�
		�ENDFOR�
		
		driver.close();
	}
	'''
	}
	
	def parseLigne(VariableAssignation line){
		return getWebElementAttributeType(line.value)+" "+line.^var.name+" = "+findWebElement(line.value);
	}
	
	def getWebElementAttributeType(WebElement we){
		if(we.attribute !== null){
			switch(we.attribute){
				case "text" : return "String"
				default : return "WebElement"
			}
		}
		
		return "ERROR";
	}
	
	def parseLigne(Action action){ 
		if( action.elem instanceof WebElement){
			if(action.command.equals("exist")){
				return parseExist(action.elem);
			}
			else if(action.command.equals("equals")) {
				return parseEquals(action.elem, action.param);
			}
			else {
				return createWebElement(action.elem as WebElement)+"\n"+
				parseCommand(action.command, action.param,(action.elem as WebElement).type+variableIt);
			}
		}
		
		if(action.elem instanceof VariableRef)
			return  (action.elem as VariableRef).ref.name;
			
		if(action.elem instanceof GlobalElement)
			return "driver"+parseCommand(action.command, action.param,"");
	}
	
	
	def parseExist(Element elem)'''
		�IF elem instanceof WebElement�
			�elem.createWebElement�
			Assert.assertNotNull(�elem.type+variableIt�);
		�ENDIF�
	'''
	
	def parseEquals(Element elem, Parameter param)'''
		�IF elem instanceof WebElement�
			�elem.createWebElement�
			Assert.assertTrue(�elem.type+variableIt�.getText().equals(�(param as VariableRef).ref.name�));
		�ENDIF�
	'''
	
	def parseCommand(String command,Parameter param,String nomElem){
		
	    switch command {	
      		case 'click'	: '''�nomElem�.click();'''
      		case 'goTo' 	: '''.get(�param.parseParameter�);
      		
new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click();
	
''' 
      		case 'write' 	: '''�nomElem�.sendKeys(�param.parseParameter�);''' 
      		case 'select' 	: '''�nomElem�.click();''' 
      		case 'check' 	: '''if ( !�nomElem�.isSelected() ){�nomElem�.click()}''' 
      		case 'uncheck' 	: '''if ( �nomElem�.isSelected() ){�nomElem�.click()})''' 
      		case 'parent'  	: "TODO"
      		default : ""
   		 }
    }
    
    def parseParameter(Parameter param){
    	if(param instanceof WebElement){
    		return createWebElement(param)+"\n";
    	}

		if(param instanceof VariableRef){
			return param.getRef().getName();
		}
	
		return "\""+param.param+"\"";
    }
    
    def createWebElement(WebElement we){
    	variableIt++;
    	
    	if(we.type == "title"){
    		return "WebElement title"+variableIt+" = driver.findElement(By.xpath(\"//title\"));";
    	}
    	
    	return "WebElement "+we.type+variableIt+" = "+findWebElement(we);
   	}
   	
   	 def findWebElement(WebElement we){	
   		return "driver.findElements("+parseWebElementSelector(we.selector, we.type)+").get("+we.index+")"+parseAttribute(we.attribute);
   	}
   	
   	def parseWebElementSelector(Selector selector, String elementType){
   		
   		var type = getWebElementHtmlType(elementType);
   		
		if( selector instanceof Attributes) {	
	   		if(elementType == "link"){
	   			return "By.partialLinkText(new String(\""+parseAttributeValue(selector.getAttrs().get(0).value)+"\").toUpperCase())"
	   		}
	   		
			for(Attribute att: selector.getAttrs()){
				return "By.xpath(\"//"+type+getHtmlAttributeType(att.getAttType)+parseAttributeValue(att.value)+"']\")";
			}
			
			return "todo plusieurs attributs";
		}
		else{
			return "By.tagName(\""+type+"\")"
		}
   	}
   	

   	
   	def parseAttributeValue(AttributeValue attV){
   		if(attV.^val === null){
		   	return (attV as StringValue).ref;
		}
   		else{
   			return "\" + "+ attV.^val.ref.name +"+\" "
   		}
   	}
   	
   	def getHtmlAttributeType(String type){
   		switch type {
			case "content" : return "[text()='"
			case "alt" : return "[@alt='"
			case "label" : return "[label()='"
			case "id" : return "[id()='"
			case "value" : return "[text()='"
			case "class" : return "[@class()='"
			case "href" : return "[href()='"
			default : ""
		}
   	}
   	
   	def getWebElementHtmlType(String type){
   		switch type {
   			case "link": return "a"
   			default: return "*"
   		}
   	}
   	
   	def parseAttribute(String attribute){
   		switch attribute {
			case "text" : return ".getText();"
			default : ";"
		}
   	}
	
	def static String FirstUpperCase(String str) {
    	return  str.substring(0, 1).toUpperCase() + str.substring(1);
  	}
}
