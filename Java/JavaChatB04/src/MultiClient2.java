import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("이름을 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
		
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			String ServerIP = "localhost";
			Socket socket = new Socket(ServerIP, 9999); //소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다......");
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream() ));
			
			out.println(s_name);
			
			while(out != null) {
				try {
					if(in != null) {
						System.out.println("Receive : " + in.readLine());
					}
					String s2 = s.nextLine();
					if(s2.equals("q") || s2.equals("Q")) {
						out.println(s2);
						break;
					} else {
						out.println(s_name + "=>" + s2);
					}
				} catch(IOException e) {
					System.out.println("예외:" + e);
				}
			}
			
			in.close();
			out.close();
			
			socket.close();
			
		} catch(Exception e) {
			System.out.println("예외[Multiclient class]:"+e);
		}
	}
}