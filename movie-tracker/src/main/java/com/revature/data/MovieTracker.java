package com.revature.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "movie_tracker")
@EntityListeners(AuditingEntityListener.class)
public class MovieTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @OneToOne(targetEntity = com.revature.data.User.class)
    // @JoinColumn(name = "username")
    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    @Column(name = "movieid", nullable = false)
    @NotBlank
    // @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String movieid;

    @Column(name = "watched")
    private Boolean watched = false;

    @Column(name = "tracked")
    private Boolean tracked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public Boolean getTracked() {
        return tracked;
    }

    public void setTracked(Boolean tracked) {
        this.tracked = tracked;
    }

    @Override
    public String toString() {
        return "MovieTracker [id=" + id + ", movieid=" + movieid + ", tracked=" + tracked + ", username=" + username
                + ", watched=" + watched + "]";
    }

    public MovieTracker(int id, @NotBlank String username, @NotBlank String movieid, @NotBlank Boolean watched,
            @NotBlank Boolean tracked) {
        this.id = id;
        this.username = username;
        this.movieid = movieid;
        this.watched = watched;
        this.tracked = tracked;
    }

    public MovieTracker() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((movieid == null) ? 0 : movieid.hashCode());
        result = prime * result + ((tracked == null) ? 0 : tracked.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((watched == null) ? 0 : watched.hashCode());
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
        MovieTracker other = (MovieTracker) obj;
        if (id != other.id)
            return false;
        if (movieid == null) {
            if (other.movieid != null)
                return false;
        } else if (!movieid.equals(other.movieid))
            return false;
        if (tracked == null) {
            if (other.tracked != null)
                return false;
        } else if (!tracked.equals(other.tracked))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (watched == null) {
            if (other.watched != null)
                return false;
        } else if (!watched.equals(other.watched))
            return false;
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }   

}
