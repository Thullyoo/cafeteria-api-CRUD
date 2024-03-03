package com.example.cafeteriaapi.repository;


import com.example.cafeteriaapi.model.Cafe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, String> {

}
