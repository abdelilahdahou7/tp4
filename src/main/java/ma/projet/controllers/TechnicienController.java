package ma.projet.controllers;

import ma.projet.entities.Technicien;
import ma.projet.services.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    @GetMapping
    public List<Technicien> findAllTechniciens() {
        return technicienService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findTechnicienById(@PathVariable Long id) {
        Technicien technicien = technicienService.findById(id);
        if (technicien == null) {
            return new ResponseEntity<>("Technicien with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(technicien);
    }

    @PostMapping
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        technicien.setId(null);
        return technicienService.save(technicien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTechnicien(@PathVariable Long id, @RequestBody Technicien technicienDetails) {
        Technicien technicien = technicienService.findById(id);
        if (technicien == null) {
            return new ResponseEntity<>("Technicien with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        technicien.setNom(technicienDetails.getNom());
        technicien.setSpecialite(technicienDetails.getSpecialite());
        return ResponseEntity.ok(technicienService.update(technicien));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTechnicien(@PathVariable Long id) {
        Technicien technicien = technicienService.findById(id);
        if (technicien == null) {
            return new ResponseEntity<>("Technicien with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        technicienService.delete(technicien);
        return ResponseEntity.ok("Technicien with id " + id + " deleted");
    }
}
