package com.xcelore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }

    public List<Doctor> findByCityAndSpeciality(String city, String speciality) {
        return repository.findByCityAndSpeciality(city, speciality);
    }
}
