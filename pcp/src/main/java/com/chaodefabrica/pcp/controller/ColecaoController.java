package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.IColecao;
import com.chaodefabrica.pcp.model.Colecao;
import com.chaodefabrica.pcp.repository.ColecaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colecao")
public class ColecaoController implements IColecao {
    private ColecaoRepository repository;
    ColecaoController(ColecaoRepository colecaoRepository) {this.repository = colecaoRepository;}

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
    public void create(@RequestBody Colecao colecao){
         repository.save(colecao);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Colecao colecao) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(colecao.getNome());
                    record.setPeriodoIni(colecao.getPeriodoIni());
                    record.setPeriodoFim(colecao.getPeriodoFim());
                    record.setPecasMeta(colecao.getPecasMeta());
                    record.setQtdeModelos(colecao.getQtdeModelos());
                    record.setValorMeta(colecao.getValorMeta());
                    record.setStatus(colecao.getStatus());
                    Colecao updated = repository.save(record);
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
