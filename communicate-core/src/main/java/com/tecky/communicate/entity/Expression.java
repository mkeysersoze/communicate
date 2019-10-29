package com.tecky.communicate.entity;

import com.tecky.common.model.AbstractEntity;
import com.tecky.communicate.enums.Gender;
import com.tecky.communicate.enums.GrammaticalClassification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * The expression that a user will manage.
 *
 * @author mekysersoze
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXPRESSION")
public class Expression extends AbstractEntity {
    private static final long serialVersionUID = 4617227571188482767L;

    private String text;

    @Enumerated(EnumType.STRING)
    private GrammaticalClassification grammaticalClassification;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "expression_id")
    private List<Meaning> meanings;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String plural;
}