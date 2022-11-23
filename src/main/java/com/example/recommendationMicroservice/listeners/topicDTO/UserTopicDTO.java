package com.example.recommendationMicroservice.listeners.topicDTO;

import com.example.recommendationMicroservice.security.model.User;

import java.io.Serializable;

public class UserTopicDTO implements Serializable {
    private User user;
    private ActionEnum action;

    public UserTopicDTO(){
    }

    public UserTopicDTO(User user, ActionEnum action) {
        this.user = user;
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }
}
