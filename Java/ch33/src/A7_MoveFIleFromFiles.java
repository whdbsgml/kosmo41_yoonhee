import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A7_MoveFIleFromFiles {
	public static void main(String[] args) throws IOException {
		Path src = Paths.get("D:\\ooh.nle\\Study\\JavaStudy\\Dir1");
		Path dst = Paths.get("D:\\ooh.nle\\Study\\JavaStudy\\Dir2");
		
		//src가 지시하는 디렉토리를 dst가 지시하는 디렉토리로 이동
		Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
	}
}
