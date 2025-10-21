package ma.projet.controllers;

import ma.projet.entities.Salle;
import ma.projet.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleController {

    @Autowired
    private SalleService salleService;

    @GetMapping
    public List<Salle> findAllSalles() {
        return salleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findSalleById(@PathVariable Long id) {
        Salle salle = salleService.findById(id);
        if (salle == null) {
            return new ResponseEntity<>("Salle with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(salle);
    }

    @PostMapping
    public Salle createSalle(@RequestBody Salle salle) {
        salle.setId(null); // Ensure new entity
        return salleService.save(salle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSalle(@PathVariable Long id, @RequestBody Salle salleDetails) {
        Salle salle = salleService.findById(id);
        if (salle == null) {
            return new ResponseEntity<>("Salle with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        salle.setCode(salleDetails.getCode());
        return ResponseEntity.ok(salleService.update(salle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSalle(@PathVariable Long id) {
        Salle salle = salleService.findById(id);
        if (salle == null) {
            return new ResponseEntity<>("Salle with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        salleService.delete(salle);
        return ResponseEntity.ok("Salle with id " + id + " deleted");
    }
}
