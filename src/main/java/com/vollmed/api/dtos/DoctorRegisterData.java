package com.vollmed.api.dtos;

import com.vollmed.api.enums.Expertise;

public record DoctorRegisterData(
        String name,
        String email,
        String crm,
        Expertise expertise,
        AddressData address
) {

}
