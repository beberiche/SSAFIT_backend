package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafit.model.dao.SubCommentDao;
import com.ssafit.model.dto.SubComment;

@Service
public class SubCommentServiceImpl implements SubCommentService{

	SubCommentDao subCommentDao;
	@Override
	public void insertSubComment(SubComment subComment) {
		subCommentDao.insertSubComment(subComment);
	}

	@Override
	public boolean deleteSubComment(int SubNo) {
		if(subCommentDao.deleteSubComment(SubNo))
			return true;
		return false;
	}

	@Override
	public boolean updateSubComment(SubComment subComment) {
		if(subCommentDao.updateSubComment(subComment))
			return true;
		return false;
	}

	@Override
	public List<SubComment> selectList(int CommentNo) {
		return subCommentDao.selectList(CommentNo);
	}

	@Override
	public SubComment selectOne(int SubNo) {
		return subCommentDao.selectOne(SubNo);
	}
	

}
