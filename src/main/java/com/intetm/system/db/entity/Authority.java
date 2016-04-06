package com.intetm.system.db.entity;

public enum Authority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_ANONYMOUS;
    public static final String TABLE = "authorities";
    public static final String COLUMN_USER_ID = "userid";
    public static final String COLUMN_AUTHORITY = "authority";
}
