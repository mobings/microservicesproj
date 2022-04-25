package com.cinema.App.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.App.model.ServiceOneEntity;

@Repository
public interface ServiceOneRepository extends JpaRepository<ServiceOneEntity, Integer>
{
}

