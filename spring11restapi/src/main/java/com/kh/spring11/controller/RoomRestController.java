package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.RoomDao;
import com.kh.spring11.dto.RoomDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.room.RoomCreateRequestVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/room")
public class RoomRestController {
	
	@Autowired
	private RoomDao roomDao;
	
	@PostMapping("/")
	public void createRoom(
			@Valid @RequestBody RoomCreateRequestVO request,
			@CurrentUser TokenParseResponseVO parseVO
			) {
		int roomNo = roomDao.sequence();
		String roomOwner = parseVO.getAccountId();
		
		roomDao.insert(RoomDto.builder()
					.roomNo(roomNo)
					.roomOwner(roomOwner)
					.roomName(request.getName())
					.roomLimit(request.getLimit())
				.build());
	}
	
	@DeleteMapping("/{roomNo}")
	public void deleteRoom(@PathVariable int roomNo,
				@CurrentUser TokenParseResponseVO parseVO) {
		RoomDto roomDto = roomDao.selectOne(roomNo);
		if(roomDto == null) throw new TargetNotfoundException();
		
		String roomOwner = roomDto.getRoomOwner();//null일 수 있음
//		log.debug("roomOwner = {}, user={}", roomOwner, parseVO.getAccountId());
//		if(roomOwner.equals(parseVO.getAccountId()))//잘못된 식 널은 점을 찍을 수 없음
		if(!parseVO.getAccountId().equals(roomOwner)) {//제대로 된 식 
			throw new GetOutException();
		}
		roomDao.delete(roomNo);
	}
	
	@GetMapping("/")
	public List<RoomDto> list(){
		return roomDao.selectList();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
