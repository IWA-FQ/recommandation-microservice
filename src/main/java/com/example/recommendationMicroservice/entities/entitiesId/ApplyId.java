package com.example.recommendationMicroservice.entities.entitiesId;

import java.io.Serializable;

public class ApplyId implements Serializable {
    private Integer idApplicant;
    private Integer idOffer;

    public ApplyId(){}

    public ApplyId(Integer idApplicant, Integer idOffer) {
        this.idApplicant = idApplicant;
        this.idOffer = idOffer;
    }

    public Integer getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(Integer idApplicant) {
        this.idApplicant = idApplicant;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }
}
