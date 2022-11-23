package com.example.recommendationMicroservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_offer\"")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "city")
    private String city;
    @Column(name = "city_code")
    private Integer city_code;
    @Column(name = "nb_positions")
    private Integer nb_positions;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "advantage")
    private String advantage;
    @Column(name = "id_employer")
    private Integer idEmployer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCity_code() {
        return city_code;
    }

    public void setCity_code(Integer city_code) {
        this.city_code = city_code;
    }

    public Integer getNb_positions() {
        return nb_positions;
    }

    public void setNb_positions(Integer nb_positions) {
        this.nb_positions = nb_positions;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + this.getId() +
                ", title='" + this.getTitle() +
                ", description='" + this.getDescription() +
                ", start_date='" + this.getStart_date() +
                ", end_date='" + this.getEnd_date() +
                ", city='" + this.getCity() +
                ", city_code='" + this.getCity_code() +
                ", nb_positions='" + this.getNb_positions() +
                ", salary='" + this.getSalary() +
                ", advantage='" + this.getAdvantage() +
                ", id_employer='" + this.getIdEmployer() +
                '}';
    }
}

