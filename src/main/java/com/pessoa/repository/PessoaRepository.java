package com.pessoa.repository;

import com.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);  //permite que encontre todo objeto de Pessoa pois a interface permite que eu crie métodos e implemente depois eles
    Optional<Pessoa> findByNomeIgnoreCase(String nome);      //porém os métodos já estão implementados pelo findBy o ignorecase traz os nomes maiúcula ou minuscula
    Optional<Pessoa> findByEmail(String email);
    Optional<Pessoa> findByCpf(String cpf);
//o findBy resgata um o objeto principal Pessoa e a chave dele que é do tipo long, pois está associado ao obj
// e pode acessar qualquer campo do obj
}
