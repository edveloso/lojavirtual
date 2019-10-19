package br.edu.infnet.lojavirtual.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import br.edu.infnet.lojavirtual.model.Produto;

@Service
public class ProdutoService {

	
	private Map<Integer, Produto> produtos;
	private int count;
	
	public ProdutoService() {
		produtos = new TreeMap<Integer, Produto>();
		count = 1;
		produtos.put(count++, new Produto(1, "Galaxy s6", 2200.0));
		produtos.put(count++, new Produto(2, null, 200.0));
		produtos.put(count++, new Produto(3, "TV smart", 1000.0));
	}

	public List<Produto> listaTodos() {
		return new ArrayList<Produto>(produtos.values());
	}

	public Produto salvar(Produto produto) {
		produto.setId(count);
		produtos.put(count++, produto);
		return produto;
	}

	public Produto alterar(Integer id, Produto produto) {
		produtos.put(id, produto);
		return produto;
	}

	public void deletar(Integer id) {
		produtos.remove(id);
	}

	public Produto obterPeloId(Integer id) {
		return produtos.get(id);
	}
	
	
	
}
