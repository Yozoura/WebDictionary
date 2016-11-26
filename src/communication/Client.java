package communication;

import java.io.*;
import java.net.*;

public class Client {
	//端口
	static int port=8000;
	static Socket socket=null;
	static DataOutputStream  out=null;
	static DataInputStream  in=null;
	
	public static void main(String []args) throws IOException {
		//TODO:GUI界面初始化
		
		
		
		//*****************	
		//test
		connect();
		searchWord("love");
	}
	
	public static void connectPort(){
		try{//客户端初始化
			socket=new Socket("localhost",port);
			out=new DataOutputStream(socket.getOutputStream());
			in=new DataInputStream(socket.getInputStream());
		}
		catch(Exception e){		
		}
	}
	
	public static void connect() {
		connectPort();
		try{
			out.writeUTF("0|请求连接");
			String news=in.readUTF();
			//TODO:服务器连接接口
			System.out.println(news);
			
			
			//*****************
			socket.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void searchWord(String word){
		connectPort();
		try {
			out.writeUTF("1|"+word);
			String news=in.readUTF();
			String wordEx[]=news.split("\\|");
			String youdaoEx=wordEx[0];
			String baiduEx=wordEx[1];
			String bingEx=wordEx[2];
			//TODO:词典查找接口
			System.out.println(youdaoEx);
			System.out.println(baiduEx);
			System.out.println(bingEx);
			
			//*****************
			socket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
