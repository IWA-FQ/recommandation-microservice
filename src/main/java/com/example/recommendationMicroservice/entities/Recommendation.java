package com.example.recommendationMicroservice.entities;

import com.example.recommendationMicroservice.entities.entitiesId.RecommendationId;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "recommendation")
public class Recommendation {
    @EmbeddedId
    private RecommendationId id;
    @Column(name = "score")
    private Integer score;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    public Recommendation(){
        this.id = new RecommendationId();
        this.lastUpdated = new Timestamp(0);
        this.score = 0;
    }

    public Recommendation(Integer idOffer, Integer idJobseeker){
        this.id = new RecommendationId(idOffer,idJobseeker);
        this.lastUpdated = new Timestamp(0);
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public RecommendationId getId() {
        return id;
    }

    public void setId(RecommendationId id) {
        this.id = id;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_offer=" + this.getId().getIdOffer() +
                ", id_jobseeker='" + this.getId().getIdJobseeker() +
                ", last_updated='" + this.getLastUpdated() +
                '}';
    }
}
