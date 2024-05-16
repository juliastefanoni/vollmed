package com.vollmed.api.models;

import com.vollmed.api.dtos.DoctorRegisterData;
import com.vollmed.api.enums.Expertise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    @Column(name = "cell_phone")
    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private Expertise expertise;

    @Embedded
    private AddressModel address;

    public DoctorModel(DoctorRegisterData doctorBody) {
        this.name = doctorBody.name();
        this.email = doctorBody.email();
        this.crm = doctorBody.crm();
        this.cellPhone = doctorBody.cellPhone();
        this.expertise = doctorBody.expertise();
        this.address = new AddressModel(doctorBody.address());
    }
}
