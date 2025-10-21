package ma.projet.services;

import ma.projet.dao.MachineRepository;
import ma.projet.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine save(Machine machine) {
        return machineRepository.save(machine);
    }

    public Machine findById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    public void delete(Machine machine) {
        machineRepository.delete(machine);
    }

    public Machine update(Machine machine) {
        return machineRepository.save(machine);
    }
}
