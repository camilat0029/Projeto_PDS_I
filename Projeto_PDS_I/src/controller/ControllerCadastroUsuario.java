package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.Cadastro;

public class ControllerCadastroUsuario {
	
	private Cadastro cadastro;
	private NavegadorTelas navegadorTelas;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private boolean cpfRepetido;
	
	
	public ControllerCadastroUsuario(Cadastro cadastro, NavegadorTelas navegadorTelas, UsuarioDAO usuarioDAO) {
		super();
		this.cadastro = cadastro;
		this.navegadorTelas = navegadorTelas;
		this.usuarioDAO = usuarioDAO;
		
		this.cadastro.cadastrarUsuario(e ->{
			novoUsuario();
			System.out.println("clique");
		});
		
		this.cadastro.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				navegadorTelas.mudarTela("LOGIN");
				limparCampos();
			}
		});
		
		
	}
	
	public void novoUsuario() {
		
		usuario = new Usuario(null, null, null);
		
		cpfRepetido = false;
		
		if (cadastro.getTfNomeCadastro().getText().isEmpty() || 
				cadastro.getTfCPF().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os Campos", "Informação", 1);
			
		} else {
			
			verificarCPF();
			
			if (cpfRepetido == true) {
				JOptionPane.showMessageDialog(null, "Este CPF já existe! Corrija o campo.", "Informação", 1);
			} else {
				
				usuario.setNome(cadastro.getTfNomeCadastro().getText());
				usuario.setCpf(cadastro.getTfCPF().getText());
				usuario.setFuncao(cadastro.getCbFuncao().getSelectedItem().toString());
				
				usuarioDAO.adicionarUsuario(usuario);
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso!", "Informação", 1);
				
				navegadorTelas.mudarTela("LOGIN");
				limparCampos();
				
			}
		}
	}
	
	public void verificarCPF() {
		
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		
		for (Usuario usuario : usuarios) {
			
			if (cadastro.getTfCPF().getText().equals(usuario.getCpf())) {
				cpfRepetido = true;
				break;
			} 
			
		}
	}
	
	public void limparCampos() {
		cadastro.getTfNomeCadastro().setText("");
		cadastro.getTfCPF().setText("");
		cadastro.getCbFuncao().setSelectedItem("Administrador");;
	}
	
	
	
	

}
