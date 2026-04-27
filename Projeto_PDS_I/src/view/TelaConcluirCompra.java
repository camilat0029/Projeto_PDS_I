package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TelaConcluirCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel lbVoltar, lbConteudoNome, lbConteudoCPF, lbConteudoTotalPag;
	JButton btNotaFiscal;
	JRadioButton rbCartaoCre, rbCartaoDeb, rbPix;
	ButtonGroup pagamento;
	
	public TelaConcluirCompra() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 15", "[][grow][][200.00][200.00][200.00][grow]", "[][grow][][][][][][][][grow]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(TelaConcluirCompra.class.getResource("/imagens/Icone_Voltar.png")));
		add(lbVoltar, "cell 0 0");
		
		JLabel lbConcluirCompra = new JLabel("Conclua sua Compra");
		lbConcluirCompra.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		add(lbConcluirCompra, "cell 2 2 4 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbNome, "cell 2 3, gapy 70");
		
		lbConteudoNome = new JLabel("...");
		lbConteudoNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoNome, "cell 3 3 3 1, gapy 70");
		
		JLabel lbCPF = new JLabel("CPF: ");
		lbCPF.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbCPF, "cell 2 4");
		
		lbConteudoCPF = new JLabel("...");
		lbConteudoCPF.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoCPF, "cell 3 4 3 1");
		
		JLabel lbTotalPagar = new JLabel("Total a Pagar:");
		lbTotalPagar.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbTotalPagar, "cell 2 5");
		
		lbConteudoTotalPag = new JLabel("...");
		lbConteudoTotalPag.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoTotalPag, "cell 3 5 3 1");
		
		JLabel lbFormaPag = new JLabel("Forma de Pagamento:");
		lbFormaPag.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbFormaPag, "cell 2 6, gapy 30");
		
		rbCartaoCre = new JRadioButton("Cartão Crédito");
		rbCartaoCre.setFont(new Font("Georgia", Font.PLAIN, 22));
		rbCartaoCre.setBackground(new Color(208, 223, 251));
		add(rbCartaoCre, "cell 3 6,alignx left,  gapy 30");
		
		rbCartaoDeb = new JRadioButton("Cartão Débito");
		rbCartaoDeb.setFont(new Font("Georgia", Font.PLAIN, 22));
		rbCartaoDeb.setBackground(new Color(208, 223, 251));
		add(rbCartaoDeb, "cell 4 6,alignx left,  gapy 30");
		
		rbPix = new JRadioButton("Pix");
		rbPix.setFont(new Font("Georgia", Font.PLAIN, 22));
		rbPix.setBackground(new Color(208, 223, 251));
		add(rbPix, "cell 5 6,alignx left,  gapy 30");
		
		pagamento = new ButtonGroup();
		
		pagamento.add(rbCartaoCre);
		pagamento.add(rbCartaoDeb);
		pagamento.add(rbPix);
		
		btNotaFiscal = new JButton("Emitir Nota Fiscal");
		btNotaFiscal.setFont(new Font("Georgia", Font.PLAIN, 22));
		btNotaFiscal.setBackground(new Color(188, 199, 243));
		add(btNotaFiscal, "cell 2 8 4 1,alignx center, gapy 40");
		
		btNotaFiscal.setBorderPainted(false);

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}
	
	public void emitirNotaFiscal(ActionListener actionListener) {
		this.btNotaFiscal.addActionListener(actionListener);
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



	public JLabel getLbConteudoTotalPag() {
		return lbConteudoTotalPag;
	}



	public void setLbConteudoTotalPag(JLabel lbConteudoTotalPag) {
		this.lbConteudoTotalPag = lbConteudoTotalPag;
	}



	public JRadioButton getRbCartaoCre() {
		return rbCartaoCre;
	}



	public void setRbCartaoCre(JRadioButton rbCartaoCre) {
		this.rbCartaoCre = rbCartaoCre;
	}



	public JRadioButton getRbCartaoDeb() {
		return rbCartaoDeb;
	}



	public void setRbCartaoDeb(JRadioButton rbCartaoDeb) {
		this.rbCartaoDeb = rbCartaoDeb;
	}



	public JRadioButton getRbPix() {
		return rbPix;
	}



	public void setRbPix(JRadioButton rbPix) {
		this.rbPix = rbPix;
	}
	
	

}
