package com.example.coursems.service.impl;

import com.example.coursems.entity.RegistrationRecord;
import com.example.coursems.repository.RegisRecordRepository;
import com.example.coursems.service.RegisRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisRecordServiceImpl implements RegisRecordService {

    private RegisRecordRepository recordRepository;

    /**
     * Service layer
     * Constructor injection
     *
     * @param recordRepository Dependency injection
     */
    @Autowired
    public RegisRecordServiceImpl(RegisRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    /**
     * Service layer
     * Method get list record
     *
     * @return List<RegistrationRecord>
     */
    @Override
    public List<RegistrationRecord> getList() {
        return recordRepository.findAll();
    }
}
