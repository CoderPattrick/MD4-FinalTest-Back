package com.md4finaltest.service;

import com.md4finaltest.model.City;
import com.md4finaltest.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepo cityRepo;

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
