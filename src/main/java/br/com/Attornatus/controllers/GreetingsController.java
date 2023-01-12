package br.com.Attornatus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.Attornatus.model.Pessoa;
import br.com.Attornatus.repository.PessoaRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private PessoaRepository pessoaRepository;

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Hello " + name + "!";
	}*/


	// METODO PARA LISTAR
	@GetMapping(value = "listarpessoa")
	@ResponseBody
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> pessoa = pessoaRepository.findAll();
		return new ResponseEntity<List<Pessoa>>(pessoa, HttpStatus.OK);
	}

	// METODO PARA SALVAR
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa usuario) {
		Pessoa user = pessoaRepository.saveAndFlush(usuario);

		return new ResponseEntity<Pessoa>(user, HttpStatus.CREATED);
	}

	// METODO PARA ATUALIZAR
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa usuario) { // Recebe os dados para salvar

		Pessoa user = pessoaRepository.saveAndFlush(usuario);

		return new ResponseEntity<Pessoa>(user, HttpStatus.OK);
	}

	// METODO PARA DELETAR
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long iduser) {
		pessoaRepository.deleteById(iduser);

		return new ResponseEntity<String>("Usuario Deletado com Sucesso!", HttpStatus.OK); 
	}
	
	
	//METODO PARA FAZER BUCA POR NOME
	@GetMapping(value = "buscarPorNome") //mapeia a URL http://localhost:8080/buscarPorNome
	@ResponseBody
	public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestParam(name= "name") String name) { //Recebe os dados/parametro para CONSULTAR 
		
		List<Pessoa> usuario =  pessoaRepository.buscarPorNome(name.trim().toUpperCase());//pesquisa no banco
		
		return new ResponseEntity<List<Pessoa>>(usuario, HttpStatus.OK); //reposta para quando BUSCARPORID 
	} 

}

































