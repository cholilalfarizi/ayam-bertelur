package com.cholildev.ayam_bertelur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cholildev.ayam_bertelur.model.Chicken;

public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}
