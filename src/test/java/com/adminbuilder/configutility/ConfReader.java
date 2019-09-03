package com.adminbuilder.configutility;


import java.io.File;
import java.util.LinkedHashMap;



public class ConfReader {
	
	private static ConfReader InstanceReader = new ConfReader();
	//private static File useFolder = new File("./Configuration");
	private static String path = new File("./Configuration").getAbsolutePath();
	private static File useFolder = new File(path);
	public static ConfReader getInstance(){
		return InstanceReader;
	}
	
	public void loadConfData(){
		File [] files = useFolder.listFiles();
		ConfProvider.getInstance().setConfProvider(new ConfParser(files));
	}
	
	LinkedHashMap<String,String> data = ConfProvider.getInstance().getTestMap();
	
	public String getConfData( String Keyname, String filename){
		return data.get(Keyname +"."+ filename);
	}
}
