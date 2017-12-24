package com.tecky.communicate.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tecky.common.repository.GenericRepository;
import com.tecky.common.service.impl.GenericServiceImpl;
import com.tecky.communicate.entity.Expression;
import com.tecky.communicate.repository.ExpressionRepository;
import com.tecky.communicate.service.ExpressionService;

/**
 * @author mekysersoze
 *
 */
@Service("expressionServiceImpl")
public class ExpressionServiceImpl extends GenericServiceImpl<Expression> implements ExpressionService {

	@Autowired
	ExpressionRepository expressionRepository;

	@PersistenceContext
	EntityManager em;

	@Override
	protected GenericRepository<Expression> getMainRepository() {
		return expressionRepository;
	}

	public List<Expression> findExpressionsByPageRequest(int pageNumber, int count) {

		Pageable topCount = new PageRequest(count, pageNumber, Sort.Direction.DESC, "id");
		Page<Expression> expressions = expressionRepository.findAll(topCount);
		return expressions.getContent();
	}

}
