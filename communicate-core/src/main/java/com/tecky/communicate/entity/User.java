package com.tecky.communicate.entity;

import com.tecky.common.model.AbstractEntity;
import com.tecky.communicate.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A class representing the application user.
 *
 * @author mekysersoze
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`USERS`")
public class User extends AbstractEntity {

    private static final long serialVersionUID = 7755116203322848971L;

    @NotNull
    @Size(min = 1, max = 16, message = "{firstname.size}")
    private String firstname;

    @NotNull
    @Size(min = 1, max = 16, message = "{lastname.size}")
    private String lastname;

    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    private Role role;

    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 8, max = 16, message = "{password.size}")
    private String password;
}