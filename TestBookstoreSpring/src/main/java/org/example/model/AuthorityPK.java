package org.example.model;

import java.io.Serializable;

public class AuthorityPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String authority;
    public AuthorityPK() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
