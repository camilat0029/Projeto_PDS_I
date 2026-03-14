package controller;

import javax.swing.JPanel;

import view.TelaPrincipal;

public class NavegadorTelas {
	
	private TelaPrincipal telaPrincipal;

	public NavegadorTelas(TelaPrincipal telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
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
