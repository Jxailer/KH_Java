package kr.kh.app.pagination;

import lombok.Data;

@Data
public class PageMaker { 
	// 전체 컨텐츠 개수(마지막 pagination의 마지막 페이지를 계산하기 위해)
	private int totalCount;
	private int startPage; // Pagination 시작 페이지 번호
	private int endPage; // Pagination 마지막 페이지 번호
	private boolean prev; // 이전 버튼 활성화
	private boolean next; // 다음 버튼 활성화
	private int displayPageNum; // 한 pagination에서 보여준 페이지의 최대 숫자 개수
	private Criteria cri;
	
	// totalCount, displayPageNum, cri를 이용해
	// endPage, startPage, prev, next를 계산하는 메서드
	public void calculate() {
		// 현재 페이지를 기준으로 표시할 수 있는 최대 페이지 번호
		/* Ex)
		 * 현재 페이지: 4 / 한 페이지에 컨텐츠 개수: 10 / 한 페이지네이션의 페이지 개수: 10
		 * > endPage = (int)(Math.ceil(4/10.0) * 10);
		 * */
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = endPage - displayPageNum + 1;
		
		// 컨텐츠 개수를 이용해서 계산한 최대 페이지 번호
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		// 첫 번째 페이지네이션이면 false 아니면 true
		prev = startPage == 1 ? false : true;
		// 마지막 페이지네이션이면 false 아니면 true
		next = endPage == tmpEndPage ? false : true;
	}
	
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}
