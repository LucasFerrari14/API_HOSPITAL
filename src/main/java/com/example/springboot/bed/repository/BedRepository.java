package com.example.springboot.bed.repository;

import com.example.springboot.bed.model.BedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<BedModel, Long> {
}
