package ma.projet.services;

import ma.projet.dao.TechnicienRepository;
import ma.projet.entities.Technicien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {

    @Autowired
    private TechnicienRepository technicienRepository;

    public Technicien save(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    public Technicien findById(Long id) {
        return technicienRepository.findById(id).orElse(null);
    }

    public List<Technicien> findAll() {
        return technicienRepository.findAll();
    }

    public void delete(Technicien technicien) {
        technicienRepository.delete(technicien);
    }

    public Technicien update(Technicien technicien) {
        return technicienRepository.save(technicien);
    }
}
