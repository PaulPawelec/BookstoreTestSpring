package org.example.model;

import javax.persistence.*;

@IdClass(AuthorityPK.class)
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private User user;

    public Authority() {
    }
    public Authority(User user, String authority) {
        this.username = user.getUsername();
        this.authority = authority;
        this.user = user;
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
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
