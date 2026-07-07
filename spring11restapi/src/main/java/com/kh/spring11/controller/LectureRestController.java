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
import com.kh.spring11.dao.LectureDao;
import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.LectureInsertVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//문서에 표시되기 위한 정보들도 Annotation형태로 설정한다(혼동되지 않도록 주의)
@Tag(name="강좌API", description ="강좌 CRUD를 위한 API입니다")

@CrossOrigin
@RestController
@RequestMapping("/api/lecture")
@CommonsApiResponse
public class LectureRestController {
	
	@Autowired
	private LectureDao lectureDao;
	
	//어떤 작업인지에 대해 설명하기 위한 코드
	@Operation(
			//deprecated = true
			summary = "신규 강좌 생성",
			description = "새로운 강좌를 생성하고자 하는 AJAX 요청에 대응합니다",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description="등록성공",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = LectureDto.class)
									)
							),
					
					})
	
	
	@PostMapping("/")
	public LectureDto insert(@RequestBody LectureInsertVO lectureInsertVO) {
		int lectureNo = lectureDao.sequence();
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(lectureNo);
		lectureDto.setLectureCategory(lectureInsertVO.getLectureCategory());
		lectureDto.setLectureTitle(lectureInsertVO.getLectureTitle());
		lectureDto.setLectureDuration(lectureInsertVO.getLectureDuration());
		lectureDto.setLecturePrice(lectureInsertVO.getLecturePrice());
		lectureDto.setLectureType(lectureInsertVO.getLectureType());
//		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
		return lectureDto;
	}
	
	
	
	
	@Operation(
//			deprecated = true,
			summary = "강좌 목록 조회",
			description = "강좌를 최근 등록된 순서대로 조회하여 출력합니다",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description="조회성공",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(
											schema = @Schema(implementation = LectureDto.class)
											)
									)
							),
					
			}
			
			)
	
	
	@GetMapping("/")
	public List<LectureDto> list(){
		return lectureDao.selectList(1, Integer.MAX_VALUE);
	}
	
	@Operation(
			//deprecated =true,
			summary = "강좌 상세 조회",
			description = "특정 강좌에 대한 모든 정보를 조회합니다",
			/*
			 * parameters = @Parameter( required = true, name = "강좌 고유번호", example = "1" ),
			 */
			responses = @ApiResponse(
					responseCode = "200",
					description = "대상 조회 성공",
					content = @Content(
							schema = @Schema(implementation = LectureDto.class)
							)
					)
			)
	
	//상세 : PK를 경로 변수로 받음
	@GetMapping("/{lectureNo}")
	public LectureDto find(
			@Parameter(description = "조회할 강좌 번호", example = "1")
			@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		return lectureDto;
	}
	
	
	@Operation(
			//deprecated =true,
			summary = "강좌 삭제",
			description = "특정 강좌에 대한 모든 정보를 삭제합니다",
			
			responses = @ApiResponse(
					responseCode = "200",
					description = "삭제한 대상",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = LectureDto.class)
							)
					)
			)
	
	//삭제
	@DeleteMapping("/{lectureNo}")
	public LectureDto delete(
			@Parameter(description = "삭제할 강좌 번호", example = "1")
			@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		lectureDao.delete(lectureNo);
		return lectureDto;//삭제한 데이터 정보
	}
	
	//전체정보 수정
	@PutMapping("/{lectureNo}")
	public LectureDto updateAll(@RequestBody LectureDto lectureDto, 
						 @PathVariable int lectureNo) {
		LectureDto findLectureDto = lectureDao.selectOne(lectureNo);
		if(findLectureDto == null) throw new TargetNotfoundException();
		lectureDto.setLectureNo(lectureNo);
		lectureDao.update(lectureDto);
		return lectureDto;
	}
	
	//일부정보 수정
	@PatchMapping("/{lectureNo}")
	public LectureDto updateUnit(@RequestBody LectureDto lectureDto, 
								@PathVariable int lectureNo) {
		//countryDto에 뭐가 있을지 모름
		//일단 countryNo로 원본을 조회해서countryDto에 있는 정보만 복사한 뒤 변경
		LectureDto findLectureDto = lectureDao.selectOne(lectureNo);
		if(findLectureDto == null) throw new TargetNotfoundException();
		
		//countryDto에 존재하는 항목들을 findCountryDto에 복사
		if(lectureDto.getLectureTitle() != null) {
			findLectureDto.setLectureTitle(lectureDto.getLectureTitle());
		}
		if(lectureDto.getLectureCategory() != null) {
			findLectureDto.setLectureCategory(lectureDto.getLectureCategory());
		}
		if(lectureDto.getLectureDuration() > 0L) {
			findLectureDto.setLectureDuration(lectureDto.getLectureDuration());
		}
		if(lectureDto.getLecturePrice() > 0L) {
			findLectureDto.setLecturePrice(lectureDto.getLecturePrice());
		}
		if(lectureDto.getLectureType() != null) {
			findLectureDto.setLectureType(lectureDto.getLectureType());
		}
		lectureDao.update(findLectureDto);
		return findLectureDto;
	}
	
	
	
	
	

}
