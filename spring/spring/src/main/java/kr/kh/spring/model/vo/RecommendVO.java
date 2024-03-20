package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {
	int re_num;
	String re_me_id;
	int re_bo_num;
	int re_state;

	public RecommendVO(int num, String me_id) {
		this.re_bo_num = num;
		this.re_me_id = me_id;
	}
}
