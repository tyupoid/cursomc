package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "informatica");
		Categoria categoria2 = new Categoria(null, "escritorio");
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

		Produto produto1 = new Produto(null, "computador", 2000.0);
		Produto produto2 = new Produto(null, "impressora", 800.0);
		Produto produto3 = new Produto(null, "mouse", 80.0);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().add(categoria1);

		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		
		
		//        -------------------------------------
		
		Estado estado1 = new Estado(null,"Minas Gerais");
		Estado estado2 = new Estado(null,"Sao Paulo");
		
		Cidade cidade1 = new Cidade(null,"Uberlancia",estado1);
		Cidade cidade2 = new Cidade(null,"Sao Paulo",estado2);
		Cidade cidade3 = new Cidade(null,"Uberlandia",estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		//       --------------------------------------
		
		//Endereco endereco1 = new Endereco(null,"rua flores","300","apto 203","jardim","38220834",cidade1);
		//Endereco endereco2 = new Endereco(null,"rua Avenida Matos","105","sala 800","centro","38777012",cidade2);
		
		//endereco1.adicionarCidade(cidade1);
		//endereco2.adicionarCidade(cidade2);
		
		//enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
	}

}
