package com.tecky.common.repository;

import com.tecky.common.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @param <T> : classe entité qui hérite de {@link AbstractEntity }
 * @author mekysersoze
 */
public interface GenericRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {

}
