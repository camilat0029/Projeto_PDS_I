package main;

import controller.NavegadorTelas;
import view.Cadastro;
import view.CadastroProdutos;
import view.Login;
import view.TelaPrincipal;

public class Main {
	
	public static void main(String[] args) {
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		Cadastro cadastro = new Cadastro();
		CadastroProdutos cadProdutos = new CadastroProdutos();
		Login login = new Login();
		
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		navegadorTelas.adicionarPainel("CADASTROPRODUTOD", cadProdutos);
		
		
		
		telaPrincipal.setVisible(true);
		navegadorTelas.mudarTela("LOGIN");
		
		
	}

}
