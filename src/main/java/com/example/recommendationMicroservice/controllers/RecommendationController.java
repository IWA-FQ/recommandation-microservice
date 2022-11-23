package com.example.recommendationMicroservice.controllers;

import com.example.recommendationMicroservice.entities.Recommendation;
import com.example.recommendationMicroservice.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController
{
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/all")
    public ResponseEntity<List<Recommendation>> getAll() {
        return recommendationService.getAll();
    }

    @GetMapping("/{id_offer}/jobseeker/{id_jobseeker}")
    public ResponseEntity<Recommendation> getById(@PathVariable("id_offer") Integer id_offer, @PathVariable("id_jobseeker") Integer id_jobseeker) {
        return recommendationService.getByOfferAndApplicant(id_offer,id_jobseeker);
    }

}
