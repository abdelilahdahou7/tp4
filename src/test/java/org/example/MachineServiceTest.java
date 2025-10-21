package ma.projet;

import ma.projet.entities.Machine;
import ma.projet.service.MachineService;
import ma.projet.service.SalleService;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class MachineServiceTest {

    @Test
    public void testCreateMachine() {
        MachineService ms = new MachineService();
        SalleService ss = new SalleService();
        ms.create(new Machine("TestM", "TestMarque", new Date(), ss.findById(1)));
        assertNotNull(ms.findById(4)); // Assumes 3 machines already created by App
    }
}