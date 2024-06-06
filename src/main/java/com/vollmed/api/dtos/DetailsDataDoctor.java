package com.vollmed.api.dtos;

import com.vollmed.api.enums.Expertise;
import com.vollmed.api.models.AddressModel;
import com.vollmed.api.models.DoctorModel;

public record DetailsDataDoctor(
     Long id,
     String name,
     String crm,
     String cellPhone,
     Expertise expertise,
     AddressModel address
) {
    public DetailsDataDoctor(DoctorModel doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getCellPhone(), doctor.getExpertise(), doctor.getAddress());
    }
}
