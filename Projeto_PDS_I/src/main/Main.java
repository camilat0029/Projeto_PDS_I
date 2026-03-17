package main;

import controller.ControllerProdutos;
import controller.NavegadorTelas;
import model.ProdutosDAO;
import view.Cadastro;
import view.CadastroProdutos;
import view.Login;
import view.ProdutosCRUD;
import view.TelaPrincipal;

public class Main {
	
	public static void main(String[] args) {
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		Cadastro cadastro = new Cadastro();
		CadastroProdutos cadProdutos = new CadastroProdutos();
		Login login = new Login();
		ProdutosCRUD produtosCRUD = new ProdutosCRUD();
		ProdutosDAO produtosDAO = new ProdutosDAO();
		
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal, produtosCRUD);
		ControllerProdutos controllerProdutos = new ControllerProdutos(cadProdutos, produtosDAO, navegadorTelas, produtosCRUD);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		navegadorTelas.adicionarPainel("CADASTROPRODUTOS", cadProdutos);
		navegadorTelas.adicionarPainel("PRODUTOSCRUD", produtosCRUD);
		
		
		
		telaPrincipal.setVisible(true);
		navegadorTelas.mudarTela("PRODUTOSCRUD");
		
		
	}

}
