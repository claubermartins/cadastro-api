package com.pessoa.controller;

import com.pessoa.model.Pessoa;
import com.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

<<<<<<< HEAD
=======
import java.net.URI;
>>>>>>> cc01e4bff4e0e75ecc61450ed3094809a95d59fb
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastramento")
public class PessoaController {

    private PessoaService pessoaService;

    //injetando para o spring enxergar
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        //esse atrib da classe controle vai receber pessoaService que vem pelo construtor
        this.pessoaService = pessoaService;
    }

    //Abaixo temos os endpoint
    @GetMapping
    //requisição http administrada pela ResponseEntity
    ResponseEntity<List<Pessoa>> obterTodos() {
<<<<<<< HEAD
        var pessoas = pessoaService.obterTodos();
=======
        List<Pessoa> pessoas = pessoaService.obterTodos();
>>>>>>> cc01e4bff4e0e75ecc61450ed3094809a95d59fb
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    ResponseEntity<Optional<Pessoa>> obterPorId(@PathVariable Long id) {
<<<<<<< HEAD
        var pessoas = pessoaService.buscarPorId(id);
=======
        Optional<Pessoa> pessoas = pessoaService.buscarPorId(id);
>>>>>>> cc01e4bff4e0e75ecc61450ed3094809a95d59fb
        return ResponseEntity.ok(pessoas);
    }
    @PostMapping
    ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
<<<<<<< HEAD
        var pessoaSalva = pessoaService.salvar(pessoa);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
=======
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
>>>>>>> cc01e4bff4e0e75ecc61450ed3094809a95d59fb
        return ResponseEntity.created(uri).body(pessoa);
    }
    @PutMapping
    ResponseEntity<Pessoa>update(@RequestBody Pessoa pessoa){
<<<<<<< HEAD
        var pessoaUpdated = pessoaService.update(pessoa);
=======
        Pessoa pessoaUpdated = pessoaService.update(pessoa);
>>>>>>> cc01e4bff4e0e75ecc61450ed3094809a95d59fb
        return ResponseEntity.ok(pessoaUpdated);
    }
    @DeleteMapping
    ResponseEntity<Pessoa> delete(@RequestBody Pessoa pessoa){
        pessoaService.delete(pessoa);
        return ResponseEntity.ok().build();
    }
}
