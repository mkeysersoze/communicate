package com.tecky.communicate.entity;

import com.tecky.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A user can add examples related to a meaning of an expression.
 *
 * @author mkysersoze
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "example")
public class Example extends AbstractEntity {
    private static final long serialVersionUID = -2485976520787021309L;

    private String text;
}