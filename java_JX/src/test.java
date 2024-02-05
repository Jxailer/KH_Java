import java.io.BufferedWriter;
import java.io.FileWriter;

public class test {
	public static void main(String []args) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test.txt"));
			bw.write("안녕하세요");
			bw.write("반갑습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
