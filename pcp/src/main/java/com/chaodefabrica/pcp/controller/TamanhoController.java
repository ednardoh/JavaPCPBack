package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.ITamanho;
import com.chaodefabrica.pcp.model.Tamanho;
import com.chaodefabrica.pcp.repository.TamanhoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tamanhos")
public class TamanhoController implements ITamanho {
    private TamanhoRepository repository;
    TamanhoController(TamanhoRepository tamanhoRepository) {this.repository = tamanhoRepository;}

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
    public void create(@RequestBody Tamanho tamanho){
        repository.save(tamanho);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Tamanho tamanho) {
        return repository.findById(id)
                .map(record -> {
                    record.setTamanho(tamanho.getTamanho());
                    record.setDescricao(tamanho.getDescricao());
                    Tamanho updated = repository.save(record);
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
