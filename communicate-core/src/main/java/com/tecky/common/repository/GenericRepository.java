package com.tecky.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecky.common.model.AbstractEntity;

/**
 * @author mekysersoze
 *
 * @param <T>
 *            : classe entité qui hérite de {@link AbstractEntity }
 */
public interface GenericRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {

}
