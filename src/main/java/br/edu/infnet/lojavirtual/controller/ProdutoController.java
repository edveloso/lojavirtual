package br.edu.infnet.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.lojavirtual.model.Produto;
import br.edu.infnet.lojavirtual.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;


	@ApiOperation(value = "Retorna uma lista de Produtos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})
	@RequestMapping(value = "/produtos", 
			method = RequestMethod.GET,
			produces = "application/json"
			)
	public List<Produto> listaTodos(){
		return produtoService.listaTodos();
	}
	
	@RequestMapping(
			value = "/produtos",
			method = RequestMethod.POST,
			produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"}
			)
	public Produto criar(@RequestBody Produto produto) {
		
		return produtoService.salvar(produto);
	}
	
	
	@RequestMapping(
			value = "/produtos/{id}",
			method = RequestMethod.PUT,
			produces = "application/json",
			consumes = "application/json"
			)
	public Produto editar(@PathVariable(value="id")  Integer id,
		 @RequestBody Produto produto) {
		
		return produtoService.alterar(id, produto);
	}
	
	
	@ApiOperation(value = "Remove um produto")
	@RequestMapping(
			value = "/produtos/{id}",
			method = RequestMethod.DELETE,
			consumes = "application/json"
			)
	public void deletar(@PathVariable(value="id")  Integer id) {
		 produtoService.deletar(id);
	}
	
	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	
	
	
}
