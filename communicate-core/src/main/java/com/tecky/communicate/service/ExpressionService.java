package com.tecky.communicate.service;

import com.tecky.common.service.GenericService;
import com.tecky.communicate.entity.Expression;

import java.util.List;

/**
 * @author mekysersoze
 */
public interface ExpressionService extends GenericService<Expression> {

    List<Expression> findExpressionsByPageRequest(int pageNumber, int count);
}
