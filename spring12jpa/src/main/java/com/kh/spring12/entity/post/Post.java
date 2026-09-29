package com.kh.spring12.entity.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="post")
@SequenceGenerator(name = "post_seq", sequenceName = "post_seq", 
					initialValue = 1, allocationSize = 1)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Post {
	
	@Id @GeneratedValue(generator = "post_seq", strategy = GenerationType.AUTO)
	private Long postNo;
	@Column(nullable = false, length=300)
	private String postTitle;
	@Column(nullable = false) @Lob
	@ToString.Exclude
	private String postContent;
	@Column(nullable = false)
	@Builder.Default
	private Long postReadCount = 0L;
	@CreationTimestamp
	private LocalDateTime postWtime;
	@CreationTimestamp
	private LocalDateTime postEtime;
	
	//연결
	@OneToMany(
			mappedBy = "post",
			cascade = {CascadeType.REMOVE},
			fetch = FetchType.EAGER, 
			orphanRemoval = true
			)
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Comment> comment = new ArrayList<>();
	
	

}
































