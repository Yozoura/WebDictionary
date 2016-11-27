package communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BingDicGet {
	public static String[] Trans(String word) throws Exception {  
		ArrayList<String> save=new ArrayList<String>();
	    String strURL = "http://cn.bing.com/dict/search?q="+word;
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
	    
        Pattern searchMeanPattern = Pattern.compile("(?s)<div class=\"hd_area\">(.*?)<ul>(.*?)</ul></div>");
        Matcher m1 = searchMeanPattern.matcher(content); 
        if (m1.find()) {
            String means = m1.group(2);
            Pattern getChinese = Pattern.compile("(?m)<li><span class=\"pos\">(.*?)</span><span class=\"def\"><span>(.*?)</span></span></li>"); 
            Matcher m2 = getChinese.matcher(means);         
            while (m2.find()) {              
                //System.out.println(m2.group(1));
            	save.add(m2.group(1)+m2.group(2));
            }
            Pattern getWebChinese = Pattern.compile("(?m)<li><span class=\"pos web\">(.*?)</span><span class=\"def\"><span>(.*?)</span></span></li>"); 
            Matcher m3 = getWebChinese.matcher(means);         
            while (m3.find()) {              
                //System.out.println(m2.group(1));
            	save.add(m3.group(1)+":"+m3.group(2));
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
