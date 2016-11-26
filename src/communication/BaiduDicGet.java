package communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduDicGet {
	public static String[] Trans(String word) throws Exception {  
		ArrayList<String> save=new ArrayList<String>();
	    String strURL = "http://dict.baidu.com/s?wd="+word+"&ptype=english";
	    URL url = new URL(strURL);  
	    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
	    InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");  
	    BufferedReader bufReader = new BufferedReader(input);  
	    String line = "";  
	    StringBuilder contentBuf = new StringBuilder();  
	    while ((line = bufReader.readLine()) != null) {  
	        contentBuf.append(line);  
	    }   
	    String content=contentBuf.toString();
	    
        Pattern searchMeanPattern = Pattern.compile("(?s)<div class=\"en-content\">(.*?)</div>");
        Matcher m1 = searchMeanPattern.matcher(content); 
        if (m1.find()) {
            String means = m1.group();
            Pattern getChinese = Pattern.compile("(?m)<strong>(.*?)</strong><span>(.*?)</span>"); 
            Matcher m2 = getChinese.matcher(means);
            while (m2.find()) {              
                //System.out.println(m2.group(1));
            	save.add(m2.group(1)+m2.group(2));
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
