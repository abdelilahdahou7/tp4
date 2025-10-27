package org.example;

import org.example.entities.Machine;
import org.example.entities.Salle;
import org.example.services.MachineService;
import org.example.services.SalleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

// Test unitaire pour MachineService
public class MachineServiceTest {

    @Test
    public void testCreateMachine() {
        SalleService salleService = new SalleService();
        Salle salle = new Salle("TestMachineSalle");
        salleService.create(salle);

        MachineService machineService = new MachineService();
        Machine machine = new Machine("TestMachine", new Date(), salle);
        Assertions.assertTrue(machineService.create(machine));
    }
}
