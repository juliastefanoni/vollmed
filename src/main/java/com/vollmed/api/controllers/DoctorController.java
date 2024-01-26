package com.vollmed.api.controllers;

import com.vollmed.api.dtos.DoctorRegisterData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @PostMapping
    public void register(@RequestBody DoctorRegisterData doctorBody) {
        System.out.println(doctorBody);
    }
}
