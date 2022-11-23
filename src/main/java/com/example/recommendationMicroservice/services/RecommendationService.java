package com.example.recommendationMicroservice.services;

import com.example.recommendationMicroservice.entities.Offer;
import com.example.recommendationMicroservice.entities.Recommendation;
import com.example.recommendationMicroservice.entities.entitiesId.RecommendationId;
import com.example.recommendationMicroservice.repositories.RecommendationRepository;
import com.example.recommendationMicroservice.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    private static List<Offer> offers;
    private static List<User> users;

    /*** CRUD METHODS ***/

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private ErrorHandlerService<Recommendation> errorHandlerService;

    public ResponseEntity<List<Recommendation>> getAll(){
        return errorHandlerService.getAllResponse(this.recommendationRepository.findAll());
    }

    public ResponseEntity<Recommendation> getByOfferAndApplicant(Integer id_offer, Integer id_jobseeker) {
        RecommendationId recommendationId = new RecommendationId(id_offer,id_jobseeker);
        return errorHandlerService.getResponse(this.recommendationRepository.findById(recommendationId));
    }

    public ResponseEntity deleteRecommendationsByOfferId(Integer id_offer) {
        this.recommendationRepository.deleteAllByIdOffer(id_offer);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity deleteRecommendationsByUserId(Integer id_user) {
        this.recommendationRepository.deleteAllByIdUser(id_user);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*** RECOMMENDATION SYSTEM ***/

    /**
     *
     * @param offer
     */
    public void calculateRecommendationWithOffer(Offer offer) {
        List<Recommendation> list = new ArrayList<>();
        for (User user: this.users) {
            Recommendation rec = new Recommendation();
            RecommendationId recommendationId = new RecommendationId(offer.getId(), user.getId());
            if(matchWorkField(user,offer)) {
                rec.setScore(rec.getScore()+1);
            }
            if(matchLocation(user,offer)) {
                rec.setScore(rec.getScore()+1);
            }
            if(rec.getScore()>0){
                rec.setId(recommendationId);
                list.add(rec);
            }
        }
        this.recommendationRepository.saveAll(list);
    }

    /**
     *
     * @param user
     */
    public void calculateRecommendationWithUser(User user) {
        List<Recommendation> list = new ArrayList<>();
        for (Offer offer: this.offers) {
            Recommendation rec = new Recommendation();
            RecommendationId recommendationId = new RecommendationId(user.getId(), user.getId());
            if(matchWorkField(user,offer)) {
                rec.setScore(rec.getScore()+1);
            }
            if(matchLocation(user,offer)) {
                rec.setScore(rec.getScore()+1);
            }
            if(rec.getScore()>0){
                rec.setId(recommendationId);
                list.add(rec);
            }
        }
        this.recommendationRepository.saveAll(list);
    }

    /**
     *
     * @param user
     * @param offer
     * @return true if the user and the offer have the same location, else false
     */
    private Boolean matchWorkField(User user, Offer offer) {
        return user.getCity() == offer.getCity();
    }

    /**
     *
     * @param user
     * @param offer
     * @return true if a keyword from the user workfield is found in the offer keywords, else false
     */
    private Boolean matchLocation(User user, Offer offer) {
        String[] user_keywords = user.getWork_field().split(" ");
        String[] offer_keywords = offer.getKeywords().split(" ");
        for(String k1 : offer_keywords) {
            for(String k2 : user_keywords) {
                if(k1 == k2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param offer
     */
    public void updateRecommendationsWithOffer(Offer offer) {
        this.deleteRecommendationsByOfferId(offer.getId());
        this.calculateRecommendationWithOffer(offer);
    }

    /**
     *
     * @param user
     */
    public void updateRecommendationsWithUser(User user) {
        this.deleteRecommendationsByUserId(user.getId());
        this.calculateRecommendationWithUser(user);
    }
}
