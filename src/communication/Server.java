package communication;

import communication.BaiduDicGet;
import communication.YoudaoDicGet;
import communication.BingDicGet;
import java.io.*;
import java.net.*;

//服务器端
public class Server {
	//设定端口
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
		//服务器端建立一个Serversocket
		ServerSocket server=new ServerSocket(port);	
		//server.close();	
		while(true){//不停接收socket
			Socket socket=server.accept();
			//阻塞接收方式
			Thread thread=new Thread(new Task(socket));
			thread.start();
		}
		//*/
	}


//多线程的建立
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
	
	//socket处理
	private void handleSocket()throws Exception{
		//接受客户端消息
		DataInputStream in=null;
		in=new DataInputStream(socket.getInputStream());
		
		//处理客户端消息
		String news=in.readUTF();
		String newsAnalyse[]=news.split("\\|");
		String responseNews=handleNews(newsAnalyse);
		//回复客户端消息
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
			responseNews="已连接服务器";
			break;
		case "1":String word=news[1];//查找词典
			try{
				if(ifIsWord(word)){//若是一个单词进行查找
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
				else{//若不是一个单词则返回原词组即可
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
		case "2"://词典点赞
			like(Integer.parseInt(news[1]));
			break;
		case "3"://用户注册
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
		case "4"://用户登录
			String loginName=news[1];
			String loginKey=news[2];
			if(userLogin(loginName,loginKey)){
				responseNews="1";
				//TODO:在线用户数据管理接口登入
				
				
				//***********************
			}
			else{
				responseNews="0";
			}
			break;
		case "5"://用户登出
			String logoutName=news[1];
			userLogout(logoutName);
			break;
		case "6":
			//TODO:返回在线用户列表
			
			
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
	//TODO:词典点赞
	
	
	//*******************
}

public static boolean userRegister(String name,String key,String email){
	boolean registerSuccess=false;
	//TODO：用户账号注册
	
	
	//*******************
	return registerSuccess;
}

public static boolean userLogin(String name,String key){
	boolean loginSuccess=false;
	//TODO:用户账号登入
	
	
	//*******************
	return loginSuccess;
}

public static void userLogout(String name){
	//TODO:用户帐户登出
	
	
	//*******************
	return;
}
//**********************

}