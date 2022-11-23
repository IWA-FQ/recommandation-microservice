package com.example.recommendationMicroservice.listeners.topicDTO;

import com.example.recommendationMicroservice.entities.Offer;

import java.io.Serializable;

public class OfferTopicDTO implements Serializable {
    private Offer offer;
    private ActionEnum action;

    public OfferTopicDTO(){
    }

    public OfferTopicDTO(Offer offer, ActionEnum action) {
        this.offer = offer;
        this.action = action;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }
}
