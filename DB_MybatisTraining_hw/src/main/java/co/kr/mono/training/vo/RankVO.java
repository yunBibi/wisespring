package co.kr.mono.training.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RankVO {
	
	private String name;
	private int d_rank;
	private String r_class;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int lag_cha;

}

