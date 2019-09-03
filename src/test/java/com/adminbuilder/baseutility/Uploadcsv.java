//package com.adminbuilder.baseutility;
//
//public class Uploadcsv {
//	
//	public static boolean uploadFile(String webServiceUrl, String filePath)
//	  {
//	    uploadSuccessfull = false;
//	    if (isWebServiceAvailable(webServiceUrl))
//	    {
//	      File inFile = new File(filePath);
//	      FileInputStream fis = null;
//	      try
//	      {
//	        fis = new FileInputStream(inFile);
//	        CloseableHttpClient httpclient = HttpClients.createDefault();
//	        
//	        HttpPost httppost = new HttpPost(webServiceUrl);
//	        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//	        
//	        builder.addBinaryBody("file", new FileInputStream(inFile), ContentType.APPLICATION_OCTET_STREAM, inFile
//	          .getName());
//	        
//	        HttpEntity multipart = builder.build();
//	        httppost.setEntity(multipart);
//	        
//	        CloseableHttpResponse response = httpclient.execute(httppost);
//	        
//	        int statusCode = response.getStatusLine().getStatusCode();
//	        if (statusCode == 200) {}
//	        return true;
//	      }
//	      catch (ClientProtocolException e)
//	      {
//	        System.err.println("Unable to make connection");
//	        e.printStackTrace();
//	      }
//	      catch (IOException e)
//	      {
//	        System.err.println("Unable to read file");
//	        e.printStackTrace();
//	      }
//	      finally
//	      {
//	        try
//	        {
//	          if (fis != null) {
//	            fis.close();
//	          }
//	        }
//	        catch (IOException localIOException4) {}
//	      }
//	    }
//	  }
//	
//	public static boolean isWebServiceAvailable(String webServiceUrl)
//	  {
//	    return "Available".equals(checkServiceAvailability("GET", webServiceUrl, nullString, nullString));
//	  }
//
//}
