package com.vollmed.api.controllers;

import com.vollmed.api.dtos.DoctorRegisterData;
import com.vollmed.api.dtos.DoctorUpdateData;
import com.vollmed.api.dtos.DoctorsListData;
import com.vollmed.api.models.DoctorModel;
import com.vollmed.api.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegisterData doctorBody) {
        repository.save(new DoctorModel(doctorBody));
    }

    @GetMapping
    public Page<DoctorsListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return repository.findAllByActiveTrue(page).map(DoctorsListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData doctorBody) {
        DoctorModel doctor = repository.getReferenceById(doctorBody.id());
        doctor.update(doctorBody);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        DoctorModel doctor = repository.getReferenceById(id);

        doctor.delete();
    }

}
