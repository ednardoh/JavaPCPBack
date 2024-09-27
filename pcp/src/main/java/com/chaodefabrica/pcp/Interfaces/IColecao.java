package com.chaodefabrica.pcp.Interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.chaodefabrica.pcp.model.Colecao;

import java.util.List;

public interface IColecao {
    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Colecao colecao);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Colecao colecao);
    public ResponseEntity <?> delete(@PathVariable long id);
}
