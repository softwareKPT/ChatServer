
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
