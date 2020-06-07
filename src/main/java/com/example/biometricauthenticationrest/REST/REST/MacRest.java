package com.example.biometricauthenticationrest.REST.REST;

import com.example.biometricauthenticationrest.REST.SERVICE.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/mac")
public class MacRest {

    @Autowired
    MacService service;

    @PostMapping
    public ResponseEntity authenticate(@RequestBody String mac) {
        return new ResponseEntity(service.authenticateMac(mac), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addMac(@RequestBody String mac) {
        return new ResponseEntity(service.addNewMac(mac), HttpStatus.OK);
    }
}
