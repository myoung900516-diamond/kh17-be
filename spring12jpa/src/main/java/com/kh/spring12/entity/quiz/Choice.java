package com.kh.spring12.entity.quiz;

import org.hibernate.type.NumericBooleanConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//하위개체
@Entity
@Table(name= "choice")
@SequenceGenerator(name = "choice_seq", sequenceName = "choice_seq", 
				initialValue = 1, allocationSize = 1)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Choice {
	@Id @GeneratedValue(generator = "choice_seq", strategy = GenerationType.AUTO )
	private Long choiceNo;
	@Column(nullable = false)
	//@Lob// 대용량인 경우
	private String choiceContent;
	@Column @Convert(converter = NumericBooleanConverter.class)//숫자 -> 눈리 변환
	private boolean answer;
	
	//Question이 상위 개체임을 명시
	//(중요) 양쪽에서 서로를 쳐다보는 1:N관계에서 발생할 실수를 예방하기 위해 다음 기능은 제거하는 것이 좋다. 
	// - equals(), hashCode(), toString()
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)//필요할 때 불러와 무간지옥에 빠지지 않게
	@JoinColumn(name = "question_no", nullable = false)//이 개체의 테이블에 question_no라는 컬럼을 만들어 외래키 설정을 해. 
	private Question question;
	
}


























