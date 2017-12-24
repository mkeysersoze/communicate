package com.tecky.communicate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.tecky.common.model.AbstractEntity;

/**
 * A user can add examples related to a meaning of an expression.
 *
 * @author mkysersoze
 *
 */

@Entity
@Table(name = "example")
public class Example extends AbstractEntity {
	private static final long serialVersionUID = -2485976520787021309L;

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
