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
	
	def static String FirstUpperCase(String str) {
    	return  str.substring(0, 1).toUpperCase() + str.substring(1);
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
	'''}
	
	def parseLigne(VariableAssignation line)'''
		String �line.^var.name� = �line.value.findWebElement�
	'''
	
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
	
      		case 'write' 	: '''�nomElem�.write(�param.parseParameter�)''' 
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
		{	return createWebElement(param)+"\n"}

		if( param instanceof VariableRef)
		{	return param.getRef().getName();}
	
		return ''' "�param.param�" ''' ;
		
    }
    
    def createWebElement(WebElement we)
    {	variableIt++;
    	switch we.type {
     		case "link" 	: '''WebElement link�variableIt� = �we.findWebElement�''' 
     		case "button" 	: '''WebElement button�variableIt� �we.findWebElement�''' 
     		case "field" 	: '''WebElement field�variableIt� = �we.findWebElement�''' 
     		case "image" 	: '''WebElement image�variableIt� = �we.findWebElement�''' 
     		case "div"	 	: '''WebElement div�variableIt� = �we.findWebElement�''' 
     		case "checkbox"	: '''WebElement checkbox�variableIt� =�we.findWebElement�''' 
     		case "combobox" : '''WebElement combobox�variableIt� = �we.findWebElement�''' 
     		case "title"	 : '''WebElement title�variableIt� = driver.findElement(By.xpath("//title"));''' 
   
      		default : ""
   		 }
   	}
   	
   	 def findWebElement(WebElement we)
    {	
    	
    	switch we.type {
     		case "link" 	: '''driver.findElements(�we.selector.parseWebElementSelector("a")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "button" 	: '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "field" 	: '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "image" 	: '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "div"	 	: '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "checkbox"	: '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "combobox" : '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
     		case "title"	 : '''driver.findElements(�we.selector.parseWebElementSelector("*")�).get(�we.index�)�we.attribute.parseAttribute�''' 
   
      		default : ""
   		 }
   	}
   	
   	def parseWebElementSelector(Selector selector,String type){
   	
		if( selector instanceof Attributes)
		{	
			for(Attribute att: selector.getAttrs()){
				switch att.getAttType{
					case "content" : return "By.xpath(\"//"+type+"[text()='"+parseAttributeValue(att.value)+"']\")"
					case "alt" : return "By.xpath(\"//"+type+"[@alt='"+parseAttributeValue(att.value)+"']\")"
					case "label" : return "By.xpath(\"//"+type+"[label()='"+parseAttributeValue(att.value)+"']\")"
					case "id" : return "By.xpath(\"//"+type+"[id()='"+parseAttributeValue(att.value)+"']\")"
					case "value" : return "By.xpath(\"//"+type+"[text()='"+parseAttributeValue(att.value)+"']\")"
					case "class" : return "By.xpath(\"//"+type+"[@class()='"+parseAttributeValue(att.value)+"']\")"
					case "href" : return "By.xpath(\"//"+type+"[href()='"+parseAttributeValue(att.value)+"']\")"
				}
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
   	
 
   	
   	def parseAttribute(String attribute){
   		switch attribute {
			case "text" : return ".getText();"
			default : ";"
		}
   	}
}
