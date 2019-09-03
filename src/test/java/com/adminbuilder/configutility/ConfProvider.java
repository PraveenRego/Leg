package com.adminbuilder.configutility;



import java.util.LinkedHashMap;

public class ConfProvider {
	
private static ConfProvider InstanceProvider = new ConfProvider();
	
	private LinkedHashMap<String,String> TestMap = new LinkedHashMap<String,String>();
	
	

	private ConfParser confParser;
	private ConfProvider(){
		
	}
	
	public static ConfProvider getInstance(){
		return InstanceProvider;
	}
	
	public void addFileName(String fileName){
	}
	
	public void addtestdata(String key,String data){ 
		this.TestMap.put(key, data);
	}
	
	public void setConfProvider(ConfParser parser){
		this.confParser = parser;
		confParser.readPropFiles();
		
	}
	
	public LinkedHashMap<String,String> getTestMap(){
		return this.TestMap;
	}

}
