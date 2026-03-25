package controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Produtos;
import model.ProdutosDAO;
import view.CadastroProdutos;
import view.ProdutosCRUD;

public class ControllerProdutos {
	
	private CadastroProdutos cadastroProdutos;
	private ProdutosDAO produtosDAO;
	//private Produtos produtos;
	private ProdutosCRUD produtosCRUD;
	private NavegadorTelas navegadorTelas;
	
	public ControllerProdutos(CadastroProdutos cadastroProdutos, ProdutosDAO produtosDAO,
			NavegadorTelas navegadorTelas, ProdutosCRUD produtosCRUD ) {
		super();
		this.cadastroProdutos = cadastroProdutos;
		this.produtosDAO = produtosDAO;
		//this.produtos = produtos;
		this.navegadorTelas = navegadorTelas;
		this.produtosCRUD = produtosCRUD;
		
		this.cadastroProdutos.cadastrarProdutos(e ->{
			
			Produtos produtos = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
			
			produtos.setCodigoBarras(Integer.parseInt(cadastroProdutos.getTfCodBarras()));
			produtos.setNome(cadastroProdutos.getTfNomeProduto());
			produtos.setValor(Float.parseFloat(cadastroProdutos.getTfValor()));
			produtos.setMarca(cadastroProdutos.getTfMarca());
			produtos.setFornecedora(cadastroProdutos.getTfFornecedora());
			produtos.setQuantidade(Integer.parseInt(cadastroProdutos.getTfQuantEstoque()));
			produtos.setDescricao(cadastroProdutos.getTaDescricao());
			produtos.setCor(cadastroProdutos.getTfCor());
			produtos.setDataValidade(cadastroProdutos.getTfDataVal());
			produtos.setDataFabricacao(cadastroProdutos.getTfDataFabr());
			
			produtosDAO.adicionarProdutos(produtos);
			navegadorTelas.mudarTela("PRODUTOSCRUD");
			
			System.out.println("CLIQUE");
			
			atualizarListaProdutos();
			
		});
		
		
	}
	
	public void atualizarListaProdutos() {
		
		List<Produtos> produto = produtosDAO.listarProdutos();
		DefaultListModel<String> modeloProduto = new DefaultListModel<>();
		
		for (Produtos produtos : produto) {
			modeloProduto.addElement("<html>Nome do Produto: " + produtos.getNome() 
			+ "<br>Valor: R$" + produtos.getValor() 
			+ "<br>Código de Barras: " + produtos.getCodigoBarras() 
			+ "<br>Quantidade: " + produtos.getQuantidade() 
			+ "<br>Marca: " + produtos.getMarca() 
			+ "<br>Fonecedora: " + produtos.getFornecedora() 
			+ "<br>Cor: " + produtos.getCor() 
			+ "<br>Data de Fabricação: " + produtos.getDataFabricacao() 
			+ "<br>Data de Validade: " + produtos.getDataValidade() 
			+ "<br>Descrição: " + produtos.getDescricao() +"<br><br>"+ "</html>");
		}
		
		
		
	}
	
	

}
