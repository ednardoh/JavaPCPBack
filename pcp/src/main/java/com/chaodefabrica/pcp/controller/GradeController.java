package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.IGrade;
import com.chaodefabrica.pcp.dto.GradeDTO;
import com.chaodefabrica.pcp.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/grades")
@CrossOrigin(origins = "*")
public class GradeController implements IGrade {

    private GradeService service;
    GradeController(GradeService gradeService) { this.service = gradeService; }

    @GetMapping
    public List<GradeDTO> FindAll() {
        return service.FindAll();
    }

    @GetMapping(path = {"/{id}"})
    public GradeDTO findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody GradeDTO gradeDTO) {
        service.create(gradeDTO);
    }

    @PutMapping
    public GradeDTO update(@RequestBody GradeDTO gradeDTO) {
        return service.update(gradeDTO);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
