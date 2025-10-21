package ma.projet;

import ma.projet.entities.Machine;
import ma.projet.entities.Salle;
import ma.projet.service.MachineService;
import ma.projet.service.SalleService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SalleService ss = new SalleService();
        MachineService ms = new MachineService();

        // Créer des salles
        ss.create(new Salle("SA"));
        ss.create(new Salle("SB"));

        // Créer des machines
        ms.create(new Machine("M01", "HP", new Date(), ss.findById(1)));
        ms.create(new Machine("M02", "Dell", new Date(), ss.findById(1)));
        ms.create(new Machine("M03", "Lenovo", new Date(), ss.findById(2)));

        // Afficher les machines
        for(Machine m : ms.findAll()){
            System.out.println(m.getRef());
        }
    }
}