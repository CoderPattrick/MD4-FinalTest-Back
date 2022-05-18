package com.md4finaltest.controller;

import com.md4finaltest.model.City;
import com.md4finaltest.model.Nation;
import com.md4finaltest.service.CityService;
import com.md4finaltest.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return new ResponseEntity<>(cityService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> edit(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if(city.isPresent()){
            cityService.deleteById(id);
            return new ResponseEntity<>(city.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/nation")
    public ResponseEntity<Iterable<City>> findByNation(@RequestParam Long nation_id) {
        Nation nation = nationService.findById(nation_id).get();
        return new ResponseEntity<>(cityService.findByNation(nation), HttpStatus.OK);

    }
}
