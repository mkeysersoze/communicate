package com.tecky.common.service.impl;

import com.tecky.common.model.AbstractEntity;
import com.tecky.common.repository.GenericRepository;
import com.tecky.common.service.GenericService;

/**
 * @param <T> : an entity class that inherits {@link AbstractEntity }
 * @author mekysersoze
 */
public abstract class GenericServiceImpl<T extends AbstractEntity> implements GenericService<T> {

    protected abstract GenericRepository<T> getMainRepository();

}
