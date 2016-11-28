package communication;

import java.io.*;
import java.net.*;

public class Client {
	//设定端口
	static int port=8000;
	static Socket socket=null;
	static DataOutputStream  out=null;
	static DataInputStream  in=null;
	
	public static void main(String []args) throws IOException {
		//TODO:GUI初始化接口
		
		
		
		//*****************	
		//test
		connect();
		searchWord("supermans");
	}
	
	public static void connectPort(){
		try{//
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
			out.writeUTF("0|request connection");
			String news=in.readUTF();
			//TODO:
			System.out.println(news);
			
			
			//*****************
			socket.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static String[] searchWord(String word){
		connectPort();
		String wordEx[]=null;
		try {
			out.writeUTF("1|"+word);
			String news=in.readUTF();
			wordEx=news.split("\\|");
			/*
			String youdaoEx=wordEx[0];
			String baiduEx=wordEx[1];
			String bingEx=wordEx[2];
			*/
			for(int i=0;i<3;i++){
			System.out.println(wordEx[i]);
			}
			socket.close();
			return wordEx;
			//TODO:
			
			
			//*****************
			
		} catch (IOException e) {
			// TODO 
			
			
			e.printStackTrace();
			//******************
		}
		return wordEx;
	}
	
	public static void sendLike(int i) throws IOException{
		connectPort();
		out.writeUTF("2|"+Integer.toString(i));
		socket.close();
	}
	
	public static void like(String dicType) throws IOException{
		switch(dicType){
		case "youdao":sendLike(0);break;
		case "baidu":sendLike(1);break;
		case "bing":sendLike(2);break;
		default:break;
		}
	}
	
	public static boolean userRegister(String name,String key,String email) throws IOException{
		boolean registerSuccess=false;
		connectPort();
		out.writeUTF("3|"+name+"|"+key+"|"+email);
		String news=in.readUTF();
		if(news=="1"){
			registerSuccess=true;
		}
		socket.close();
		return registerSuccess;
	}
	
	public static boolean userLogin(String name,String key) throws IOException{
		boolean loginSuccess=false;
		connectPort();
		out.writeUTF("4|"+name+"|"+key);
		String news=in.readUTF();
		if(news=="1"){
			loginSuccess=true;
		}
		socket.close();
		
		
		return loginSuccess;
	}
	
	public static void userLogout(String name) throws IOException{
		connectPort();
		out.writeUTF("5|"+name);
		socket.close();
		return;
	}
	
	//更新在线用户
	public static void updateUserLogedin() throws IOException{
		connectPort();
		out.writeUTF("6");
		String news=in.readUTF();
		socket.close();
		//TODO:更新在线用户 列表数据  GUI接口
		
		
		//***************************
		return;
	}
}
