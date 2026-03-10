package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JButton;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(new Color(208, 223, 251));
		
		setMinimumSize(new Dimension(900, 580));
		setLayout(new MigLayout("gap 30", "[grow][][][][grow]", "[grow][][][][][grow]"));
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbNome, "cell 1 1");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfNome, "cell 2 1 2 1,growx");
		tfNome.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCPF, "cell 1 2");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfCPF, "cell 2 2 2 1,growx");
		tfCPF.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 1 3 3 1,alignx center");
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		btEntrar.setBackground(new Color(188, 199, 243));
		add(btEntrar, "cell 1 3 3 1,alignx center");
		
		JLabel lbConta = new JLabel("Não tem uma conta?");
		lbConta.setFont(new Font("Georgia", Font.PLAIN, 15));
		add(lbConta, "cell 1 4 2 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(208, 223, 251));
		add(panel_1, "cell 3 4,alignx right");
		
		JButton btCadastrese = new JButton("Cadastre-Se");
		btCadastrese.setBackground(new Color(188, 199, 243));
		btCadastrese.setFont(new Font("Georgia", Font.PLAIN, 15));
		panel_1.add(btCadastrese);
		
		btCadastrese.setBorderPainted(false);
		
		
		
		

	}

}
