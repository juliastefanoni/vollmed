package com.vollmed.api.dtos;

import com.vollmed.api.enums.Expertise;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DoctorRegisterData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cellPhone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Expertise expertise,
        @NotNull
        @Valid
        AddressData address
) {

}
