package org.example;

import org.example.entities.Salle;
import org.example.services.SalleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Test unitaire pour SalleService
public class SalleServiceTest {

    @Test
    public void testCreateSalle() {
        SalleService salleService = new SalleService();
        Salle salle = new Salle("TestSalle");
        Assertions.assertTrue(salleService.create(salle));
    }
}
