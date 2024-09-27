package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.Tamanho;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITamanho {

    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Tamanho tamanho);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Tamanho tamanho);
    public ResponseEntity <?> delete(@PathVariable long id);
}
