package controller;

import javax.swing.JPanel;

import view.ProdutosCRUD;
import view.TelaPrincipal;

public class NavegadorTelas {
	
	private TelaPrincipal telaPrincipal;
	private ProdutosCRUD produtosCRUD;

	public NavegadorTelas(TelaPrincipal telaPrincipal, ProdutosCRUD produtosCRUD) {
		super();
		this.telaPrincipal = telaPrincipal;
		this.produtosCRUD = produtosCRUD;
		
		this.produtosCRUD.adicionarProdutos(e ->{
			mudarTela("CADASTROPRODUTOS");
			System.out.println("CLIQUE");
		});
		
		
		
	}
	
	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal.adicionarTela(nome, tela);
	}
	
	public void mudarTela(String nome) {
		this.telaPrincipal.mostrarTela(nome);
	}
	
	public void fecharTelaPrincipal() {
		this.telaPrincipal.dispose();
	}

}
