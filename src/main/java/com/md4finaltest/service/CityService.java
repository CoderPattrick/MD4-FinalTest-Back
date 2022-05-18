package com.md4finaltest.service;

import com.md4finaltest.model.City;
import com.md4finaltest.model.Nation;

public interface CityService extends GeneralService<City>{
    Iterable<City> findByNation(Nation nation);
}
