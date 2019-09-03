package com.adminbuilder.configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;



public class ConfParser {
	private File [] files;

	private String currentfile ;
	
	private final String DOT = "\\.";
	private final String PROPERTy = "property";
	private Boolean propertyFlag = false;
	public ConfParser(File [] Files){
	        this.files = Files;

	}
	
	public void readPropFiles(){
		try
		{
			
			for ( File filename : files )
			{
				propertyFlag = filename.getName().split(DOT)[1].equalsIgnoreCase(PROPERTy)?true:false;
				this.currentfile= filename.getName().replaceAll(".property", "");
				if(propertyFlag){
					System.out.println("Reading "+ currentfile);
					ConfProvider.getInstance().addFileName(currentfile);

					readpropdata( new FileInputStream( filename ), propertyFlag);
				}
			    
			}
		}
		catch (FileNotFoundException file){
		
			System.out.println("The File "+currentfile+" could not load due to exception"+file);		}
	
		
	}
	
	public void readpropdata(InputStream stream, Boolean propertyFlag){
		Properties prop = new Properties();
        
        try
        {
            prop.load(stream);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some issue finding or loading file....!!! " + e.getMessage());

        }
        for (final Entry<Object, Object> entry : prop.entrySet()) {
            
            ConfProvider.getInstance().addtestdata((String) entry.getKey()+"."+currentfile,(String) entry.getValue());
            
        }
		
	}
	
}


