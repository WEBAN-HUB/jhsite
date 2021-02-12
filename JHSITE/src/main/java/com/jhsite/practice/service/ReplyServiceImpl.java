package com.jhsite.practice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhsite.practice.commons.paging.Criteria;
import com.jhsite.practice.domain.ReplyVO;
import com.jhsite.practice.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDAO replyDAO;

	@Inject
	public ReplyServiceImpl(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	@Override
	public List<ReplyVO> list(Integer article_no) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.list(article_no);
	}

	@Override
	public void create(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.create(replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.update(replyVO);

	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.delete(reply_no);
	}

	@Override
	public List<ReplyVO> getRepliesPaging(Integer article_no, Criteria criteria) throws Exception {
		return replyDAO.listPaging(article_no, criteria);
	}

	@Override
	public int countReplies(Integer article_no) throws Exception {
		return replyDAO.countReplies(article_no);
	}

}
