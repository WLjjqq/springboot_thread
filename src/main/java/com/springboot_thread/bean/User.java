package com.springboot_thread.bean;

import lombok.Data;

/**
 * 作用：
 */
@Data
public class User {
    private String userId;
    private String username;
    private String password;

    public User() {

    }

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
}
