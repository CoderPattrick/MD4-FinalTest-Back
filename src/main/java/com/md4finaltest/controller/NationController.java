package com.md4finaltest.controller;

import com.md4finaltest.model.Nation;
import com.md4finaltest.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/nation")
public class NationController {
    @Autowired
    private NationService nationService;

    @GetMapping
    public ResponseEntity<Iterable<Nation>> findAll() {
        return new ResponseEntity<>(nationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nation> findById(@PathVariable Long id) {
        return new ResponseEntity<>(nationService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Nation> save(@RequestBody Nation nation) {
        return new ResponseEntity<>(nationService.save(nation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nation> edit(@PathVariable Long id, @RequestBody Nation nation) {
        nation.setId(id);
        return new ResponseEntity<>(nationService.save(nation), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Nation> delete(@PathVariable Long id) {
        Optional<Nation> nation = nationService.findById(id);
        if(nation.isPresent()){
            nationService.deleteById(id);
            return new ResponseEntity<>(nation.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
