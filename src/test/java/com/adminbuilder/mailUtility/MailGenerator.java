package com.adminbuilder.mailUtility;

public class MailGenerator {
private static MailGenerator InstanceProvider = new MailGenerator();
	

	private MailParser mailParser;
	private MailGenerator(){
		
	}
	
	public static MailGenerator getInstance(){
		return InstanceProvider;
	}
	
	public void setMailGenerator(MailParser parser) throws InterruptedException{
		this.mailParser = parser;
		mailParser.emailReport();
		
	}
	
	

}
