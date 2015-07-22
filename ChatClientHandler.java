
import java.io.*;
import java.net.*;

public class ChatClientHandler extends Thread{
	private Socket socket = null; //ソケット
	//入出力ストリーム
	BufferedReader in = null;
	BufferedWriter out = null;
	
	private String name;        //このクライアントの名前
	
	public ChatClientHandler (int id, Socket socket) {
		this.socket = socket;
		this.name = ("undefined" + id);
		
	}
	
	public void run(){
		try{
			boolean lp = true;
			open();
			while(lp){
				String[] command = receive();
				System.out.printnln(name + " : " + command[0]);
				
				if(command != null){
					switch(command[0]){
						case "help":
							help();
							break;
							
						case "whoami":
							whoAmI();
							break;
						
						case "name":
							if(command.length != 2){
								send("command format error : name <NewName>");
								break;
							}
							name(command[1]);
							break;
							
						case "post":
							if(command.length != 2){
								send("command format error : name <message>");
								break;
							}
							post(command[1]);
							break;
							
						case "help":
							help();
							break;
						
						case "bye":
							lp = false;
							bye();
							break;
						
						default:
							send(command[0] + " : unknown command");
							break;
					}
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			handler.remove(this);
			close();
		}
	}
}