package com.revature.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne(targetEntity = com.revature.data.User.class)
    @JoinColumn(name = "userid")
    @NotBlank
    private int userid;

    @Column(name = "movieid", nullable = false)
    @NotBlank
    // @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String movieid;

    @Column(name = "watched")
    @NotBlank
    private Boolean watched = false;

    @Column(name = "tracked")
    @NotBlank
    private Boolean tracked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((movieid == null) ? 0 : movieid.hashCode());
        result = prime * result + ((tracked == null) ? 0 : tracked.hashCode());
        result = prime * result + userid;
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
        if (userid != other.userid)
            return false;
        if (watched == null) {
            if (other.watched != null)
                return false;
        } else if (!watched.equals(other.watched))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MovieTracker [id=" + id + ", movieid=" + movieid + ", tracked=" + tracked + ", userid=" + userid
                + ", watched=" + watched + "]";
    }

    public MovieTracker(int id, @NotBlank int userid, @NotBlank String movieid, @NotBlank Boolean watched,
            @NotBlank Boolean tracked) {
        this.id = id;
        this.userid = userid;
        this.movieid = movieid;
        this.watched = watched;
        this.tracked = tracked;
    }

    public MovieTracker() {
    }

    

}
