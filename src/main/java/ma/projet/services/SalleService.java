package ma.projet.services;

import ma.projet.dao.SalleRepository;
import ma.projet.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle findById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public void delete(Salle salle) {
        salleRepository.delete(salle);
    }

    public Salle update(Salle salle) {
        return salleRepository.save(salle);
    }
}
