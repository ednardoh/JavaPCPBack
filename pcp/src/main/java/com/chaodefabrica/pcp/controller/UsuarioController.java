package com.chaodefabrica.pcp.controller;

import com.chaodefabrica.pcp.Interfaces.IUsuario;
import com.chaodefabrica.pcp.model.Usuario;
import com.chaodefabrica.pcp.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController implements IUsuario {
    private UsuarioRepository repository;
    UsuarioController(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

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
    public void create(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Usuario usuario) {
        return repository.findById(id)
                .map(record -> {
                    record.setUsername(usuario.getUsername());
                    record.setSenha(usuario.getSenha());
                    record.setBloquear(usuario.getBloquear());
                    record.setOnline(usuario.getOnline());
                    record.setPermissao_pedidovendaaprovar(usuario.getPermissao_pedidovendaaprovar());
                    record.setPermissao_producaoaprovar(usuario.getPermissao_producaoaprovar());
                    record.setPermissao_producaofasemovimentar(usuario.getPermissao_producaofasemovimentar());
                    record.setPermissao_producaoatualizarestoque(usuario.getPermissao_producaoatualizarestoque());
                    record.setPermissao_estoqueinventario(usuario.getPermissao_estoqueinventario());
                    record.setPermissao_notafiscalcancelar(usuario.getPermissao_notafiscalcancelar());
                    record.setPermissao_pedidovendaverprecos(usuario.getPermissao_pedidovendaverprecos());
                    record.setPermissao_pedidovendaalterarpagamento(usuario.getPermissao_pedidovendaalterarpagamento());
                    record.setPermissao_produtoverprecos(usuario.getPermissao_produtoverprecos());
                    record.setPermissao_pedidovendadesconto(usuario.getPermissao_pedidovendadesconto());
                    Usuario updated = repository.save(record);
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
