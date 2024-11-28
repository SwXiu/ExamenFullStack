package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
