package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.staffDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDetailsDao extends JpaRepository<staffDetailsEntity,String> {
}
