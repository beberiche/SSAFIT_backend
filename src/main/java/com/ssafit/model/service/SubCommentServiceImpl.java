package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.SubCommentDao;
import com.ssafit.model.dto.SubComment;

@Service
public class SubCommentServiceImpl implements SubCommentService{
	@Autowired
	SubCommentDao subCommentDao;
	
	@Override
	public void createSubComment(SubComment subComment) {
		System.out.println(subComment.toString());
		subCommentDao.insertSubComment(subComment);
	}

	@Override
	public boolean removeSubComment(int subNo) {
		if(subCommentDao.deleteSubComment(subNo))
			return true;
		return false;
	}

	@Override
	public boolean modifySubComment(SubComment subComment) {
		if(subCommentDao.updateSubComment(subComment))
			return true;
		return false;
	}

	@Override
	public List<SubComment> getListSubComment(int commentNo) {
		return subCommentDao.selectListSubComment(commentNo);
	}

	@Override
	public SubComment getOneSubComment(int subNo) {
		return subCommentDao.selectOneSubComment(subNo);
	}
	

}
