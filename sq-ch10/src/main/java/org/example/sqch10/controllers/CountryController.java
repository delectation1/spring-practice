package org.example.sqch10.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.sqch10.model.Country;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 67);
        return ResponseEntity.status(HttpStatus.ACCEPTED) // change HTTP rsp to 202 accepted
                .header("continent", "Europe") // add 3 custom headers to rsp
                .body(c); // sets response body
    }

    @GetMapping("/all")
    public List<Country> countries() {
        return List.of(
                Country.of("France", 67),
                Country.of("Spain", 23));
    }
}