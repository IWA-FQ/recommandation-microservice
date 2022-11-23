package com.example.recommendationMicroservice.listeners;

import com.example.recommendationMicroservice.listeners.topicDTO.OfferTopicDTO;
import com.example.recommendationMicroservice.services.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OfferListener {

    @Autowired
    private RecommendationService recommendationService;

    Logger LOG = LoggerFactory.getLogger(OfferListener.class);
    @KafkaListener(topics = "offer")
    void listener(OfferTopicDTO data) {
        LOG.info("OFFER change: "+data.toString());
        switch (data.getAction()){
            case CREATE -> this.recommendationService.calculateRecommendationWithOffer(data.getOffer());
            case UPDATE -> this.recommendationService.updateRecommendationsWithOffer(data.getOffer());
            case DELETE -> this.recommendationService.deleteRecommendationsByOfferId(data.getOffer().getId());
        }
    }
}
