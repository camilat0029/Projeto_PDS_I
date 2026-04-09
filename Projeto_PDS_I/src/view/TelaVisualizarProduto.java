package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class TelaVisualizarProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lbIconeVoltar;
	private JLabel lbConteudoCodBarras;
	private JLabel lbConteudoNome;
	private JLabel lbConteudoValor;
	private JLabel lbConteudoMarca;
	private JLabel lbConteudoForn;
	private JLabel lbConteudoQtd;
	private JLabel lbConteudoCor;
	private JLabel lbConteudoDtFab;
	private JLabel lbConteudoDtVal;
	private JTextArea taConteudoDesc;

	public TelaVisualizarProduto() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 10", "[][grow][253.00][323.00][grow]", "[][grow][][][][][][][][][][][][grow][][][][grow]"));
		
		lbIconeVoltar = new JLabel("");
		lbIconeVoltar.setIcon(new ImageIcon(TelaVisualizarProduto.class.getResource("/imagens/Icone_Voltar.png")));
		add(lbIconeVoltar, "cell 0 0");
		
		JLabel lbTituloTela = new JLabel("Produto");
		lbTituloTela.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		add(lbTituloTela, "cell 2 2 2 1,alignx center");
		
		JLabel lbCodigoBarras = new JLabel("Código de Barras");
		lbCodigoBarras.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbCodigoBarras, "cell 2 4");
		
		lbConteudoCodBarras = new JLabel("...");
		lbConteudoCodBarras.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoCodBarras, "cell 3 4");
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbNome, "cell 2 5");
		
		lbConteudoNome = new JLabel("...");
		lbConteudoNome.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoNome, "cell 3 5");
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbValor, "cell 2 6");
		
		lbConteudoValor = new JLabel("...");
		lbConteudoValor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoValor, "cell 3 6");
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbMarca, "cell 2 7");
		
		lbConteudoMarca = new JLabel("...");
		lbConteudoMarca.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoMarca, "cell 3 7");
		
		JLabel lbFornecedora = new JLabel("Fornecedora");
		lbFornecedora.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbFornecedora, "cell 2 8");
		
		lbConteudoForn = new JLabel("...");
		lbConteudoForn.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoForn, "cell 3 8");
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbQuantidade, "cell 2 9");
		
		lbConteudoQtd = new JLabel("...");
		lbConteudoQtd.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoQtd, "cell 3 9");
		
		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbCor, "cell 2 10");
		
		lbConteudoCor = new JLabel("...");
		lbConteudoCor.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoCor, "cell 3 10");
		
		JLabel lbDataFab = new JLabel("Data de Fabricação");
		lbDataFab.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbDataFab, "cell 2 11");
		
		lbConteudoDtFab = new JLabel("...");
		lbConteudoDtFab.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoDtFab, "cell 3 11");
		
		JLabel lbDataVal = new JLabel("Data de Validade");
		lbDataVal.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbDataVal, "cell 2 12");
		
		lbConteudoDtVal = new JLabel("...");
		lbConteudoDtVal.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(lbConteudoDtVal, "cell 3 12");
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setFont(new Font("Georgia", Font.BOLD, 22));
		add(lbDescricao, "cell 2 13");
		
		taConteudoDesc = new JTextArea();
		taConteudoDesc.setFont(new Font("Georgia", Font.PLAIN, 20));
		taConteudoDesc.setBackground(new Color(0,0,0,0));
		add(taConteudoDesc, "cell 3 13 1 4,grow");
		
		taConteudoDesc.setLineWrap(true);

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}

	public JLabel getLbIconeVoltar() {
		return lbIconeVoltar;
	}

	public void setLbIconeVoltar(JLabel lbIconeVoltar) {
		this.lbIconeVoltar = lbIconeVoltar;
	}

	public JLabel getLbConteudoCodBarras() {
		return lbConteudoCodBarras;
	}

	public void setLbConteudoCodBarras(JLabel lbConteudoCodBarras) {
		this.lbConteudoCodBarras = lbConteudoCodBarras;
	}

	public JLabel getLbConteudoNome() {
		return lbConteudoNome;
	}

	public void setLbConteudoNome(JLabel lbConteudoNome) {
		this.lbConteudoNome = lbConteudoNome;
	}

	public JLabel getLbConteudoValor() {
		return lbConteudoValor;
	}

	public void setLbConteudoValor(JLabel lbConteudoValor) {
		this.lbConteudoValor = lbConteudoValor;
	}

	public JLabel getLbConteudoMarca() {
		return lbConteudoMarca;
	}

	public void setLbConteudoMarca(JLabel lbConteudoMarca) {
		this.lbConteudoMarca = lbConteudoMarca;
	}

	public JLabel getLbConteudoForn() {
		return lbConteudoForn;
	}

	public void setLbConteudoForn(JLabel lbConteudoForn) {
		this.lbConteudoForn = lbConteudoForn;
	}

	public JLabel getLbConteudoQtd() {
		return lbConteudoQtd;
	}

	public void setLbConteudoQtd(JLabel lbConteudoQtd) {
		this.lbConteudoQtd = lbConteudoQtd;
	}

	public JLabel getLbConteudoCor() {
		return lbConteudoCor;
	}

	public void setLbConteudoCor(JLabel lbConteudoCor) {
		this.lbConteudoCor = lbConteudoCor;
	}

	public JLabel getLbConteudoDtFab() {
		return lbConteudoDtFab;
	}

	public void setLbConteudoDtFab(JLabel lbConteudoDtFab) {
		this.lbConteudoDtFab = lbConteudoDtFab;
	}

	public JLabel getLbConteudoDtVal() {
		return lbConteudoDtVal;
	}

	public void setLbConteudoDtVal(JLabel lbConteudoDtVal) {
		this.lbConteudoDtVal = lbConteudoDtVal;
	}

	public JTextArea getTaConteudoDesc() {
		return taConteudoDesc;
	}

	public void setTaConteudoDesc(JTextArea taConteudoDesc) {
		this.taConteudoDesc = taConteudoDesc;
	}
	
	

}
