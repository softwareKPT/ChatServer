
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
	
	private void open() throws IOException {  //クライアントとのデータのやり取りをするストリームを開くメソッド
		//ストリームを開く
		InputStream socketIn = socket.getInputStream();
		OutputStream socketOut = socket.getOutputStream();
		this.in = new BufferedReader(new InputStreamReader(socketIn));      
		this.out = new BufferedWriter(new OutputStreamWriter(socketOut));
	}


	 */
	private void close() {
		if (in != null) {try { in.close(); } catch (IOException e) { } }
		if (out != null) {try { out.close(); } catch (IOException e) { } }
		if (socket != null) {try { socket.close(); } catch (IOException e) { } }
	}


}