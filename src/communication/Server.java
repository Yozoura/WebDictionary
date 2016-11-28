package communication;

import communication.BaiduDicGet;
import communication.YoudaoDicGet;
import communication.BingDicGet;
import java.io.*;
import java.net.*;

//服务器端
public class Server {
	//�趨�˿�
	static int port=8000;
	
	public static void main(String[] args)throws Exception{		
		//DicSearch Demo
		/*
		String test[]=YoudaoDicGet.Trans("superman");
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}
		*/
			
		///*
		//����ServerSocket
		ServerSocket server=new ServerSocket(port);	
		//server.close();	
		while(true){//���ʽ���տͻ���socket
			Socket socket=server.accept();
			//�������̴߳���
			Thread thread=new Thread(new Task(socket));
			thread.start();
		}
		//*/
	}


//���߳���
static class Task implements Runnable{
	private Socket socket;
	
	public Task(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
		try{
			handleSocket();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//socket����
	private void handleSocket()throws Exception{
		//������
		DataInputStream in=null;
		in=new DataInputStream(socket.getInputStream());
		
		//���Ĵ���
		String news=in.readUTF();
		String newsAnalyse[]=news.split("\\|");
		String responseNews=handleNews(newsAnalyse);
		//�����
		DataOutputStream out=null;
		out=new DataOutputStream(socket.getOutputStream());
		out.writeUTF(responseNews);
		
		out.close();
		in.close();
	}
	
	public String handleNews(String news[]){
		if(news.length==0){
			return null;
		}
		String responseNews="";
		switch(news[0]){
		case "0":System.out.println("Client request connect");
			responseNews="Server has connected.";
			break;
		case "1":String word=news[1];//���Ҵʵ�
			try{
				if(ifIsWord(word)){//�����һ������
					String youdaoEx[]=YoudaoDicGet.Trans(word);
					String baiduEx[]=BaiduDicGet.Trans(word);
					String bingEx[]=BingDicGet.Trans(word);
					StringBuilder wordEx=new StringBuilder(responseNews);			
					for(int i=0;i<youdaoEx.length;i++){
						wordEx.append(youdaoEx[i]);
						wordEx.append("\n");
					}
					wordEx.append("|");
					for(int i=0;i<baiduEx.length;i++){
						wordEx.append(baiduEx[i]);
						wordEx.append("\n");
					}
					wordEx.append("|");
					for(int i=0;i<bingEx.length;i++){
						wordEx.append(bingEx[i]);
						wordEx.append("\n");
					}
					responseNews=wordEx.toString();
				}
				else{//�������һ������
					StringBuilder wordEx=new StringBuilder(responseNews);
					wordEx.append(word);
					wordEx.append("|");
					wordEx.append(word);
					wordEx.append("|");
					wordEx.append(word);
					responseNews=wordEx.toString();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			break;
		case "2"://�ʵ����
			like(Integer.parseInt(news[1]));
			break;
		case "3"://�û�ע��
			String registerName=news[1];
			String registerKey=news[2];
			String registerEmail=news[3];
			if(userRegister(registerName,registerKey,registerEmail)){
				responseNews="1";
			}
			else{
				responseNews="0";
			}
			break;
		case "4"://�û���¼
			String loginName=news[1];
			String loginKey=news[2];
			if(userLogin(loginName,loginKey)){
				responseNews="1";
			}
			else{
				responseNews="0";
			}
			break;
		case "5"://�û��ǳ�
			String logoutName=news[1];
			userLogout(logoutName);
			break;
		case "6"://���������û��б�
			//TODO:���������û����ݽṹ�ӿ�
			
			
			//**********************
			break;
		default:break;
		}
		return responseNews;
	}
	
	
	
	
}

//Client Judge Function
//**********************
public static boolean ifIsWord(String word){
	String sp[]=word.split(" ");
	if(sp.length>1){
		return false;
	}
	return true;
}

public static void like(int i){
	//TODO:�������ݿ�ӿ�
	
	
	//*******************
}

public static boolean userRegister(String name,String key,String email){
	boolean registerSuccess=false;
	//TODO:�û��˻����ݿ�ӿ�
	
	
	//*******************
	return registerSuccess;
}

public static boolean userLogin(String name,String key){
	boolean loginSuccess=false;
	//TODO:�����û����ݹ���
	
	
	//*******************
	return loginSuccess;
}

public static void userLogout(String name){
	//TODO:�����û����ݹ���
	
	
	//*******************
	return;
}
//**********************

}