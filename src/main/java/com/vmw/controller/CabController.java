package com.vmw.controller;

import com.vmw.entity.*;
import com.vmw.service.CabService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cabService")
public class CabController {

    private CabService cabService;

    @PostMapping(path = "/cab",consumes = "application/json")
    public ResponseEntity<Integer> addCab(@RequestBody final Cab cab) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cabService.addCab(cab).getId());
    }

    @PostMapping(path = "/driver",consumes = "application/json")
    public ResponseEntity<Integer> addDriver(@RequestBody final Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cabService.addDriver(driver).getId());
    }

    @PostMapping(path = "/customer",consumes = "application/json")
    public ResponseEntity<Integer> addCustomer(@RequestBody final Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cabService.addCustomer(customer).getId());
    }

    @PostMapping(path = "/book",consumes = "application/json")
    public ResponseEntity<CabBookResponse> bookCab(@RequestBody final CabBookRequest cabBookRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(cabService.bookCab(cabBookRequest));
    }

}
