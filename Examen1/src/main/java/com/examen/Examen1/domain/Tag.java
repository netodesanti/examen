package com.examen.Examen1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    private String name;

    @ManyToMany(mappedBy = "preferences")
    @JsonIgnore
    private Set<User> userPreferences = new HashSet<>();

    @ManyToMany(mappedBy = "tags")
    private Set<Post> postTags = new HashSet<>();

    public void setPostTags(Set<Post> postTags) {
        this.postTags = postTags;
    }

    public Set<User> getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(Set<User> userPreferences) {
        this.userPreferences = userPreferences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
