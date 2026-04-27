package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseListener;

public class TelaNotaFiscal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel lbVoltar, lbConteudoNome, lbConteudoCPF, lbConteudoFormPag, lbConteudoTotalPago;
	JTextArea taProdutos;

	/**
	 * Create the panel.
	 */
	public TelaNotaFiscal() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 5", "[][grow][265.00][265.00][265.00][grow]", "[][grow][][][][][][][250.00][][][grow]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(TelaNotaFiscal.class.getResource("/imagens/Icone_Voltar.png")));
		add(lbVoltar, "cell 0 0");
		
		JLabel lbNotaFiscal = new JLabel("Nota Fiscal");
		lbNotaFiscal.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		add(lbNotaFiscal, "cell 2 2 3 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Georgia", Font.BOLD, 20));
		add(lbNome, "cell 2 3, gapy 15");
		
		lbConteudoNome = new JLabel("...");
		lbConteudoNome.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(lbConteudoNome, "cell 3 3 2 1, gapy 15");
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setFont(new Font("Georgia", Font.BOLD, 20));
		add(lbCPF, "cell 2 4");
		
		lbConteudoCPF = new JLabel("...");
		lbConteudoCPF.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(lbConteudoCPF, "cell 3 4 2 1");
		
		JLabel lbFormaPag = new JLabel("Forma de Pagamento:");
		lbFormaPag.setFont(new Font("Georgia", Font.BOLD, 20));
		add(lbFormaPag, "cell 2 5");
		
		lbConteudoFormPag = new JLabel("...");
		lbConteudoFormPag.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(lbConteudoFormPag, "cell 3 5 2 1,aligny top");
		
		JLabel lbTotalPago = new JLabel("Total Pago:");
		lbTotalPago.setFont(new Font("Georgia", Font.BOLD, 20));
		add(lbTotalPago, "cell 2 6");
		
		lbConteudoTotalPago = new JLabel("...");
		lbConteudoTotalPago.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(lbConteudoTotalPago, "cell 3 6 2 1");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 7 3 4,grow");
		
		taProdutos = new JTextArea();
		taProdutos.setEditable(false);
		taProdutos.setBackground(new Color(243, 243, 243));
		taProdutos.setFont(new Font("Georgia", Font.PLAIN, 18));
		scrollPane.setViewportView(taProdutos);

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}

	public JLabel getLbConteudoNome() {
		return lbConteudoNome;
	}

	public void setLbConteudoNome(JLabel lbConteudoNome) {
		this.lbConteudoNome = lbConteudoNome;
	}

	public JLabel getLbConteudoCPF() {
		return lbConteudoCPF;
	}

	public void setLbConteudoCPF(JLabel lbConteudoCPF) {
		this.lbConteudoCPF = lbConteudoCPF;
	}

	public JLabel getLbConteudoFormPag() {
		return lbConteudoFormPag;
	}

	public void setLbConteudoFormPag(JLabel lbConteudoFormPag) {
		this.lbConteudoFormPag = lbConteudoFormPag;
	}

	public JLabel getLbConteudoTotalPago() {
		return lbConteudoTotalPago;
	}

	public void setLbConteudoTotalPago(JLabel lbConteudoTotalPago) {
		this.lbConteudoTotalPago = lbConteudoTotalPago;
	}

	public JTextArea getTaProdutos() {
		return taProdutos;
	}

	public void setTaProdutos(JTextArea taProdutos) {
		this.taProdutos = taProdutos;
	}
	
	

}
