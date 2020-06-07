package com.example.biometricauthenticationrest.REST.DAO;

import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.math.BigInteger;

@Repository
public class MacRepository {

    @Autowired
    private EntityManager entityManager;

    public boolean matchingMacInDb(String mac) {
        Query query = entityManager.createNativeQuery("SELECT COUNT(ADDRESS) FROM MAC m WHERE m.ADDRESS = :mac").setParameter("mac", mac);
        BigInteger result = (BigInteger) query.getSingleResult();
        int results = result.intValue();
        return results == 1;
    }

    @Transactional
    public void addNewMac(String mac) {
        entityManager.createNativeQuery("INSERT INTO MAC (ADDRESS) VALUES(:mac)").setParameter("mac", mac).executeUpdate();
    }
}
