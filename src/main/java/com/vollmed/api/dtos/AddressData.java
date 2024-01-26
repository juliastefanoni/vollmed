package com.vollmed.api.dtos;

public record AddressData(
        String street,
        String neighborhood,
        String zipCode,
        String city,
        String state,
        String number,
        String complement
) {
}
