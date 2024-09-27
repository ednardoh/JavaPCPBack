package com.chaodefabrica.pcp.service;

import com.chaodefabrica.pcp.dto.GradeListaDTO;
import com.chaodefabrica.pcp.model.GradeLista;
import com.chaodefabrica.pcp.repository.GradeListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeListaService {

    @Autowired
    private GradeListaRepository gradeListaRepository;

    public List<GradeListaDTO> FindAll() {
        List<GradeLista> gradeListas = gradeListaRepository.findAll();
        return gradeListas.stream().map(GradeListaDTO::new).toList();
    }

    public List<GradeListaDTO> FindByCodigo(Long id) {
        List<GradeLista> gradelistas = gradeListaRepository.FindByCodigo(id);
        return gradelistas.stream().map(GradeListaDTO::new).toList();
    }

    public void create(GradeListaDTO gradeListadto) {
        GradeLista gradeLista = new GradeLista(gradeListadto);
        gradeListaRepository.save(gradeLista);
    }

    public GradeListaDTO update(GradeListaDTO gradeListadto) {
        GradeLista gradeLista = new GradeLista(gradeListadto);
        return new GradeListaDTO(gradeListaRepository.save(gradeLista));
    }

    public void delete(Long id) {
        GradeLista recurso = gradeListaRepository.findById(id).get();
        gradeListaRepository.delete(recurso);
    }

}
