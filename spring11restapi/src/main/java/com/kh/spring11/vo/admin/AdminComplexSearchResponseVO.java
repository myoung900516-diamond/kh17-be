package com.kh.spring11.vo.admin;

import java.util.List;

import com.kh.spring11.vo.account.AccountSearchResultVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name= "회원 정보 복합 검색 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AdminComplexSearchResponseVO {
	private List<AccountSearchResultVO> list;
	private boolean last;

}
