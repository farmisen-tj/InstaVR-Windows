package com.sapizon.instavr.TestRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.sapizon.instavr.test.T007_Test_Click_Authoring_Add_VR_Contents;

public class AddContent {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		XmlSuite xmlSuit = new XmlSuite();
		xmlSuit.setName("TestNGSuite");
		
		XmlTest xmltest = new XmlTest(xmlSuit);
		xmltest.setName("Test");
		xmltest.setPreserveOrder("true");
		
		
		XmlClass publicTestClass = new XmlClass(T007_Test_Click_Authoring_Add_VR_Contents.class);
		List<XmlClass> list = new ArrayList<XmlClass>();
		list.add(publicTestClass);
		
		xmltest.setXmlClasses(list);
		
		TestNG testng = new TestNG();
		List<XmlSuite> suite = new ArrayList<XmlSuite>();
		suite.add(xmlSuit);
		testng.setXmlSuites(suite);
		testng.run();
	}

}
