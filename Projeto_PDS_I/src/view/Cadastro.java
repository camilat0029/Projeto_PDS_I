package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Cadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCadastro;
	private JTextField tfCPF;

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
		
		JComboBox cbFuncao = new JComboBox();
		cbFuncao.setBackground(new Color(255, 255, 255));
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"Não Administrador", "Administrador"}));
		cbFuncao.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(cbFuncao, "cell 1 2");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 0 3 2 1");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(188, 199, 243));
		btCadastrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);
		
		
		

	}

}
