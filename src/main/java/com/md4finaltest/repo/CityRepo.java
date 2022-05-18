package com.md4finaltest.repo;

import com.md4finaltest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Long> {
}
