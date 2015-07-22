import java.io.*;
import java.net.*;

public class ChatServer {
	private ServerSocket server;    //サーバの宣言

	public void listen() {
		Socket socket = null;

		int connect Num = 1;     

		try {
			server = new ServerSocket(18080);
			System.out.println("Echoサーバをポート18080で起動しました");
			while(true) {
				socket = server.accept();
				ChatClientHandler hl = new ChatClientHandler(connectNum, socket, this);
				handler.add(hl);
				System.out.println("undefined" + connectNum + " connected. クライント " + connectNum + "が接続");

				hl.start();
				connectNum++;
			}
		} catch (IOExcetion e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer chat = new ChatServer();
		chat.listen();
	}
}
