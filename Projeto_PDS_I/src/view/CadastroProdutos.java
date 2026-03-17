package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeProduto;
	private JTextField tfValor;
	private JTextField tfQuantEstoque;
	private JTextField tfMarca;
	private JTextField tfCor;
	private JTextField tfCodBarras;
	private JTextField tfFornecedora;
	private JTextField tfDataFabr;
	private JTextField tfDataVal;
	private JTextArea taDescricao;
	
	private JButton btCadastrar; 

	/**
	 * Create the panel.
	 */
	public CadastroProdutos() {
		setBackground(new Color(208, 223, 251));
		
		setMinimumSize(new Dimension(900, 580));
		setLayout(new MigLayout("fill, gap 20", "[][grow][][][][]", "[][][][][][][][]"));
		
		JLabel lbNomeProduto = new JLabel("Nome do Produto");
		lbNomeProduto.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbNomeProduto, "cell 1 1");
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfNomeProduto, "cell 2 1 3 1,growx");
		tfNomeProduto.setColumns(10);
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbValor, "cell 1 2");
		
		tfValor = new JTextField();
		tfValor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfValor, "cell 2 2");
		tfValor.setColumns(10);
		
		JLabel lbQuantEstoque = new JLabel("Quantidade Disponível");
		lbQuantEstoque.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbQuantEstoque, "cell 3 2");
		
		tfQuantEstoque = new JTextField();
		tfQuantEstoque.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfQuantEstoque, "cell 4 2");
		tfQuantEstoque.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbMarca, "cell 1 3");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfMarca, "cell 2 3");
		tfMarca.setColumns(10);
		
		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCor, "cell 3 3");
		
		tfCor = new JTextField();
		tfCor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfCor, "cell 4 3");
		tfCor.setColumns(10);
		
		JLabel lbCodBarras = new JLabel("Código de Barras");
		lbCodBarras.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCodBarras, "cell 1 4");
		
		tfCodBarras = new JTextField();
		tfCodBarras.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfCodBarras, "cell 2 4");
		tfCodBarras.setColumns(10);
		
		JLabel lbFornecedora = new JLabel("Fornecedora");
		lbFornecedora.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbFornecedora, "cell 3 4");
		
		tfFornecedora = new JTextField();
		tfFornecedora.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfFornecedora, "cell 4 4");
		tfFornecedora.setColumns(10);
		
		JLabel lbDataFabr = new JLabel("Data de Fabricação");
		lbDataFabr.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbDataFabr, "cell 1 5");
		
		tfDataFabr = new JTextField();
		tfDataFabr.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfDataFabr, "cell 2 5");
		tfDataFabr.setColumns(10);
		
		JLabel lbDataVal = new JLabel("Data de Validade");
		lbDataVal.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbDataVal, "cell 3 5");
		
		tfDataVal = new JTextField();
		tfDataVal.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfDataVal, "cell 4 5");
		tfDataVal.setColumns(10);
		
		JLabel lbDescrição = new JLabel("Descrição");
		lbDescrição.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbDescrição, "cell 1 6");
		
		taDescricao = new JTextArea();
		taDescricao.setFont(new Font("Georgia", Font.PLAIN, 18));
		add(taDescricao, "cell 2 6 3 1,growx");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 1 7 4 1,growx,aligny center");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(188, 199, 243));
		btCadastrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);

	}
	
	public void cadastrarProdutos(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}

	public String getTfNomeProduto() {
		return tfNomeProduto.getText();
	}

	public void setTfNomeProduto(JTextField tfNomeProduto) {
		this.tfNomeProduto = tfNomeProduto;
	}

	public String getTfValor() {
		return tfValor.getText();
	}

	public void setTfValor(JTextField tfValor) {
		this.tfValor = tfValor;
	}

	public String getTfQuantEstoque() {
		return tfQuantEstoque.getText();
	}

	public void setTfQuantEstoque(JTextField tfQuantEstoque) {
		this.tfQuantEstoque = tfQuantEstoque;
	}

	public String getTfMarca() {
		return tfMarca.getText();
	}

	public void setTfMarca(JTextField tfMarca) {
		this.tfMarca = tfMarca;
	}

	public String getTfCor() {
		return tfCor.getText();
	}

	public void setTfCor(JTextField tfCor) {
		this.tfCor = tfCor;
	}

	public String getTfCodBarras() {
		return tfCodBarras.getText();
	}

	public void setTfCodBarras(JTextField tfCodBarras) {
		this.tfCodBarras = tfCodBarras;
	}

	public String getTfFornecedora() {
		return tfFornecedora.getText();
	}

	public void setTfFornecedora(JTextField tfFornecedora) {
		this.tfFornecedora = tfFornecedora;
	}

	public String getTfDataFabr() {
		return tfDataFabr.getText();
	}

	public void setTfDataFabr(JTextField tfDataFabr) {
		this.tfDataFabr = tfDataFabr;
	}

	public String getTfDataVal() {
		return tfDataVal.getText();
	}

	public void setTfDataVal(JTextField tfDataVal) {
		this.tfDataVal = tfDataVal;
	}

	public String getTaDescricao() {
		return taDescricao.getText();
	}

	public void setTaDescricao(JTextArea taDescricao) {
		this.taDescricao = taDescricao;
	}
}
