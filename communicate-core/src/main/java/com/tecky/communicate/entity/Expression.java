package com.tecky.communicate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecky.common.model.AbstractEntity;

/**
 * The expression that a user will manage.
 * 
 * @author mekysersoze
 * 
 */
@Entity
@Table(name="expression")
public class Expression extends AbstractEntity {
	private static final long serialVersionUID = 4617227571188482767L;

	private String text;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "expression_id")
	private List<Meaning> meanings;

	public Expression() {
	}

	public Expression(String text, List<Meaning> meanings) {
		super();
		this.text = text;
		this.meanings = meanings;
	}
	

	@Override
	public String toString() {
		return "Expression [text=" + text + "]";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Meaning> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<Meaning> meanings) {
		this.meanings = meanings;
	}

}
