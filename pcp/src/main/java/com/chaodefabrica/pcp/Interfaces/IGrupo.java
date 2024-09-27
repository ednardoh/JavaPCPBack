package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.Grupo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGrupo {
    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Grupo grupo);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Grupo grupo);
    public ResponseEntity <?> delete(@PathVariable long id);
}
