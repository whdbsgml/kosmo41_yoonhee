import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient6 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
		
		try {
			String ServerIP = "localhost";
			if(args.length>0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999);    //소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다......");
			
			// 서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드
			Thread receiver = new Receiver6(socket);
			receiver.start();
			
			//사용자로부터 얻은 문자열을 서버로 전송해주는 역할을 하는 쓰레드
//			Thread sender = new Sender6(socket, s_name);
//			sender.start();
			
			new ChatWIn(socket, s_name);
			
		} catch(Exception e) {
			System.out.println("예외[MultiClient class]:" +e);
		}
	}
}