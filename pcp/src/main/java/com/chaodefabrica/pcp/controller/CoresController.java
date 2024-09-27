package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.ICores;
import com.chaodefabrica.pcp.model.Cores;
import com.chaodefabrica.pcp.repository.CoresRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cores")
public class CoresController implements ICores {

    private CoresRepository repository;
    CoresController(CoresRepository coresRepository) {this.repository = coresRepository;}

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
    public void create(@RequestBody Cores cores){
        repository.save(cores);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Cores cores) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cores.getNome());
                    record.setDescricaoCor(cores.getDescricaoCor());
                    Cores updated = repository.save(record);
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
