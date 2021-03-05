package com.jhsite.practice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhsite.practice.commons.paging.Criteria;
import com.jhsite.practice.domain.ReplyVO;
import com.jhsite.practice.persistence.ArticleDAO;
import com.jhsite.practice.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDAO replyDAO;
	
	private final ArticleDAO articleDAO;
	
	

	@Inject
	public ReplyServiceImpl(ReplyDAO replyDAO, ArticleDAO articleDAO) {
		this.replyDAO = replyDAO;
		this.articleDAO = articleDAO;
	}

	@Override
	public List<ReplyVO> list(Integer article_no) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.list(article_no);
	}

	// 댓글 등록
	@Transactional // 트랜잭션 처리
	@Override
	public void create(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.create(replyVO); // 댓글 등록
		articleDAO.updateReplyCnt(replyVO.getArticle_no(), 1);
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.update(replyVO);

	}

	// 댓글 삭제
	@Transactional // 트랜잭션 처리
	@Override
	public void delete(Integer reply_no) throws Exception {
		// TODO Auto-generated method stub
		int article_no = replyDAO.getArticleNo(reply_no); // 댓글의 게시물 번호 조회
		replyDAO.delete(reply_no); // 댓글 삭제
		articleDAO.updateReplyCnt(article_no, -1);
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
