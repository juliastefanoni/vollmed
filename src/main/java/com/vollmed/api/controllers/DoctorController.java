package com.vollmed.api.controllers;

import com.vollmed.api.dtos.DoctorRegisterData;
import com.vollmed.api.models.DoctorModel;
import com.vollmed.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    public void register(@RequestBody DoctorRegisterData doctorBody) {
        repository.save(new DoctorModel(doctorBody));
    }
}
