package com.example.springboot.bed.repository;

import com.example.springboot.bed.model.BedModel;
import com.example.springboot.hwing.model.HWingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<BedModel, Long> {
    @Query(nativeQuery = true,
            value = "SELECT B.* FROM CEH_LEITO B " +
                    "WHERE B.DE_SPECIALTY = :cdSpecialty  AND" +
                    "B.CD_PATIENT IS NULL")
    List<BedModel> findFreeBedBySpecialty(@Param("cdSpecialty") Integer cdSpecialty);
}
