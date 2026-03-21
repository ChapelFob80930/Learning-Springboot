package com.sarbo.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDTO createSchool(SchoolDTO dto)
    {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDTO> findAllSchool(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }

}
