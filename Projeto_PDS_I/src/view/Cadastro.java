package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Cadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCadastro;
	private JFormattedTextField tfCPF;
	private JComboBox cbFuncao;
	private JButton btCadastrar;
	private JLabel lbVoltar;

	/**
	 * Create the panel.
	 */
	public Cadastro() {
		
		setBackground(new Color(208, 223, 251));
		setMinimumSize(new Dimension(1020, 640)); 
		setPreferredSize(new Dimension(1020, 640));
		
		setLayout(new MigLayout("wrap 2, gap 30, fill", "[50.00][grow][center]40[]40[50.00]40[grow,center]", "[][grow][][][][][][grow]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/Icone_Voltar.png")));
		add(lbVoltar, "cell 0 0");
		
		JLabel lbNomeCadastro = new JLabel("Nome");
		lbNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbNomeCadastro, "cell 2 2");
		
		tfNomeCadastro = new JTextField();
		tfNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(tfNomeCadastro, "cell 3 2,width 25%,height 38px");
		tfNomeCadastro.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbCPF, "cell 2 3");
		
		try {
			MaskFormatter  mascaraCPF = new MaskFormatter("### ### ### ##");
			mascaraCPF.setPlaceholder(" ");
			
			tfCPF = new JFormattedTextField(mascaraCPF);
			tfCPF.setFont(new Font("Georgia", Font.PLAIN, 20));
			add(tfCPF, "cell 3 3,width 25%,height 38px");
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		tfCPF.setColumns(10);
		
		JLabel lbFuncao = new JLabel("Função");
		lbFuncao.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbFuncao, "cell 2 4");
		
		cbFuncao = new JComboBox();
		cbFuncao.setBackground(new Color(255, 255, 255));
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		cbFuncao.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(cbFuncao, "cell 3 4,width 25%,height 38px");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 2 6 2 1");
	
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(188, 199, 243));
		btCadastrar.setFont(new Font("Georgia", Font.PLAIN, 22));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				int novaFonte = Math.max(22, Math.min(35, getWidth() / 50));
				
				lbNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				lbCPF.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				lbFuncao.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				btCadastrar.setFont(new Font("Georgia", Font.PLAIN, novaFonte));
				
				int novaFonte2 = Math.max(22, Math.min(27, getWidth() / 50));
				
				tfCPF.setFont(new Font("Georgia", Font.PLAIN, novaFonte2));
				tfNomeCadastro.setFont(new Font("Georgia", Font.PLAIN, novaFonte2));
				cbFuncao.setFont(new Font("Georgia", Font.PLAIN, novaFonte2));
			}
		});

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
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
		this.tfCPF = (JFormattedTextField) tfCPF;
	}

	public JComboBox getCbFuncao() {
		return cbFuncao;
	}

	public void setCbFuncao(JComboBox cbFuncao) {
		this.cbFuncao = cbFuncao;
	}
	
	
	

}
