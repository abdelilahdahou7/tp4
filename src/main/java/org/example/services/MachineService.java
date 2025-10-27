package org.example.services;

import org.example.dao.MachineDao;
import org.example.entities.Machine;

import java.util.Date;
import java.util.List;

// Service pour l'entité Machine
public class MachineService {
    private MachineDao machineDao = new MachineDao();

    public boolean create(Machine o) {
        return machineDao.create(o);
    }

    public boolean update(Machine o) {
        return machineDao.update(o);
    }

    public boolean delete(Machine o) {
        return machineDao.delete(o);
    }

    public Machine findById(int id) {
        return machineDao.findById(id);
    }

    public List<Machine> findAll() {
        return machineDao.findAll();
    }

    public List<Machine> findBetweenDates(Date d1, Date d2) {
        return machineDao.findBetweenDates(d1, d2);
    }
}
