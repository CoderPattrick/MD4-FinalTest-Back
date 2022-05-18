package com.md4finaltest.service;

import com.md4finaltest.model.Nation;
import com.md4finaltest.repo.NationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationServiceImpl implements NationService{
    @Autowired
    private NationRepo nationRepo;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepo.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return nationRepo.findById(id);
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepo.save(nation);
    }

    @Override
    public void deleteById(Long id) {
        nationRepo.deleteById(id);
    }
}
