package day20.homework;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mean implements Serializable{
	/* 직렬화 할 때 serialVersionUID가 일치하는 경우에만 읽어오도록 하기 위해 값을 지정함.*/
	private static final long serialVersionUID = 4985642882005414790L;
	private String partOfSpeech; // 품사
	private String mean; // 뜻
	
	@Override
	public String toString() {
		return "[" + partOfSpeech+"] " + mean;
	}
	
	public Mean(String mean) {
		this.mean = mean;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mean other = (Mean) obj;
		return Objects.equals(mean, other.mean);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mean);
	}
	
	
}
