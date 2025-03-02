package com.example.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_CHAT")
public class ChatModel implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
    private Set<MessageModel> messages = new HashSet<>();

    public Set<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageModel> messages) {
        this.messages = messages;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
