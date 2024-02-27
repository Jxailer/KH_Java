package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	private int page = 1; // 현재 페이지
	private int perPageNum = 10; // 한 페이지에서 컨텐츠 개수
	
	private String search = ""; // 검색어(기본값: 전체검색)
	private String type = "all"; // 검색 타입(기본값: 전체검색)
	
	public Criteria(int page, int perPageNum, String type, String search) {
		this(page, perPageNum);
		this.type = type == null ? "" : type;
		this.search = search == null ? "" : search;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (page -1) * perPageNum;
	}
}
