package data;

import java.util.ArrayList;
import java.util.Iterator;


public class ClientInfo {
	
	static ArrayList<ClientNode> clientList=new ArrayList<ClientNode>();
	
	//
	public static class ClientNode{
		private String name=null;
		//private String key=null;
		//private String emailAddress=null;
		private String ip=null;
		ClientNode(String name,/*String key,String emailAddress,*/String ip){
			this.name=name;
			//this.key=key;
			//this.emailAddress=emailAddress;
			this.ip=ip;
		}
		ClientNode(ClientNode c){
			name=c.name;
			//key=c.key;
			//emailAddress=c.emailAddress;
			ip=c.ip;
		}
		
		public boolean equals(ClientNode c){
			if(c==null){
				return false;
			}
			if(this.name==c.name){
				return true;
			}
			return false;
		}
		
		public boolean equals(String name){
			if(name==null){
				return false;
			}
			if(name==this.name){
				return true;
			}
			return false;
		}
		
		public String getName(){
			return name;
		}
		
		/*
		public String getKey(){
			return key;
		}
		
		public String getEmailAddress(){
			return emailAddress;
		}
		*/
		
		public String getIp(){
			return ip;
		}
	}
	
	public static boolean addClientNode(ClientNode c){
		if(clientList.contains(c)){
			clientList.add(c);
			return true;
		}
		return false;
	}
	
	public static boolean addClientNode(String name,/*String key,String emailAddress,*/String ip){
		ClientNode user=new ClientNode(name,/* key, emailAddress,*/ ip);
		clientList.add(user);
		return true;
	}
	
	public static boolean removeClientNode(String name){
		Iterator<ClientNode> index=clientList.iterator();
		while(index.hasNext()){
			if(index.next().equals(name)){
				index.remove();
				return true;
			}
		}
		return false;
	}
	
	public static String getUserIp(String name){
		Iterator<ClientNode> index=clientList.iterator();
		while(index.hasNext()){
			if(index.next().equals(name)){
				return index.next().getIp();
			}
		}
		return null;
	}
	
	public static boolean ifLogin(String name){
		Iterator<ClientNode> index=clientList.iterator();
		while(index.hasNext()){
			if(index.next().equals(name)){
				return true;
			}
		}
		return false;
	}
	
}
