package com.vollmed.api.models;

import com.vollmed.api.dtos.AddressData;
import com.vollmed.api.dtos.DoctorRegisterData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    private String street;
    private String neighborhood;
    @Column(name = "zip_code")
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public AddressModel(AddressData addressData) {
        this.street = addressData.street();
        this.neighborhood = addressData.neighborhood();
        this.zipCode = addressData.zipCode();
        this.number = addressData.number();
        this.complement = addressData.complement();
        this.city = addressData.city();
        this.state = addressData.state();
    }

    public void update(AddressData address) {
        if(address.street() != null) {
            this.street = address.street();
        }
        if(address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if(address.zipCode() != null) {
            this.zipCode = address.zipCode();
        }
        if(address.number() != null) {
            this.number = address.number();
        }
        if(address.complement() != null) {
            this.complement = address.complement();
        }
        if(address.city() != null) {
            this.city = address.city();
        }
        if(address.street() != null) {
            this.state = address.state();
        }
    }
}
