package communication;

import java.io.*;
import java.net.*;

public class Client {
	//�˿�
	static int port=8000;
	static Socket socket=null;
	static DataOutputStream  out=null;
	static DataInputStream  in=null;
	
	public static void main(String []args) throws IOException {
		//TODO:GUI�����ʼ��
		
		
		
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
			out.writeUTF("0|请求连接");
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
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
}
