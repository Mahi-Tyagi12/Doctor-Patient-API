package com.xcelore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    private static final Map<String, String> SYMPTOM_SPECIALITY = Map.ofEntries(
        Map.entry("Arthritis", "Orthopaedic"),
        Map.entry("Back Pain", "Orthopaedic"),
        Map.entry("Tissue injuries", "Orthopaedic"),
        Map.entry("Dysmenorrhea", "Gynecology"),
        Map.entry("Skin infection", "Dermatology"),
        Map.entry("skin burn", "Dermatology"),
        Map.entry("Ear pain", "ENT")
    );

    private static final List<String> SUPPORTED_CITIES = List.of("Delhi", "Noida", "Faridabad");

    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/suggest-doctor/{id}")
    public Object suggestDoctor(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientService.getPatientById(id);
        if (optionalPatient.isEmpty()) return "Patient not found";

        Patient patient = optionalPatient.get();
        String city = patient.getCity();
        String symptom = patient.getSymptom();

        if (!SUPPORTED_CITIES.contains(city)) {
            return "We are still waiting to expand to your location";
        }

        String speciality = SYMPTOM_SPECIALITY.get(symptom);
        if (speciality == null) {
            return "There isn’t any doctor present at your location for your symptom";
        }

        List<Doctor> doctors = doctorService.findByCityAndSpeciality(city, speciality);
        if (doctors.isEmpty()) {
            return "There isn’t any doctor present at your location for your symptom";
        }

        return doctors;
    }
}
