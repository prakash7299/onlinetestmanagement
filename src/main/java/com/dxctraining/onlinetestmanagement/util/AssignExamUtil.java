package com.dxctraining.onlinetestmanagement.util;

import org.springframework.stereotype.Component;

import com.dxctraining.onlinetestmanagement.dto.AssignExamDto;
import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;

@Component
public class AssignExamUtil {


    public AssignExamDto AssignExamDto(AssignExamToUser assign){
        AssignExamDto dto=new AssignExamDto(assign.getId(),assign.getStatus(),assign.getDateOfExam(),assign.getUserId(),assign.getExamId());
        return dto;
    }

}
