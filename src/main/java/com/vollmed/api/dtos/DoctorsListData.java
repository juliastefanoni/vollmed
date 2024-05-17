package com.vollmed.api.dtos;

import com.vollmed.api.enums.Expertise;
import com.vollmed.api.models.DoctorModel;

public record DoctorsListData(Long id, String name, String email, String crm, Expertise expertise) {

    public DoctorsListData(DoctorModel doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getExpertise());
    }

}
