package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.model.dao.CommentDao;
import com.ssafit.model.dto.Comment;

public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public void InsertComment(Comment comment) {
		commentDao.InsertComment(comment);

	}

	@Override
	public boolean deleteComment(int CommentNo) {
		if (commentDao.deleteComment(CommentNo)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateComment(Comment comment) {
		if (commentDao.updateComment(comment)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> selectList(String YotubeId) {
		
		return commentDao.selectList(YotubeId);
	}

	@Override
	public Comment selectOne(int CommentNo) {
		return commentDao.seletOne(CommentNo);
	}

}
