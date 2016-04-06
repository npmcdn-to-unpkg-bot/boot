package com.intetm.db.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_ANONYMOUS;
    public static final String TABLE = "authorities";
    public static final String COLUMN_USER_ID = "userid";
    public static final String COLUMN_AUTHORITY = "authority";

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String ANONYMOUS = "ANONYMOUS";


    @Override
    public String getAuthority() {
        return name();
    }
}
