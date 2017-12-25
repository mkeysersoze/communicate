package com.tecky.communicate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecky.common.model.AbstractEntity;
import com.tecky.communicate.enums.Gender;
import com.tecky.communicate.enums.GrammaticalCategory;

/**
 * The expression that a user will manage.
 * 
 * @author mekysersoze
 * 
 */
@Entity
@Table(name = "expression")
public class Expression extends AbstractEntity {
	private static final long serialVersionUID = 4617227571188482767L;

	private String text;

	@Enumerated(EnumType.STRING)
	private GrammaticalCategory grammaticalCategory;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "expression_id")
	private List<Meaning> meanings;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private com.tecky.communicate.enums.Number number;

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

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the number
	 */
	public com.tecky.communicate.enums.Number getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(com.tecky.communicate.enums.Number number) {
		this.number = number;
	}

	/**
	 * @return the grammaticalCategory
	 */
	public GrammaticalCategory getGrammaticalCategory() {
		return grammaticalCategory;
	}

	/**
	 * @param grammaticalCategory
	 *            the grammaticalCategory to set
	 */
	public void setGrammaticalCategory(GrammaticalCategory grammaticalCategory) {
		this.grammaticalCategory = grammaticalCategory;
	}

}
