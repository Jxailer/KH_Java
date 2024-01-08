package day20.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Vocabulary {
	private List<Word> list; // 단어 리스트
	
	public Vocabulary (List<Word> list) {
		if(list==null) {
			list = new ArrayList<Word>();
		}
		this.list = list;
	}
	
	// 단어 추가 기능
	public boolean addWord(String word, List<Mean> newMeanList) {
		if(list == null) {
			return false;
		}
		int index = list.indexOf(new Word(word));
		
		// 새로 추가된 단어이면 단어를 추가함
		if(index<0) {
			list.add(new Word(word, newMeanList));
			return true;
		}
		
		Word selectWord = list.get(index);
		// // 이미 등록된 단어이고, 뜻도 등록 되었으면
		// if(!selectWord.getMeanList().containsAll(newMeanList)) {
		// 	 selectWord.addMean(newMeanList);
		// 	return true;
		// }
		
		// 중복된 뜻이 있으면 중복 안된 뜻들을 확인함
		 List<Mean> selectedMeans = selectWord.getMeanList(); // 등록된 단어의 뜻을 가져옴.
		 int count = (int)newMeanList.stream().filter(m->selectedMeans.contains(m)).count();
		 // 새로운 뜻에 중복되지 않은 뜻의 갯수
		 if(count == 0) { // 전부 중복될 경우
			 return false;
		 }
		 // 하나라도 중복되지 않은 새 뜻이 있다면
		 newMeanList.stream()
		 .filter(m->selectedMeans.contains(m)).forEach(m->selectedMeans.add(m)); // 기존 뜻에 중복되지 않은 뜻을 추가함.
		 return true;
		
	}
	
	// 단어 수정 기능
	public boolean setWord(String oldWord, String newWord) {
		// list가 없으면
		if(list == null) {
			return false;
		}
		
		// 이미 등록된 단어이면
		if(list.contains(new Word(newWord))) {
			return false;
		}
		// 수정할 단어가 없는 단어라면
		int index = list.indexOf(new Word(oldWord));
		if(index <0) {
			return false;
		}
		list.get(index).setWord(newWord);
		return true;
		
	}

	public boolean removeWord(String word) {
		// 리스트가 비어있으면
		if(list == null) {
			return false;
		}
		// 삭제 후 삭제 여부를 리턴함
		return list.remove(new Word(word));
	}

	public boolean addMean(String word, String partOfSpeech, String mean) {
		if(list == null) {
			return false;
		}
		// 수정 후 수정 여부를 리턴함
		int index = list.indexOf(new Word(word));
		
		// 단어가 없으면
		if(index<0) {
			return false;
		}
		
		// 단어의 뜻을 추가 후 성공 여부를 알려줌
		Word selectedWord = list.get(index);
		return selectedWord.addMean(partOfSpeech, mean);

	}

	public Word getWord(String word) {
		int index = list.indexOf(new Word(word));
		if(index <0) {
			return null;
		}
		return list.get(index);
		// return index <0 ? null : list.get(index);
	}
	

	public void print(String word) {
		print(word, (w1, w2)->w1.getWord().compareTo(w2.getWord()));
	}
	
	public List getList() {
		return this.list;
	}

	public void print() {
		print(""); // 빈 문자열. 모두 포함되도록함.
		// 메서드 오버로딩을 통해 매개변수가 없는 동명의 메서드를 정의할 수 있음.
		
	}
	
	public void printByViews() {
		print("", (w1, w2)->w2.getViews() - w1.getViews()); // 내림차순 정렬
	}
	public void print(String word, Comparator<Word> c) {
		int count = (int) list.stream().filter(w-> w.getWord().contains(word)).count();
		if(count == 0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		// list.sort((w1, w2)->w1.getWord().compareTo(w2.getWord())); // 단어끼리 비교하여 정렬함
		list.sort(c);
		list.stream().filter(w-> w.getWord().contains(word)) // word가 포함된 객체들만 필터링함.
				.forEach(w->{
					w.printWord();
					w.views();
				});

		
	}
	
	
	
	
	
}
