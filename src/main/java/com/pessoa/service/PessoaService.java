package com.pessoa.service;

import com.pessoa.model.Pessoa;
import com.pessoa.repository.PessoaRepository;
import com.pessoa.exceptions.DuplicatedResourceException;
import com.pessoa.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// a partir daqui vamos usar o repositório
//primeiro criar pois é a parti daqui que vamos ter acesso aos métodos
public class PessoaService {
    //aqui primeiro injetamos o repositório pelo autowired
    @Autowired
    private PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    //métodos abaixo estão sendo implementados pela jpa
    public Page<Pessoa> obterTodos(Pageable pageable){     //otimiza a busca para não vir todos de uma vez
        return pessoaRepository.findAll(pageable);
    }
    public List<Pessoa> obterTodos(){
        return pessoaRepository.findAll();//retorna a lista da nossa entidade e o findall já está implementada pelo jpa(herança)
    }
    public Optional<Pessoa> buscarPorId(Long id){
        return pessoaRepository.findById(id);
    }
    public Optional<Pessoa> buscaPorCpf(String cpf){
        return pessoaRepository.findByCpf(cpf);
    }
    public Optional<Pessoa> buscaPorNome(String nome){
        return pessoaRepository.findByNomeIgnoreCase(nome);
    }
    public List<Pessoa> buscaPorNomeFiltro(String nome){
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }
    //acima é para o get para requisição HTTP
    //abaixo é o crud
    public Pessoa salvar(Pessoa pessoa){ //aqui é feito o post
        //Boolean podeSalvar = pessoa.getId() == null && pessoaRepository.findByCpf(pessoa.getCpf()).isPresent();
        Boolean podeSalvar = pessoa.getId() == null;
        if(podeSalvar)
            return pessoaRepository.save(pessoa);
        else
            throw new DuplicatedResourceException();
    }
    public Pessoa update(Pessoa pessoa){ //aqui é feito o put
        Boolean podeAtualizar = pessoa.getId() != null && pessoaRepository.findByCpf(pessoa.getCpf()).isPresent();
        if (podeAtualizar)
            return pessoaRepository.save(pessoa);
        else
            throw new ResourceNotFoundException();
    }
    public void delete(Pessoa pessoa){
        Boolean podeDeletar = pessoa.getId() != null && pessoaRepository.findByCpf(pessoa.getCpf()).isPresent();
        if (podeDeletar)
            pessoaRepository.delete(pessoa);
        else
            throw new ResourceNotFoundException();
    }
}