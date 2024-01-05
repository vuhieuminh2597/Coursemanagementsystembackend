package com.example.coursems.mapper;

import com.example.coursems.entity.RegistrationRecord;
import com.example.coursems.model.RegisRecordDTO;
import org.springframework.stereotype.Component;

@Component
public class RegisRecordMapper {

    public RegisRecordDTO RegisRecordToDTO (RegistrationRecord record){
        RegisRecordDTO regisRecordDTO = new RegisRecordDTO();
        regisRecordDTO.setId(record.getId());
        if(record.getCustomer() != null){
            regisRecordDTO.setCustomer(record.getCustomer().getName());
        }
        if(record.getCourse() != null){
            regisRecordDTO.setCourse(record.getCourse().getName());
        }
        if(record.getStartDate() != null){
            regisRecordDTO.setStartDate(record.getStartDate().toString());
        }
        if(record.getEndDate() != null){
            regisRecordDTO.setEndDate(record.getEndDate().toString());
        }
        return regisRecordDTO;
    }
}
