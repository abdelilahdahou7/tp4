package ma.projet;

import ma.projet.entities.Salle;
import ma.projet.service.SalleService;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalleServiceTest {

    @Test
    public void testCreateSalle() {
        SalleService ss = new SalleService();
        ss.create(new Salle("TestSalle"));
        assertNotNull(ss.findById(3)); // Assumes 2 salles already created by App
    }
}