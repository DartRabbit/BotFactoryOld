package com.botfactory.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Getter @Setter private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    @Length(min = 5)
    @JsonIgnore
    @Getter @Setter private String password;

    @Column(name = "registered")
    @NotNull
    @Getter @Setter private LocalDateTime registered;

    @Column(name = "enabled")
    @Getter @Setter private boolean enabled;

    public User() {
    }

    public User(int id, String name, String email, String password, boolean enabled) {
        super.setId(id);
        super.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", email=" + email +
                ", name=" + name +
                ", enabled=" + enabled +
                ", registered=" + registered +
                '}';
    }
}
