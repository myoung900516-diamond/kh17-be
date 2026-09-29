package com.kh.spring12.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.post.Post;
import com.kh.spring12.repo.CommentRepository;
import com.kh.spring12.repo.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostInsertTest01 {
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	@Test
	public void test() {
		
		postRepository.save(
				Post.builder()
					.postTitle("첫 글")
					.postContent("실행 테스트")
//					.comment(
//							List.of(
//									Comment.builder().commentContent("테스트1").build()
//							)
//					)
				.build()
				);
	}

}
