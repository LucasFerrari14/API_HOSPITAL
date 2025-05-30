package com.example.springboot.hospitalizationslog.repository;

import com.example.springboot.hospitalizationslog.model.HospitalizationsLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationsLogRepository extends JpaRepository<HospitalizationsLogModel, Long> {

    @Query(nativeQuery = true,
        value = "SELECT H.* FROM CEH_HOSPITAL H WHERE CD_HOSPITAL = :id")
    HospitalizationsLogModel buscarPorID(@Param("id") Long id);

}
