package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.staffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<staffEntity,String> {
}
