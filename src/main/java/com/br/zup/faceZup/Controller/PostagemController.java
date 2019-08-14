package com.br.zup.faceZup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.faceZup.Models.PostagemModel.Postagem;
import com.br.zup.faceZup.Service.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;
	
	@GetMapping
	public ResponseEntity mostrarPostagens(){
		if(postagemService.quantidadeDePostagem() > 0) {
			return ResponseEntity.ok(postagemService.quantidadeDePostagem());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> pegarMensagem(@PathVariable int id) {
		Postagem postagem = postagemService.pegarPostagemPeloID(id);
		if(postagem == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postagem);
	}
	
	@PostMapping
	public ResponseEntity<Postagem> criarPostagem(@RequestBody Postagem postagem) {
		postagemService.salvarPostagem(postagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Postagem> atualizarPostagem(@PathVariable int id, @RequestBody Postagem postagem) {
		postagemService.atualizarPostagem(id, postagem);
		return ResponseEntity.ok(postagem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagarPostagem(@PathVariable int id) {
		postagemService.apagarPostagem(id);
		return ResponseEntity.ok().build();
	}
}
