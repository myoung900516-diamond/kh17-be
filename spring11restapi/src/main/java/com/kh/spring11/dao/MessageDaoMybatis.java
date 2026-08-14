package com.kh.spring11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring11.vo.room.RoomChatMessageVO;
import com.kh.spring11.vo.room.RoomSystemMessageVO;

@Repository
public class MessageDaoMybatis implements MessageDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int sequence() {
		return sqlSession.selectOne("mapper.message.sequence");
	}
	
	@Transactional
	@Override
	public void insertChat(RoomChatMessageVO message) {
		sqlSession.insert("mapper.message.add", message);
		sqlSession.insert("mapper.message.addChat", message);
	}

	@Transactional
	@Override
	public void insertSystem(RoomSystemMessageVO message) {
		sqlSession.insert("mapper.message.add", message);
		sqlSession.insert("mapper.message.addSystem", message);
	}


}
