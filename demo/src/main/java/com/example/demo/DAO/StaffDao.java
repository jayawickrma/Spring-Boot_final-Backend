package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<StaffEntity,String> {
    @Query(value = "SELECT * FROM staff WHERE memberCode = (SELECT memberCode FROM staff ORDER BY CAST(SUBSTRING(crop_code, 6) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
   StaffEntity findLastRowNative();
}
