package com.efrei.JPAExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TransactionManagement {

    @Autowired
    CityRepository repository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void rollBackExample() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2018-10-09");
        } catch (ParseException e) {
        }

        City paris = new City("London");
        Person tintin = new Person("Tintin", 20);
        paris.getPersons().add(tintin);
        tintin.setCity(paris);

        repository.save(paris);

        throw new Exception();
    }
}
