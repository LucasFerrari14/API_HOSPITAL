package com.example.springboot.hwing.repository;

import com.example.springboot.hwing.model.HWingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HWingRepository extends JpaRepository<HWingModel, Long> {
}
