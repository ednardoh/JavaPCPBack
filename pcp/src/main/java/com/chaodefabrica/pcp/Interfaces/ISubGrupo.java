package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.SubGrupo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISubGrupo {
    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody SubGrupo subgrupo);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody SubGrupo subgrupo);
    public ResponseEntity <?> delete(@PathVariable long id);
}
