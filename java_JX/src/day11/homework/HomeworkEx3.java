package day11.homework;

import java.util.Scanner;

public class HomeworkEx3 {
	
	private static Scanner scan = new Scanner(System.in);
	private static int count = 0;
	private static Member members[] = new Member[10];
	
	public static void main(String[] args) {
		/* 사이트에서 회원관리(로그인, 회원가입 등)를 위한 Member클래스를 작성하세요
		 * 
		 * 작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현한 메서드를 테스트 해보세요
		 * */
		
		members[0] = new Member("김수한무", "거북이와 두루미", "주소2", 100);
		count++;
		members[0].printMemberInfo();

		System.out.println("김수한무가 있는가? :"+checkMember("김수한무"));
	}
	
	public static boolean checkMember(String name) {
		for(int i=0; i<count; i++) {
			if(members[i].getName().equals(name))
				return true;
		}
		
		return false;
	}
}
/* 필요한 매개변수 및 메서드를 정리하고 구현하세요.
 * 추상화 하는 과정
 * */






class Member{
	private String name, nickname, address;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Member() {
		
	}
	
	public Member(String name, String nickname, String address, int age) {
		this.name=name;
		this.nickname=nickname;
		this.address=address;
		this.age=age;
	}
	
	public void printMemberInfo() {
		System.out.println("회원 정보");
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("닉네임: "+nickname);
		System.out.println("주소: "+address);
	}
	

		
}




