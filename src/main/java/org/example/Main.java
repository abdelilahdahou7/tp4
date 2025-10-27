package org.example;

import org.example.entities.Machine;
import org.example.entities.Salle;
import org.example.services.MachineService;
import org.example.services.SalleService;
import org.example.util.HibernateUtil;

import java.util.Date;
import java.util.List;

// Classe principale de test
public class Main {
    public static void main(String[] args) {
        // Initialisation des services
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Création des salles
        Salle salleA = new Salle("SA");
        Salle salleB = new Salle("SB");
        salleService.create(salleA);
        salleService.create(salleB);

        // Création des machines et association aux salles
        machineService.create(new Machine("M01", new Date(), salleA));
        machineService.create(new Machine("M02", new Date(), salleA));
        machineService.create(new Machine("M03", new Date(), salleB));

        // Affichage des salles et de leurs machines
        System.out.println("Liste des salles et de leurs machines :");
        List<Salle> salles = salleService.findAll();
        for (Salle s : salles) {
            System.out.println("Salle : " + s.getCode());
            for (Machine m : s.getMachines()) {
                System.out.println("  -> Machine : " + m.getRef());
            }
        }

        // Test de la recherche de machines entre deux dates
        System.out.println("\nRecherche des machines achetées aujourd'hui :");
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        List<Machine> machinesBetween = machineService.findBetweenDates(today, tomorrow);
        for (Machine m : machinesBetween) {
            System.out.println("Machine : " + m.getRef() + ", Date d'achat : " + m.getDateAchat());
        }

        // Fermeture de la SessionFactory
        HibernateUtil.shutdown();
    }
}
