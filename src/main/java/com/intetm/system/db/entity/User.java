package com.intetm.system.db.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = User.TABLE)
public class User implements UserDetails {
    public static final String TABLE = "Users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ENABLED = "enabled";

    @Id
    @Column(name = COLUMN_ID, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = COLUMN_USER_NAME)
    private String userName;

    @Column(name = COLUMN_PASSWORD)
    private String password;

    @Column(name = COLUMN_ENABLED)
    private boolean enabled;

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = Authority.TABLE, joinColumns = @JoinColumn(name = Authority.COLUMN_USER_ID, referencedColumnName = COLUMN_ID))
    @Column(name = Authority.COLUMN_AUTHORITY)
    private List<Authority> authorities;

    public User() {
    }

    public User(String userName, String password, Authority authority) {
        this.userName = userName;
        this.password = password;
        this.enabled = true;
        this.authorities = new ArrayList<>();
        this.authorities.add(authority);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
