package com.tecky.communicate.service;

import java.util.List;

import com.tecky.common.service.GenericService;
import com.tecky.communicate.entity.Expression;

/**
 * @author mekysersoze
 *
 */
public interface ExpressionService extends GenericService<Expression> {

	List<Expression> findExpressionsByPageRequest(int pageNumber, int count);
}
