package com.adminbuilder.mailUtility;


import java.io.File;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.adminbuilder.configutility.ConfReader;






public class MailParser {
	private Properties props = new Properties();
	private final String reportPath = new File("").getAbsolutePath() + "//Reports//" + ConfReader.getInstance().getConfData("reportname", "mailUtility") + ".html";	
	
	public void emailReport() throws InterruptedException {
	
		if(ConfReader.getInstance().getConfData("generateemail", "mailUtility").equalsIgnoreCase("Yes")) {
		try{
			
			props.setProperty(ConfReader.getInstance().getConfData("key", "mailUtility"), ConfReader.getInstance().getConfData("value", "mailUtility"));
			Message msg = new MimeMessage(Session.getDefaultInstance(props, null));
		
		
		CommandMap.setDefaultCommandMap(getCommandmap((MailcapCommandMap)CommandMap.getDefaultCommandMap()));
		
		if (reportPath==null ||reportPath.equals("")){
			System.out.println("report path is null, Please set the report path");
			
		}
		else{
			System.out.println("The report path is set to : " +reportPath);
		msg.setFrom(new InternetAddress(ConfReader.getInstance().getConfData("addressFrom", "mailUtility")));
		msg.setRecipients(Message.RecipientType.TO, readrecepients(ConfReader.getInstance().getConfData("recipients", "mailUtility")));
		msg.setSubject(ConfReader.getInstance().getConfData("reportname", "mailUtility"));
		msg.setContent(getMailcontent(getMailbody(new MimeBodyPart(), ConfReader.getInstance().getConfData("mailbody", "mailUtility") + "\n"),
					getMailattachment(new MimeBodyPart(), new FileDataSource(reportPath)), new MimeMultipart()));

		
		File f = new File(reportPath);
		if (f==null || !f.exists())
				System.out.println( "File "+reportPath + " does not exist. Please Check the path");
		else {
				System.out.println("Sending E-mail with the html Result");
				
				Transport.send(msg);

			}
		}
	}
		
	
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Cannot send email. Exception:"+e.getMessage() );
	}
		}
		
	}
	
	public InternetAddress[] readrecepients(String address) throws AddressException{
		String[] recipientsArray = address.split(";");
 		InternetAddress[] addressTo = new InternetAddress[recipientsArray.length]; 
		for (int i = 0; i < recipientsArray.length; i++)
		{
			addressTo[i] = new InternetAddress(recipientsArray[i]);
		} 
		return addressTo;
	}
	
	public MailcapCommandMap getCommandmap(MailcapCommandMap mc) {
		mc = (MailcapCommandMap)CommandMap.getDefaultCommandMap();
		mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		
		return mc;
		
	}
	
	public MimeBodyPart getMailbody(MimeBodyPart mbp1, String body) throws MessagingException {
		mbp1.setText(body);
		return mbp1;
	}

	public MimeBodyPart getMailattachment(MimeBodyPart mbp2, FileDataSource fds) throws MessagingException {
		mbp2.setDataHandler(new DataHandler(fds));
		mbp2.setFileName(fds.getName());
		
		return mbp2;
		
	}
	
	public Multipart getMailcontent(MimeBodyPart mbp1, MimeBodyPart mbp2,Multipart mp) throws MessagingException {
		mp.addBodyPart(mbp1);
		mp.addBodyPart(mbp2);
		
		return mp;
		
	}
	
	
	

}
