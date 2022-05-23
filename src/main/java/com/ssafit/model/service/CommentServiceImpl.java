package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.CommentDao;
import com.ssafit.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public void createComment(Comment comment) {
		commentDao.insertComment(comment);
		//System.out.println(comment.getDate());
	}

	@Override
	public boolean removeComment(int CommentNo) {
		if (commentDao.deleteComment(CommentNo)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyComment(Comment comment) {
		if (commentDao.updateComment(comment)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> getListComment(String yotubeId) {
		return commentDao.selectListComment(yotubeId);
	}

	@Override
	public Comment getOneComment(int commentNo) {
		return commentDao.selectOneComment(commentNo);
	}

}
