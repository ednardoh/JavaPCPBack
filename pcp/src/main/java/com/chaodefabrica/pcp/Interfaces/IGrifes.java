package com.chaodefabrica.pcp.Interfaces;

import com.chaodefabrica.pcp.model.Grifes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGrifes {

    public List findAll();
    public ResponseEntity findById(@PathVariable long id);
    public void create(@RequestBody Grifes grifes);
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Grifes grifes);
    public ResponseEntity <?> delete(@PathVariable long id);
}
