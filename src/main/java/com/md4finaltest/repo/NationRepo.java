package com.md4finaltest.repo;

import com.md4finaltest.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepo extends JpaRepository<Nation,Long> {
}
