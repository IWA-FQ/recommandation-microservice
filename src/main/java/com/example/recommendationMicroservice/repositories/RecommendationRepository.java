package com.example.recommendationMicroservice.repositories;

import com.example.recommendationMicroservice.entities.Recommendation;
import com.example.recommendationMicroservice.entities.entitiesId.RecommendationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecommendationRepository extends JpaRepository<Recommendation, RecommendationId> {

    @Query(
            value = "DELETE FROM recommendation r WHERE r.id.idOffer = ?1"
    )
    void deleteAllByIdOffer(Integer id_offer);

    @Query(
            value = "DELETE FROM recommendation r WHERE r.id.idJobseeker = ?1"
    )
    void deleteAllByIdUser(Integer id_user);

}
