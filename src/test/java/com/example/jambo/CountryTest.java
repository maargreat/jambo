package com.example.jambo;

import com.example.jambo.parameters.models.Country;
import com.example.jambo.parameters.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//to indicate a rest api test.to test if the repo is returning the actual data we want returned
public class CountryTest {

    @Autowired
    private CountryRepository repository;

    //Test1=FindById supposed to send actual data to db, test actual data and return value

    @Test
    public void testFindById(){
        Country country= repository.findById(6).orElse(null);
        assertNotNull(country);
    }

    //test2=FindByIdEmpty. send nonexistent data to db and test if it returns null

   /* @Test
    public void testFindByIdEmpty(){
        Country country= repository.findById(600).orElse(null);
        assertNotNull(country);
    }
    
    */

    @Test
    public void testFindByIdNull(){
        Country country= repository.findById(600).orElse(null);
        assertNull(country);
    }

}
