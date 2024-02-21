import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String []args) {
		List<Test> list = new ArrayList<Test>();
		list.add(new Test(1,2,1));
		list.add(new Test(10,5,0));
		list.add(new Test(3,2,1));
		
		Solution sol = new Solution();
		for(Test tmp : list) {
			if(sol.solution(tmp.num1, tmp.num2) == tmp.res) {
				System.out.println("ok");
			}
		}
	}
	
}

class Solution{
	public int solution(int num1, int num2) {
		return num1 % num2 ;
	}
}

class Test{
	int num1, num2;
	int res;
	public Test(int num1, int num2, int res) {
		this.num1 = num1;
		this.num2 = num2;
		this.res = res;
		
	}
}