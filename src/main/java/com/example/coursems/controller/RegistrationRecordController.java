package com.example.coursems.controller;

import com.example.coursems.entity.RegistrationRecord;
import com.example.coursems.service.RegisRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registrationRecord")
public class RegistrationRecordController {
    private RegisRecordService recordService;

    /**
     * Controller layer
     * Constructor injection
     *
     * @param recordService Dependency injection
     */
    @Autowired
    public RegistrationRecordController(RegisRecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * Controller layer
     * Method get list record
     *
     * @return List<RegistrationRecord>
     */
    @GetMapping
    public List<RegistrationRecord> getListRecord() {
        return recordService.getList();
    }
}
