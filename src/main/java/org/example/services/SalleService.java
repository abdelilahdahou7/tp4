package org.example.services;

import org.example.dao.SalleDao;
import org.example.entities.Salle;

import java.util.List;

// Service pour l'entité Salle
public class SalleService {
    private SalleDao salleDao = new SalleDao();

    public boolean create(Salle o) {
        return salleDao.create(o);
    }

    public boolean update(Salle o) {
        return salleDao.update(o);
    }

    public boolean delete(Salle o) {
        return salleDao.delete(o);
    }

    public Salle findById(int id) {
        return salleDao.findById(id);
    }

    public List<Salle> findAll() {
        return salleDao.findAll();
    }
}
