package day10.word;

import java.util.Scanner;

public class Word {
	private String eng=null;
	private String mean=null;
	
	private static Scanner scan = new Scanner(System.in);
	
	public Word() {
		
	}
	
	public Word(String eng, String mean) {
		this.eng = eng;
		this.mean = mean;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}
	
	public String getEng() {
		return eng;
	}
	
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	public String getMean() {
		return mean;
	}

	public void printWord() {
	System.out.println(eng+" : " + mean);
	}
	
	
	// @param mean 수정할 뜻
	public void update(String mean) {
		this.mean = mean;
	}
	
	/* 단어가 주어지면 주어진 단오와 내 단어가 같은 지 다른 지를 알려주는 메서드
	 * @param word 같응ㄴ지 다른지르 확인할 단어
	 * @return 주어진 word와 내 word가 같으면 true, 다르면 false 리턴
	 * */
	public boolean equals(String word) {
		return word.equals(word);
	}
	
}