package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropDao extends JpaRepository<CropEntity,String> {
    @Query(value = "SELECT * FROM crop WHERE crop_code = (SELECT crop_code FROM crop ORDER BY CAST(SUBSTRING(crop_code, 6) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    CropEntity findLastRowNative();
    @Query(value = "SELECT * FROM crop ORDER BY CAST(SUBSTRING(crop_code, 6) AS UNSIGNED);",nativeQuery = true)
    @Override
    List<CropEntity> findAll();
}
