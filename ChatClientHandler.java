
import java.io.*;
import java.net.*;

public class ChatClientHandler extends Thread{
	private Socket socket = null; //ソケット
	private ChatServer handler = null;
	//入出力ストリーム
	BufferedReader in = null;
	BufferedWriter out = null;
	
	private String name;        //このクライアントの名前
	
	public ChatClientHandler (int id, Socket socket, ChatServer handler) {
		this.socket = socket;
		this.handler = handler;
		this.name = ("undefined" + id);
		}

	private void name(String name){

		this.name = name;
		send("changed your name : " + name);
	}


	private void send(String mes) throws IOException {
		out.write(mes);
		out.write("\r\n");
		out.flush();
	}
}
