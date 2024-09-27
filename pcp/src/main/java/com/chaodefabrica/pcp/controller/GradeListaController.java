package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.dto.GradeListaDTO;
import com.chaodefabrica.pcp.service.GradeListaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gradelista")
@CrossOrigin(origins = "*")
public class GradeListaController {

    private GradeListaService service;
    GradeListaController(GradeListaService gradeListaService) { this.service = gradeListaService; }

    @GetMapping
    public List<GradeListaDTO> FindAll() {
        return service.FindAll();
    }

    @GetMapping(path = {"/{id}"})
    public List<GradeListaDTO> findById(@PathVariable long id){
        return service.FindByCodigo(id);
    }

    @PostMapping
    public void create(@RequestBody GradeListaDTO gradeListadto) {
        service.create(gradeListadto);
    }

    @PutMapping
    public GradeListaDTO update(@RequestBody GradeListaDTO gradeListadto) {
        return service.update(gradeListadto);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
