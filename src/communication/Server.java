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
		///*
		String test[]=YoudaoDicGet.Trans("superman");
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}
		//*/
			
		/*
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
		case "1":String word=news[1];
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
		default:break;
		}
		return responseNews;
	}
	
	public boolean ifIsWord(String word){
		String sp[]=word.split(" ");
		if(sp.length>1){
			return false;
		}
		return true;
	}
	
}

}