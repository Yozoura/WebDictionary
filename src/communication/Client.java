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
		try{//�ͻ��˳�ʼ��
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
}
