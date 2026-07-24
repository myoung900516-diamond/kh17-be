package com.kh.spring11.vo.admin;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "관리자가 회원 정보를 복합검색할 때 쓰는 요청용 VO")
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class AdminComplexSearchRequestVO {
	private String accountId;
	private String accountNickname;
	private String accountContact;
	private String accountEmail;
	private String accountAddress;
	private String accountBirthBegin, accountBirthEnd;
	private String accountJoinBegin, accountJoinEnd;
	private String accountLoginBegin, accountLoginEnd;
	private Integer accountPointMin, accountPointMax;
	private Set<String> accountLevels;
	private String accountBlock;

//	private List<String> orders;
//	private Integer size;
}
