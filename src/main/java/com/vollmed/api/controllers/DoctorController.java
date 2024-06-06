package com.vollmed.api.controllers;

import com.vollmed.api.dtos.DetailsDataDoctor;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegisterData doctorBody, UriComponentsBuilder uriBuilder) {
        DoctorModel doctor = new DoctorModel(doctorBody);
        repository.save(doctor);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsDataDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorsListData>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        var pageResponse = repository.findAllByActiveTrue(page).map(DoctorsListData::new);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetailsDataDoctor> getDoctorById(@PathVariable Long id) {
        DoctorModel doctor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsDataDoctor(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData doctorBody) {
        DoctorModel doctor = repository.getReferenceById(doctorBody.id());
        doctor.update(doctorBody);

        return ResponseEntity.ok(new DetailsDataDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        DoctorModel doctor = repository.getReferenceById(id);

        doctor.delete();

        return ResponseEntity.noContent().build();
    }

}
