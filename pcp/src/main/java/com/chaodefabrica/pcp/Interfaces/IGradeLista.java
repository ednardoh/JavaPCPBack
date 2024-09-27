package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.dto.GradeListaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGradeLista {

    public List<GradeListaDTO> FindAll();
    public List<GradeListaDTO> findById(@PathVariable long id);
    public void create(@RequestBody GradeListaDTO gradeListadto);
    public GradeListaDTO update(@RequestBody GradeListaDTO gradeListadto);
    public ResponseEntity<Void> delete(@PathVariable("id") Long id);

}
