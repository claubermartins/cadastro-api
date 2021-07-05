/*package com.pessoa.controller;

import com.pessoa.model.Pessoa;
import com.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService = new PessoaService();
    //requisição http administrada pela ResponseEntity
    ResponseEntity<List<Pessoa> obterTodos(){
        pessoaService.obterTodos();
    }
}
*/