package com.vollmed.api.models;

import com.vollmed.api.dtos.DoctorRegisterData;
import com.vollmed.api.dtos.DoctorUpdateData;
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
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Expertise expertise;

    @Embedded
    private AddressModel address;

    public DoctorModel(DoctorRegisterData doctorBody) {
        this.name = doctorBody.name();
        this.email = doctorBody.email();
        this.crm = doctorBody.crm();
        this.cellPhone = doctorBody.cellPhone();
        this.active = true;
        this.expertise = doctorBody.expertise();
        this.address = new AddressModel(doctorBody.address());
    }

    public void update(DoctorUpdateData doctorBody) {
        if(doctorBody.name() != null) {
            this.name = doctorBody.name();
        }

        if(doctorBody.cellPhone() != null) {
            this.cellPhone = doctorBody.cellPhone();
        }

        if (doctorBody.address() !=null ) {
            this.address.update(doctorBody.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
