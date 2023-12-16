package com.example.Pets.Palette.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String caption;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;

    private long numOfLikes = 0;

    @ManyToMany(mappedBy = "likedPosts")
    private Set<User> likedByUsers;
}
