package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Cadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCadastro;
	private JTextField tfCPF;
	private JComboBox cbFuncao;
	private JButton btCadastrar;

	/**
	 * Create the panel.
	 */
	public Cadastro() {
		setBackground(new Color(208, 223, 251));
		
		setMinimumSize(new Dimension(900, 580));
		setLayout(new MigLayout("insets 150 300 150 300, wrap 2, gap 30, fill", "[center]40[center]", "[][][][]"));
		
		JLabel lbNomeCadastro = new JLabel("Nome");
		lbNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbNomeCadastro, "cell 0 0");
		
		tfNomeCadastro = new JTextField();
		tfNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(tfNomeCadastro, "cell 1 0,growx");
		tfNomeCadastro.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCPF, "cell 0 1");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(tfCPF, "cell 1 1,growx");
		tfCPF.setColumns(10);
		
		JLabel lbFuncao = new JLabel("Função");
		lbFuncao.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbFuncao, "cell 0 2");
		
		cbFuncao = new JComboBox();
		cbFuncao.setBackground(new Color(255, 255, 255));
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		cbFuncao.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(cbFuncao, "cell 1 2");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 0 3 2 1");
	
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(188, 199, 243));
		btCadastrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);

	}
	
	public void cadastrarUsuario(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}

	public JTextField getTfNomeCadastro() {
		return tfNomeCadastro;
	}

	public void setTfNomeCadastro(JTextField tfNomeCadastro) {
		this.tfNomeCadastro = tfNomeCadastro;
	}

	public JTextField getTfCPF() {
		return tfCPF;
	}

	public void setTfCPF(JTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public JComboBox getCbFuncao() {
		return cbFuncao;
	}

	public void setCbFuncao(JComboBox cbFuncao) {
		this.cbFuncao = cbFuncao;
	}
	
	
	

}
