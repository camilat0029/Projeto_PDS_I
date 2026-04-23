package controller;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.Login;

public class ControllerLogin {
	
	private Login login;
	private NavegadorTelas navegadorTelas;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private boolean usuarioEncontrado;
	public static Usuario usuarioLogado;
	
	
	public ControllerLogin(Login login, NavegadorTelas navegadorTelas) {
		super();
		this.login = login;
		this.navegadorTelas = navegadorTelas;
		
		this.login.cadastrarSe(e ->{
			navegadorTelas.mudarTela("CADASTRO");
			limparCamposLogin();	
		});
		
		this.login.entrar(e ->{
			verificarInformacoes();
			limparCamposLogin();
		});
		
	}
	
	public void limparCamposLogin() {
		login.getTfNome().setText("");
		login.getTfCPF().setText("");
	}
	
	public void verificarInformacoes() {
		
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		
		usuarioEncontrado = false;
		String funcaoUsuario = "";
		
		if(login.getTfNome().getText().isEmpty() || login.getTfCPF().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os Campos", "Informação", 1);
		} else {
			
			for (Usuario usuario : usuarios) {
				if(usuario.getNome().equals(login.getTfNome().getText()) && 
						usuario.getCpf().equals(login.getTfCPF().getText()) && 
						usuario.getFuncao().equals("Administrador")) {
					
					usuarioEncontrado = true;
					usuarioLogado = usuario;
					funcaoUsuario = "Administrador";
					break;
				} else if(usuario.getNome().equals(login.getTfNome().getText()) && 
						usuario.getCpf().equals(login.getTfCPF().getText()) && 
						usuario.getFuncao().equals("Cliente")) {
					
					usuarioEncontrado = true;
					usuarioLogado = usuario;
					funcaoUsuario = "Cliente";
					break;
					
				}
			}
			
			if (usuarioEncontrado == true) {
				if(funcaoUsuario.equals("Administrador")) {
					navegadorTelas.mudarTela("PRODUTOSCRUD");
				} else if(funcaoUsuario.equals("Cliente")) {
					navegadorTelas.mudarTela("COMPRAS");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não Encontrado! \nVerifique as Informações.", "Informação", 1);
			}
		}
	}
	
	
	

}
