package day20.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Word implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4507865426148685855L;
	// 단어 스펠링만 같아도 같은 단어로 판별됨. (equals 오버라이딩)
	
	private String word; // 단어
	private List<Mean> meanList; // 품사와 뜻 리스트
	private int views=0; // 조회수
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	
	// 단어와 뜻 리스트를 출력하는 메서드
	public void printWord() {
		System.out.println("단어: "+word);
		if(meanList==null) {
			System.out.println("등록된 뜻이 없습니다.");
			return;
		}
		
		for(int i = 0; i <meanList.size(); i++) {
			System.out.println((i+1)+". "+meanList.get(i));
		}
	}
	
	// 뜻을 추가하는 메서드
	public boolean addMean(String PartOfSpeech, String mean) {
		// 뜻을 저장하는 리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		
		// 이미 등록된 뜻이면
		if(meanList.contains(new Mean(null, mean))) {
			return false;
		}
		meanList.add(new Mean(PartOfSpeech, mean));
		return true;
	}
	
	// 뜻을 수정하는 메서드
	public boolean setMean(int pos, String partOfSpeech, String mean) {
		// 뜻을 저장하는 리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		
		// pos가 잘못되어 있으면
		if(pos<0 || pos>=meanList.size()) {
			return false;
		}
		
		// 이미 등록된 뜻이면
		if(meanList.contains(new Mean(mean))){
			return false;
		}
		// 수정함
		meanList.set(pos, new Mean(partOfSpeech, mean)); // .set(): pos 자리의 객체를 new Mean 객체로 대체함.
		return true;
	}
	
	// 뜻을 삭제하는 메서드
	public boolean removeMean(int pos) {
		// 뜻을 저장하는 리스트가 생성되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		
		// pos가 잘못되어 있으면
		if(pos<0 || pos>=meanList.size()) {
			return false;
		}
		meanList.remove(pos);
		return true;

	}
	@Override
	public String toString() {
		return "단어:" + word + "\n" + meanList + "\n조회수: " + views;
	}
	
	public Word(String word) {
		this.word = word;
	}
	
	public Word(String word, String partOfSpeech, String mean) {
		this.word=word;
		meanList = new ArrayList<Mean>();
		this.meanList.add(new Mean(partOfSpeech, mean));
		
	}
	
	public Word(String word2, List<Mean> newMeanList) {
		this.word = word2;
		this.meanList = newMeanList != null  ? newMeanList : new ArrayList<Mean>();
	}
	public String getRandomMean() {
		List<Mean> tmp = new ArrayList<Mean>(meanList);
		Collections.shuffle(tmp);
		// 뜻이 없거나 비어있으면
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0).getMean();
	}
	public void views() {
		views++;
		
	}

	public void addMean(List<Mean> newMeanList) {
		if(meanList == null) {
			meanList = newMeanList;
			return;
		}
		meanList.addAll(newMeanList);
	}
	
}
