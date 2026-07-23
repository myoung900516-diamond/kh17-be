package com.kh.spring11.vo.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//지금과 같이 요청별로 VO를 따로 만들면 Spring Validation을 적용하기가 쉽다
//-@RequestBody와 함께 @Valid라고 붙여서 검증하겠다는 의사표시를 해야한다

//주요 Annotation
//-@NotNull :null 불가 (필수야 꼭있어야해)
//-@NotEmpty :null 불가 + 비어있는 것 불가
//-@NotBlank :null 불가 + 비어있는 것 불가 + 공백만 있는 것도 불가
// 	 →현재 우리 프로젝트는 EmptyStringDeserializer가 있어서 @NotNull로도 충분
//-@Size : 개수(문자열에선 글자수, Collection에선 데이터개수)
//-@Pattern :유효한 패턴에 대한 정규표현식을 지정할 때 사용
//-@Min /@Max :최소 /최대 숫자 지정
//-@DecimalMin / @DecimalMax : 소수점이 포함된 최소/ 최대 수치 지정 
//-@Positive : 양수
//-@PositiveOrZero : 0이상이어야 함 
//-@Negative
//-@NegativeOrZero : 0 이하이어야 함 

@Schema(name="비밀번호 변경 요청 VO")
//비밀번호 변경 요청 VO
@Data @JsonIgnoreProperties(ignoreUnknown = true)
//내가 적은거 말고 다른거 보내면 무시해 내가 명시한거 외에는 무시해라! 
//내가 적은건 줘야하는데 만약 안주면 검사하는 도구 
public class ChangePasswordRequestVO {

//	private String accountId; 
	@NotNull
//	@Size(min = 8, max = 16)//이런 걸 많이 쓸 수록 프로그램이 할 수 있는게 적어짐. 
//	@Pattern(
//		regexp = "^(?=.*?[A-Z]+)[A-Za-z0-9!@#$]{8,16}$", 
//		message = "비밀번호는 대문자, 소문자, 숫자, 특수문자를 반드시 포함하여 8~16자로 작성해야합니다"
//	)
	private String prevAccountPassword;
	
	@NotNull
	private String newAccountPassword;
}
