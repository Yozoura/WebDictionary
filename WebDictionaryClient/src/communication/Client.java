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
		searchWord("love");
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
			out.writeUTF("0|��������");
			String news=in.readUTF();
			//TODO:���������ӽӿ�
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
			//TODO:�ʵ���ҽӿ�
			System.out.println(youdaoEx);
			System.out.println(baiduEx);
			System.out.println(bingEx);
			
			//*****************
			socket.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
