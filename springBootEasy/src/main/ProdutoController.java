package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository dao;
	
	/* Resposta em JSON -> REST */
	@GetMapping(value="/produto", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Produto> listar(){
		try {
			return (List<Produto>) dao.findAll();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	@PostMapping(
			value="/produto", 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
 	public ResponseEntity<?> salvar(@RequestBody Produto produto) {
		try {
			if (produto.getIdProduto() != null){
				throw new Exception("Não insira o id");
			}
			
			Produto resposta = dao.save(produto);
			return new ResponseEntity<Produto>(resposta, HttpStatus.CREATED);
		} catch (Exception e) {			
			return new ResponseEntity<String> ("error: "+e.getMessage(), HttpStatus.BAD_REQUEST);			
			
			/* Ou
			
			Map <String,String> error = new HashMap<String,String>();
			error.put("error:", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			*/
		}
	}
	 /*
	  * Ou sem retornar mensagem de erro:
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		try {
			Produto resposta = dao.save(produto);
			return new ResponseEntity<Produto>(resposta, HttpStatus.CREATED);
		} catch (Exception e) {
			return null;
		}
	} 
	 */
	
}
