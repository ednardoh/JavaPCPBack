package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.TipoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITipoProduto {

    public List findAll();
    public ResponseEntity findById(@PathVariable String id);
    public void create(@RequestBody TipoProduto tipoproduto);
    public ResponseEntity update(@PathVariable("id") String id,
                                 @RequestBody TipoProduto tipoproduto);
    public ResponseEntity <?> delete(@PathVariable String id);
}
