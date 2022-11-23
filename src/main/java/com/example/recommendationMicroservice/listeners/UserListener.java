package com.example.recommendationMicroservice.listeners;

import com.example.recommendationMicroservice.listeners.topicDTO.UserTopicDTO;
import com.example.recommendationMicroservice.services.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserListener
{
    @Autowired
    private RecommendationService recommendationService;

    Logger LOG = LoggerFactory.getLogger(UserListener.class);

    @KafkaListener(topics = "user")
    void listener(UserTopicDTO data) {
        LOG.info("USER change: "+data.toString());
        switch (data.getAction()){
            case CREATE -> this.recommendationService.calculateRecommendationWithUser(data.getUser());
            case UPDATE -> this.recommendationService.updateRecommendationsWithUser(data.getUser());
            case DELETE -> this.recommendationService.deleteRecommendationsByOfferId(data.getUser().getId());
        }
    }

}
