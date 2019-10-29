package com.tecky.dao;

import com.tecky.communicate.repository.ExpressionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBTest {

    @Autowired
    private ExpressionRepository expressionRepository;

    @Test
    public void testSaveExpression() {

		/*Expression expression = new Expression();
		expression.setId(1L);
		expressionRepository.save(expression);
		Expression found = expressionRepository.findOne(1L);
		Assert.assertEquals("Débrouillard", found.getText());*/
    }
}
