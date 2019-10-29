package com.tecky.communicate.entity;

import com.tecky.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * A class representing the meaning of a given expression.
 *
 * @author mekysersoze
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meaning")
public class Meaning extends AbstractEntity {
    private static final long serialVersionUID = 6594666817780817969L;

    private String text;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meaning_id")
    private List<Example> examples;

}