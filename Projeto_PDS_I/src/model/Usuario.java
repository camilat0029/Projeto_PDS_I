package model;

public class Usuario {
	
	private String nome; 
    private String cpf; 
    private boolean administrador;
    
	public Usuario(String nome, String cpf, boolean administrador) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	} 
}
