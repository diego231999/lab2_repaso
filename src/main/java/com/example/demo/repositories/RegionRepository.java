package com.example.demo.repositories;

import com.example.demo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findByRegiondescriptionContainingOrderByRegiondescriptionDesc (String text);
}
