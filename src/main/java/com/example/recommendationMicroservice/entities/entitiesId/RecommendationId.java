package com.example.recommendationMicroservice.entities.entitiesId;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecommendationId implements Serializable {

    private Integer idOffer;
    private Integer idJobseeker;

    public RecommendationId(){}

    public RecommendationId(Integer idOffer, Integer idJobseeker) {
        this.idOffer = idOffer;
        this.idJobseeker = idJobseeker;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public Integer getIdJobseeker() {
        return idJobseeker;
    }

    public void setIdJobseeker(Integer idJobseeker) {
        this.idJobseeker = idJobseeker;
    }
}
