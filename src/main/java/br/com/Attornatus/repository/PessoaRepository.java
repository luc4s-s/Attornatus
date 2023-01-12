package br.com.Attornatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Attornatus.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	//PARA FAZER A BUSCAR NO BANCO POR PARTE DE NOME
	@Query(value = "select u from Pessoa u where upper(trim(u.nome)) like %?1%")
	List<Pessoa> buscarPorNome(String name);

}
