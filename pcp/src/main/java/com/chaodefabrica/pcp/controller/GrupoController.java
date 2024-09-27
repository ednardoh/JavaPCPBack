package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.IGrupo;
import com.chaodefabrica.pcp.model.Grupo;
import com.chaodefabrica.pcp.repository.GrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grupo")
public class GrupoController implements IGrupo {
    private GrupoRepository repository;
    GrupoController(GrupoRepository grupoRepository) {this.repository = grupoRepository;}

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public void create(@RequestBody Grupo grupo){
        repository.save(grupo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Grupo grupo) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescricao (grupo.getDescricao());
                    Grupo updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
