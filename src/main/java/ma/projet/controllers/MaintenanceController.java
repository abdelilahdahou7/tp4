package ma.projet.controllers;

import ma.projet.entities.Maintenance;
import ma.projet.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> findAllMaintenances() {
        return maintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findMaintenanceById(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.findById(id);
        if (maintenance == null) {
            return new ResponseEntity<>("Maintenance with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(maintenance);
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        maintenance.setId(null);
        return maintenanceService.save(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenanceDetails) {
        Maintenance maintenance = maintenanceService.findById(id);
        if (maintenance == null) {
            return new ResponseEntity<>("Maintenance with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        maintenance.setDateDebut(maintenanceDetails.getDateDebut());
        maintenance.setDateFin(maintenanceDetails.getDateFin());
        maintenance.setDescription(maintenanceDetails.getDescription());
        maintenance.setMachine(maintenanceDetails.getMachine());
        maintenance.setTechnicien(maintenanceDetails.getTechnicien());
        return ResponseEntity.ok(maintenanceService.update(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaintenance(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.findById(id);
        if (maintenance == null) {
            return new ResponseEntity<>("Maintenance with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        maintenanceService.delete(maintenance);
        return ResponseEntity.ok("Maintenance with id " + id + " deleted");
    }
}
