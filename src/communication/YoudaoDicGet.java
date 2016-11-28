package communication;

import java.net.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class YoudaoDicGet {
	/*
	public static void main(String[] args) throws Exception{
		captureJavascript("love");
	}
	//*/
	public static String[] Trans(String word) throws Exception {  
		ArrayList<String> save=new ArrayList<String>();
	    String strURL = "http://www.youdao.com/w/eng/" + word  +"/";
	    URL url = new URL(strURL);  
	    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
	    InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");  
	    BufferedReader bufReader = new BufferedReader(input);  
	    String line = "";  
	    StringBuilder contentBuf = new StringBuilder();  
	    while ((line = bufReader.readLine()) != null) {  
	        contentBuf.append(line);  
	    }
	    bufReader.close();
	    String content=contentBuf.toString();
	    
        Pattern searchMeanPattern = Pattern.compile("(?s)<div class=\"trans-container\">(.*?)</div>");
        Matcher m1 = searchMeanPattern.matcher(content); 
        if (m1.find()) {
        	{
        		String means = m1.group(1);
        		Pattern ifHasH4=Pattern.compile("<h4>(.*?)</h4>");
        		Matcher m2=ifHasH4.matcher(means);
        		if(!m2.find()){
        			Pattern getChinese = Pattern.compile("(?m)<li>(.*?)</li>"); 
        			Matcher m3 = getChinese.matcher(means);
        			while (m3.find()) {              
        				//System.out.println(m2.group(1));
        				save.add(m3.group(1));
        			}
        		}
        		
        	}
        }
        
        if(save.size()==0){
        	String result[]=new String[1];
        	result[0]=word;
        	return result;
        }
        else{
        	int size=save.size();
        	String result[]=new String[size];
        	for(int i=0;i<size;i++){
        		result[i]=save.get(i);
        	}
        	return result;
        }
	}
	
}
