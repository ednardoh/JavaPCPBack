package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUsuario {

    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Usuario usuario);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Usuario usuario);
    public ResponseEntity <?> delete(@PathVariable long id);
}
