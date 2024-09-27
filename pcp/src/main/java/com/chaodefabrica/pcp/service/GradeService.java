package com.chaodefabrica.pcp.service;

import com.chaodefabrica.pcp.dto.GradeDTO;
import com.chaodefabrica.pcp.model.Grade;
import com.chaodefabrica.pcp.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<GradeDTO> FindAll() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream().map(GradeDTO::new).toList();
    }

    public GradeDTO findById(Long id) {
        return new GradeDTO(gradeRepository.findById(id).get());
    }

    public void create(GradeDTO gradedto) {
        Grade grades = new Grade(gradedto);
        gradeRepository.save(grades);
    }

    public GradeDTO update(GradeDTO gradedto) {
        Grade grades = new Grade(gradedto);
        return new GradeDTO(gradeRepository.save(grades));
    }

    public void delete(Long id) {
        Grade recurso = gradeRepository.findById(id).get();
        gradeRepository.delete(recurso);
    }
}
