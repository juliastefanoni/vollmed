package com.vollmed.api.repositories;

import com.vollmed.api.models.DoctorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    Page<DoctorModel> findAllByActiveTrue(Pageable page);
}
