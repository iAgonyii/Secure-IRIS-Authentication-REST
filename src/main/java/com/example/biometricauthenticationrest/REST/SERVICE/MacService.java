package com.example.biometricauthenticationrest.REST.SERVICE;

import com.example.biometricauthenticationrest.REST.DAO.MacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MacService {

    @Autowired
    MacRepository repository;

    private final Pattern p = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    public String authenticateMac(String mac) {
        if(isValidMac(mac)) {
            return authenticate(mac);
        }
        else {
            return "Invalid MAC Address input";
        }
    }
    
    public String addNewMac(String mac) {
        if(isValidMac(mac)) {
            repository.addNewMac(mac);
            return "Added";
        }
        else {
            return "Invalid MAC Address input";
        }
    }

    private boolean isValidMac(String mac) {
        Matcher m = p.matcher(mac);
        if(m.find()) {
            return true;
        }
        else return false;
    }

    private String authenticate(String mac) {
        if(repository.matchingMacInDb(mac)) {
            return "Successfully authenticated. Password: "; // generate random password here
        }
        else {
            return "No match found";
        }
    }

}
