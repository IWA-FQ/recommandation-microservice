package com.example.recommendationMicroservice.entities;

import com.example.recommendationMicroservice.entities.entitiesId.RecruitingId;
import javax.persistence.*;

@Entity
@Table(name = "recruiting", schema = "public")
public class Recruiting {

    @Id
    @EmbeddedId
    private RecruitingId id;
    @Column(name = "employee_rate")
    private Integer rateEmployee;
    @Column(name = "employer_rate")
    private Integer rateEmployer;

    public RecruitingId getId() {
        return id;
    }

    public void setId(RecruitingId id) {
        this.id = id;
    }

    public Integer getRateEmployee() {
        return rateEmployee;
    }

    public void setRateEmployee(Integer rateEmployee) {
        this.rateEmployee = rateEmployee;
    }

    public Integer getRateEmployer() {
        return rateEmployer;
    }

    public void setRateEmployer(Integer rateEmployer) {
        this.rateEmployer = rateEmployer;
    }

    @Override
    public String toString() {
        return "Offer{" +
                ", offer='" + this.getId().getIdOffer() +
                ", applicant='" + this.getId().getIdEmployee() +
                ", rate_employee='" + this.getRateEmployee() +
                ", rate_employer='" + this.getRateEmployer() +
                '}';
    }
}
