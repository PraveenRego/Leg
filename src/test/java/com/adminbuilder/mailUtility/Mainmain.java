package com.adminbuilder.mailUtility;

import org.junit.Test;

import com.adminbuilder.configutility.ConfReader;

public class Mainmain {
	
//	public static void main(String[] args) throws InterruptedException {
//		ConfReader.getInstance().loadConfData();
//		MailGenerator.getInstance().setMailGenerator(new MailParser());
//	}
	
	
	@Test
	public void mail() throws InterruptedException {
		ConfReader.getInstance().loadConfData();
		MailGenerator.getInstance().setMailGenerator(new MailParser());
	}

}
