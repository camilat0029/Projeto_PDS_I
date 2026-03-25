package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	private JButton btCadastrese;
	private JButton btEntrar;

	/**
	 * Create the panel.
	 */
	public Login() {
		
		setBackground(new Color(208, 223, 251));
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		
		setLayout(new MigLayout("gap 30", "[grow][][141.00][141.00][][grow]", "[grow][][][][][][grow]"));
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbNome, "cell 1 1");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfNome, "cell 2 1 3 1,growx,width 25%,height 38px");
		tfNome.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCPF, "cell 1 2");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(tfCPF, "cell 2 2 3 1,growx,width 25%,height 38px");
		tfCPF.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 1 4 4 1,alignx center");
		
		btEntrar = new JButton("Entrar");
		btEntrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		btEntrar.setBackground(new Color(188, 199, 243));
		add(btEntrar, "cell 1 4 4 1,alignx center");
		
		JLabel lbConta = new JLabel("Não tem uma conta?");
		lbConta.setFont(new Font("Georgia", Font.PLAIN, 15));
		add(lbConta, "cell 1 5 2 1,alignx center");
		btEntrar.setBorderPainted(false);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(208, 223, 251));
		add(panel_1, "cell 3 5 2 1,alignx center");
		
		btCadastrese = new JButton("Cadastre-Se");
		btCadastrese.setBackground(new Color(188, 199, 243));
		btCadastrese.setFont(new Font("Georgia", Font.PLAIN, 15));
		panel_1.add(btCadastrese);
		
		btCadastrese.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent e) {
				
				int novaFonte = Math.max(22, Math.min(35, getWidth() / 50));
				
				lbNome.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				lbCPF.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				btEntrar.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				
				int novaFonte2 = Math.max(22, Math.min(27, getWidth() / 50));
				
				tfNome.setFont(new Font("Georgia", Font.PLAIN, novaFonte2));
				tfCPF.setFont(new Font("Georgia", Font.PLAIN, novaFonte2));
				
				int novaFonte3 = Math.max(10, Math.min(20, getWidth() / 58));
				
				lbConta.setFont(new Font("Georgia", Font.PLAIN, novaFonte3));
				btCadastrese.setFont(new Font("Georgia", Font.PLAIN, novaFonte3));
			}
		});

	}
	
	public void entrar(ActionListener actionListener) {
		this.btEntrar.addActionListener(actionListener);
	}
	
	public void cadastrarSe(ActionListener actionListener) {
		this.btCadastrese.addActionListener(actionListener);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfCPF() {
		return tfCPF;
	}

	public void setTfCPF(JTextField tfCPF) {
		this.tfCPF = tfCPF;
	}
	
	

}
