package model;

public class Produtos {
	
	private int codigoBarras; 
    private String nome; 
    private float valor;
	private String marca; 
    private String fornecedora; 
    private int quantidade; 
    private String descricao; 
    private String cor; 
    private String dataValidade;
    private String dataFabricacao;
    
	public Produtos(int codigoBarras, String nome, float valor, String marca, String fornecedora, int quantidade,
			String descricao, String cor, String dataValidade, String dataFabricacao) {
		super();
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
		this.fornecedora = fornecedora;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.cor = cor;
		this.dataValidade = dataValidade;
		this.dataFabricacao = dataFabricacao;
	}

	public int getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedora() {
		return fornecedora;
	}

	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	} 
}
