package com.kh.spring12.entity.post;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "comments")
@SequenceGenerator(name = "comments_seq", sequenceName = "comments_seq", 
initialValue = 1, allocationSize = 1)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Comment {
	
	@Id @GeneratedValue(generator = "comments_seq", strategy = GenerationType.AUTO)
	private Long commentsNo;
	@Column(nullable = false) @Lob
	private String commentsContent;
	@CreationTimestamp
	private LocalDateTime commentsWtime;
	@CreationTimestamp
	private LocalDateTime commentsEtime;
	
	//연결
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_no", nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Post post;

}













































