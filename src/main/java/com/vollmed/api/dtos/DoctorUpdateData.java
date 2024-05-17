package com.vollmed.api.dtos;

import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String cellPhone,
        AddressData address
) {

}
