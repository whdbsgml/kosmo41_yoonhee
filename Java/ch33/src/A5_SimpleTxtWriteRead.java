import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class A5_SimpleTxtWriteRead {
	public static void main(String[] args) throws IOException {
		Path fp = Paths.get("D:\\ooh.nle\\Study\\JavaStudy\\simple.txt");
		String st1 = "One Simple String";
		String st2 = "Two Simple String";
		List<String> lst1 = Arrays.asList(st1, st2);
		
		// 파일에 문자 데이터 쓰기
		Files.write(fp, lst1);
		
		// 파일로부터 문자 데이터 읽기
		List<String> lst2 = Files.readAllLines(fp);
		System.out.println(lst2);
	}
}
