package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.Cores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICores {

    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Cores cores);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Cores cores);
    public ResponseEntity <?> delete(@PathVariable long id);

}
