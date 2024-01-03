package day17;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IpEx1 {

	public static void main(String[] args) {
		InetAddress address = null;
		
		try {// localhost는 내부 ip를 의미하고, 모든 pc가 동일함
			address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			// 네이버의 아이피 주소 중 하나를 출력함
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			
			//네이버의 아이피 주소들을 조회함
			System.out.println();
			InetAddress [] addressList = InetAddress.getAllByName("www.naver.com");
			Arrays.stream(addressList).forEach(addr->System.out.println(addr));
			
		}catch (UnknownHostException  e){
			System.out.println("해당하는 이름과 일치하는 IP를 찾을 수 없습니다.");
		}

	}

}
