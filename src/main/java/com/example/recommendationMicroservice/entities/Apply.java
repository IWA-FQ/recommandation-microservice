package com.example.recommendationMicroservice.entities;

import com.example.recommendationMicroservice.entities.entitiesId.ApplyId;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "apply")
public class Apply {

    @EmbeddedId
    private ApplyId id;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    public ApplyId getId() {
        return id;
    }

    public void setId(ApplyId id) {
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
        return "Offer{" +
                ", offer='" + this.getId().getIdOffer() +
                ", applicant='" + this.getId().getIdApplicant() +
                ", date='" + this.getLastUpdated() +
                '}';
    }
}

