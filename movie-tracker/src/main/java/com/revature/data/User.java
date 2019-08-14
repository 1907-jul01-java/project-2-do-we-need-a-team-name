package com.revature.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "username", nullable = false)
    @NotBlank
    // @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String username;

    @Column(name = "pw", nullable = false)
    @NotBlank
    // @Pattern(regexp =
    // "^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$")
    private String password;

    @Column (name = "guestid")
    private String guestid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGuestid() {
        return guestid;
    }

    public void setGuestid(String guestid) {
        this.guestid = guestid;
    }

    public User() {
        super();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((guestid == null) ? 0 : guestid.hashCode());   
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + userid;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (guestid == null) {
            if (other.guestid != null)
                return false;
        } else if (!guestid.equals(other.guestid))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userid != other.userid)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
	public String toString() {
		return "User [guestid=" + guestid + ", password="
				+ password + ", userid=" + userid + ", username=" + username + "]";
	}

    public User(int userid, @NotBlank String username, @NotBlank String password, String firstname, String lastname,
            String guestid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.guestid = guestid;
    }

    public User(int userid, @NotBlank String username, @NotBlank String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

}