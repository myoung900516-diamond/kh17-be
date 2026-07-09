package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.dao.BookDao;
import com.kh.spring11.dto.BookDto;
import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.BookInsertVO;
import com.kh.spring11.vo.BookUpdateAllVO;
import com.kh.spring11.vo.BookUpdateUnitVO;
import com.kh.spring11.vo.ListRequestVO;
import com.kh.spring11.vo.ListVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="도서 처리 시스템", description ="도서 CRUD를 위한 API입니다")

@CrossOrigin//CORS허용 (지금은 전체허용, 향후 특정 대상만 허용하는 옵션 추가 필요)
@RestController//Controller와 차이를 3초 안에 말할 수 있어야 합니다.
@RequestMapping("/api/book")
@CommonsApiResponse
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	//어떤 작업인지에 대해 설명하기 위한 코드
	@Operation(
			//deprecated = true
			summary = "신규 도서 생성",
			description = "새로운 도서를 생성하고자 하는 AJAX 요청에 대응합니다",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description="등록성공",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = BookDto.class)
									)
							),
					
					})
	
	
	@PostMapping(value="/", produces="application/json", consumes="application/json")
	public BookDto insert(@RequestBody BookInsertVO bookInsertVO) {
		int bookId = bookDao.sequence();
		BookDto bookDto = new BookDto();
		bookDto.setBookId(bookId);
		bookDto.setBookTitle(bookInsertVO.getBookTitle());
		bookDto.setBookAuthor(bookInsertVO.getBookAuthor());
		bookDto.setBookPublicationDate(bookInsertVO.getBookPublicationDate());
		bookDto.setBookPrice(bookInsertVO.getBookPrice());
		bookDto.setBookPublisher(bookInsertVO.getBookPublisher());
		bookDto.setBookPageCount(bookInsertVO.getBookPageCount());
		bookDto.setBookGenre(bookInsertVO.getBookGenre());
//		lectureDto.setLectureNo(lectureNo);
		bookDao.insert(bookDto);
		return bookDto;
	}
	
	
	
	
	@Operation(
//			deprecated = true,
			summary = "도서 목록 조회",
			description = "도서를 순서대로 조회하여 출력합니다",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description="조회성공",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(
											schema = @Schema(implementation = BookDto.class)
											)
									)
							),
					
			}
			
			)
	
	
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList(1, Integer.MAX_VALUE);
	}
	@Operation(
//			deprecated = true,
			summary = "도서 목록 조회(더보기버튼구현)",
			description = "도서 목록을 조회하고 더보기 버튼으로 내려 볼 수 있습니다",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description="조회성공",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(
											schema = @Schema(implementation = BookDto.class)
											)
									)
							),
					
			}
			
			)
	
	
	@PostMapping("/list-more")
	public ListVO listForReact(
			@RequestBody ListRequestVO listRequestVO
			
			) {
		List list = bookDao.selectListForReact(listRequestVO.getLastNo(), listRequestVO.getSize());
		int count = bookDao.countForReact(listRequestVO.getLastNo());
//		System.out.println(listRequestVO.getLastNo());
		return ListVO.builder()
				.list(list)
				.last(count >= listRequestVO.getSize())
				.build();
		
	}
	
	
	@Operation(
			//deprecated =true,
			summary = "도서 상세 조회",
			description = "특정 도서에 대한 모든 정보를 조회합니다",
			/*
			 * parameters = @Parameter( required = true, name = "강좌 고유번호", example = "1" ),
			 */
			responses = @ApiResponse(
					responseCode = "200",
					description = "대상 조회 성공",
					content = @Content(
							schema = @Schema(implementation = BookDto.class)
							)
					)
			)
	
	
	//상세 : PK를 경로 변수로 받음
	@GetMapping("/{bookId}")
	public BookDto find(
			@Parameter(description = "조회할 도서 번호", example = "1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		return bookDto;
	}
	
	
	@Operation(
			//deprecated =true,
			summary = "도서 삭제",
			description = "특정 도서에 대한 모든 정보를 삭제합니다",
			
			responses = @ApiResponse(
					responseCode = "200",
					description = "삭제한 대상",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = BookDto.class)
							)
					)
			)
	
	//삭제
	@DeleteMapping("/{bookId}")
	public BookDto delete(
			@Parameter(description = "삭제할 도서 번호", example = "1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		bookDao.delete(bookId);
		return bookDto;//삭제한 데이터 정보
	}
	
	
	@Operation(
			summary = "도서 정보 전체 수정",
			description = "요청한 도서번호에 대해 번호를 제외한 모든 정보를 수정합니다",
			responses = @ApiResponse(
					responseCode="200",
					description = "도서 정보 수정 성공",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = BookDto.class)
							)
					)
			)
	
	
	//전체정보 수정
	@PutMapping("/{bookId}")
	public BookDto updateAll(
			@RequestBody BookUpdateAllVO bookUpdateAllVO, 
			@Parameter(description = "수정할 도서 고유 번호", example = "1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		
		bookDto.setBookTitle(bookUpdateAllVO.getBookTitle());
		bookDto.setBookAuthor(bookUpdateAllVO.getBookAuthor());
		bookDto.setBookPublicationDate(bookUpdateAllVO.getBookPublicationDate());
		bookDto.setBookPrice(bookUpdateAllVO.getBookPrice());
		bookDto.setBookPublisher(bookUpdateAllVO.getBookPublisher());
		bookDto.setBookPageCount(bookUpdateAllVO.getBookPageCount());
		bookDto.setBookGenre(bookUpdateAllVO.getBookGenre());
		
		bookDao.update(bookDto);
		return bookDto;
	}
	
	@Operation(
			summary = "도서 정보 부분 수정",
			description = "대상 도서의 정보 중 원하는 일부 정보를 변경합니다",
			responses = @ApiResponse(
					responseCode = "200",
					description = "강좌 정보 변경 성공",
					content = @ Content(
							mediaType = "application/json",
							schema = @Schema(implementation = BookDto.class)
							)
					
					)
			)
	
	//일부정보 수정
	@PatchMapping("/{bookId}")
	public BookDto updateUnit(
			@RequestBody BookUpdateUnitVO bookUpdateUnitVO, 
			@Parameter(description = "수정할 강좌 고유 번호", example = "1")
			@PathVariable int bookId) {
		
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		
		
		if(bookUpdateUnitVO.getBookTitle() != null) {
			bookDto.setBookTitle(bookUpdateUnitVO.getBookTitle());
		}
		if(bookUpdateUnitVO.getBookPublicationDate() != null) {
			bookDto.setBookPublicationDate(bookUpdateUnitVO.getBookPublicationDate());
		}
		if(bookUpdateUnitVO.getBookPrice() != null) {
			bookDto.setBookPrice(bookUpdateUnitVO.getBookPrice());
		}
		if(bookUpdateUnitVO.getBookPageCount() != null) {
			bookDto.setBookPageCount(bookUpdateUnitVO.getBookPageCount());
		}
		if(bookUpdateUnitVO.getBookPublisher() != null) {
			bookDto.setBookPublisher(bookUpdateUnitVO.getBookPublisher());
		}
		if(bookUpdateUnitVO.getBookAuthor() != null) {
			bookDto.setBookAuthor(bookUpdateUnitVO.getBookAuthor());
		}
		if(bookUpdateUnitVO.getBookGenre() != null) {
			bookDto.setBookGenre(bookUpdateUnitVO.getBookGenre());
		}
		bookDao.update(bookDto);
		return bookDto;
	}
	
	
	
	
	
}
