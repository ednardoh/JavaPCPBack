package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.IGrifes;
import com.chaodefabrica.pcp.model.Grifes;
import com.chaodefabrica.pcp.repository.GrifesRepository;
import com.chaodefabrica.pcp.repository.GrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grifes")
public class GrifesController implements IGrifes {
    private GrifesRepository repository;
    GrifesController(GrifesRepository grifesRepository) {this.repository = grifesRepository;}

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
    public void create(@RequestBody Grifes grifes){
        repository.save(grifes);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Grifes grifes) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(grifes.getNome());
                    Grifes updated = repository.save(record);
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
