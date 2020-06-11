package com.example.biometricauthenticationrest.REST.REST;

import com.example.biometricauthenticationrest.REST.SERVICE.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/mac")
public class MacRest {

    @Autowired
    MacService service;

    @CrossOrigin
    @PostMapping
    public ResponseEntity authenticate(@RequestBody String mac) {
        return new ResponseEntity(service.authenticateMac(mac), HttpStatus.OK);
    }

    @CrossOrigin(origins = "192.169.178.80")
    @PostMapping("/add")
    public ResponseEntity addMac(@RequestBody String mac) {
        return new ResponseEntity(service.addNewMac(mac), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
