package com.vollmed.api.repositories;

import com.vollmed.api.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
}
