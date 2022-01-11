package com.example.microserviceloginform.repository;

import com.example.microserviceloginform.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {


}
