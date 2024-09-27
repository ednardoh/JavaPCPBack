package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.ITipoProduto;
import com.chaodefabrica.pcp.model.TipoProduto;
import com.chaodefabrica.pcp.repository.TipoProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoproduto")
public class TipoProdutoController implements ITipoProduto {
    private TipoProdutoRepository repository;
    TipoProdutoController(TipoProdutoRepository tipoprodutoRepository) {this.repository = tipoprodutoRepository;}

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable String id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void create(@RequestBody TipoProduto tipoproduto){
        repository.save(tipoproduto);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") String id,
                                 @RequestBody TipoProduto tipoproduto) {
        return repository.findById(id)
                .map(record -> {
                    record.setCodigo(tipoproduto.getCodigo());
                    record.setNome (tipoproduto.getNome());
                    TipoProduto updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable String id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
