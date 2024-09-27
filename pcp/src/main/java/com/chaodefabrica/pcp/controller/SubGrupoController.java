package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.ISubGrupo;
import com.chaodefabrica.pcp.model.SubGrupo;
import com.chaodefabrica.pcp.repository.SubGrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subgrupo")
public class SubGrupoController implements ISubGrupo {
    private SubGrupoRepository repository;
    SubGrupoController(SubGrupoRepository subgrupoRepository) {this.repository = subgrupoRepository;}

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
    public void create(@RequestBody SubGrupo subgrupo){
        repository.save(subgrupo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody SubGrupo subgrupo) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescricao (subgrupo.getDescricao());
                    SubGrupo updated = repository.save(record);
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
