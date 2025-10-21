package ma.projet.controllers;

import ma.projet.entities.Machine;
import ma.projet.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping
    public List<Machine> findAllMachines() {
        return machineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findMachineById(@PathVariable Long id) {
        Machine machine = machineService.findById(id);
        if (machine == null) {
            return new ResponseEntity<>("Machine with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(machine);
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        machine.setId(null);
        return machineService.save(machine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMachine(@PathVariable Long id, @RequestBody Machine machineDetails) {
        Machine machine = machineService.findById(id);
        if (machine == null) {
            return new ResponseEntity<>("Machine with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        machine.setRef(machineDetails.getRef());
        machine.setMarque(machineDetails.getMarque());
        machine.setDateAchat(machineDetails.getDateAchat());
        machine.setSalle(machineDetails.getSalle());
        return ResponseEntity.ok(machineService.update(machine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMachine(@PathVariable Long id) {
        Machine machine = machineService.findById(id);
        if (machine == null) {
            return new ResponseEntity<>("Machine with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        machineService.delete(machine);
        return ResponseEntity.ok("Machine with id " + id + " deleted");
    }
}
