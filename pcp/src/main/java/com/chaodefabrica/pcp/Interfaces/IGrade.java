package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.dto.GradeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGrade {
    public List<GradeDTO> FindAll();
    public GradeDTO findById(@PathVariable long id);
    public void create(@RequestBody GradeDTO gradeDTO);
    public GradeDTO update(@RequestBody GradeDTO gradeDTO);
    public ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
