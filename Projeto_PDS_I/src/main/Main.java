package main;

import javax.swing.UIManager;

import controller.ControllerCadastroUsuario;
import controller.ControllerCarrinhoCompras;
import controller.ControllerCompras;
import controller.ControllerLogin;
import controller.ControllerProdutos;
import controller.NavegadorTelas;
import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.Cadastro;
import view.CadastroProdutos;
import view.Login;
import view.ProdutosCRUD;
import view.TelaCarrinhoCompras;
import view.TelaCompras;
import view.TelaConcluirCompra;
import view.TelaNotaFiscal;
import view.TelaPrincipal;
import view.TelaVisualizarProduto;

public class Main {
	
	public static void main(String[] args) {
		
		//Forma de estilizar
		
		//try {
	    //   UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	    //} catch (Exception e) {
	    //     e.printStackTrace();
	   // }
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario(null, null, null);
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		Cadastro cadastro = new Cadastro();
		CadastroProdutos cadProdutos = new CadastroProdutos();
		Login login = new Login();
		ProdutosCRUD produtosCRUD = new ProdutosCRUD();
		ProdutosDAO produtosDAO = new ProdutosDAO();
		TelaCompras telaCompras = new TelaCompras();
		TelaVisualizarProduto visualizarProduto = new TelaVisualizarProduto();
		TelaCarrinhoCompras carrinhoCompras = new TelaCarrinhoCompras();
		TelaConcluirCompra telaConcluirCompra = new TelaConcluirCompra();
		TelaNotaFiscal telaNotaFiscal = new TelaNotaFiscal();
		
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal, produtosCRUD);
		ControllerProdutos controllerProdutos = new ControllerProdutos(cadProdutos, produtosDAO, navegadorTelas, 
				produtosCRUD, visualizarProduto, usuarioDAO);
		ControllerCadastroUsuario controllerCadastroUsuario = new ControllerCadastroUsuario(cadastro, navegadorTelas, usuarioDAO);
		ControllerLogin controllerLogin = new ControllerLogin(login, navegadorTelas);
		ControllerCompras controllerCompras = new ControllerCompras(telaCompras, navegadorTelas, visualizarProduto, carrinhoCompras);
		ControllerCarrinhoCompras controllerCarrinho = new ControllerCarrinhoCompras(carrinhoCompras, telaCompras, navegadorTelas, 
				telaConcluirCompra, telaNotaFiscal);
		
	    telaCompras.adicionarOuvinte(controllerCompras);
	    produtosCRUD.adicionarOuvinte(controllerProdutos);
	    carrinhoCompras.adicionarOuvinte(controllerCarrinho);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		navegadorTelas.adicionarPainel("CADASTROPRODUTOS", cadProdutos);
		navegadorTelas.adicionarPainel("PRODUTOSCRUD", produtosCRUD);
		navegadorTelas.adicionarPainel("COMPRAS", telaCompras);
		navegadorTelas.adicionarPainel("VISUALIZARPRODUTO", visualizarProduto);
		navegadorTelas.adicionarPainel("CARRINHOCOMPRAS", carrinhoCompras);
		navegadorTelas.adicionarPainel("CONCLUIRCOMPRA", telaConcluirCompra);
		navegadorTelas.adicionarPainel("NOTAFISCAL", telaNotaFiscal);
		
		
		
		telaPrincipal.setVisible(true);
		navegadorTelas.mudarTela("LOGIN");
		
		
	}

}
