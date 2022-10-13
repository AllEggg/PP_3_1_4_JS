package ru.kata.spring.boot_security.demo.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String roleName) {
        this.name = roleName;
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    @Transient
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String roleName) {
        this.name = roleName;
    }

    @Override
    public String toString() {
        return name;
    }
}
