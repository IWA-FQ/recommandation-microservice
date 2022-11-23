package com.example.recommendationMicroservice.entities.entitiesId;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecruitingId implements Serializable {
    private Integer idEmployee;
    private Integer idOffer;

    public RecruitingId(){}

    public RecruitingId(Integer idEmployee, Integer idOffer) {
        this.idEmployee = idEmployee;
        this.idOffer = idOffer;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }
}
