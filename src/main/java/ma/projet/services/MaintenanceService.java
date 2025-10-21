package ma.projet.services;

import ma.projet.dao.MaintenanceRepository;
import ma.projet.entities.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance findById(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    public void delete(Maintenance maintenance) {
        maintenanceRepository.delete(maintenance);
    }

    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
}
