package com.tecky.communicate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecky.common.model.AbstractEntity;

/**
 * A class representing the meaning of a given expression.
 * @author mekysersoze
 * 
 */
@Entity
@Table(name="meaning")
public class Meaning extends AbstractEntity {
	private static final long serialVersionUID = 6594666817780817969L;

	private String text;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "meaning_id")
	private List<Example> examples;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Example> getExamples() {
		return examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

}
