package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCarrinhoCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btAumeQtd, btDimiQtd, btExcluir, btConcluirCompra;
	
	private JLabel lbIcone_Voltar, lbValorTotal;

	private JScrollPane scrollPane;
	public JTable tabelaCarrinho;
	public DefaultTableModel tabCarrinhoModelo;
	

	/**
	 * Create the panel.
	 */
	public TelaCarrinhoCompras() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 15", "[][grow][257.00][257][257][49.00][grow]", "[][grow][][][][194.00][][][][grow]"));
		
		lbIcone_Voltar = new JLabel("");
		lbIcone_Voltar.setIcon(new ImageIcon(TelaCarrinhoCompras.class.getResource("/imagens/Icone_Voltar.png")));
		add(lbIcone_Voltar, "cell 0 0");
		
		JLabel lbTituloCarrinhoCp = new JLabel("Carrinho de Compras");
		lbTituloCarrinhoCp.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		add(lbTituloCarrinhoCp, "cell 2 2 3 1,alignx center");
		
		btAumeQtd = new JButton("Aumentar Quantidade (+1)");
		btAumeQtd.setFont(new Font("Georgia", Font.PLAIN, 18));
		btAumeQtd.setBackground(new Color(188, 199, 243));
		add(btAumeQtd, "cell 2 3,growx, gapy 20");
		
		btDimiQtd = new JButton("Diminuir Quantidade(-1)");
		btDimiQtd.setFont(new Font("Georgia", Font.PLAIN, 18));
		btDimiQtd.setBackground(new Color(188, 199, 243));
		add(btDimiQtd, "cell 3 3,growx, gapy 20");
		
		btExcluir = new JButton("Excluir Produto");
		btExcluir.setFont(new Font("Georgia", Font.PLAIN, 18));
		btExcluir.setBackground(new Color(188, 199, 243));
		add(btExcluir, "cell 4 3,growx, gapy 20");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 4 3 3,grow");
		
		tabelaCarrinho = new JTable();
		tabelaCarrinho.setBackground(new Color(255, 255, 255));
		tabelaCarrinho.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 12));
		tabelaCarrinho.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {"Código de Barras", "Nome", "Valor(R$)", "Quantidade"}
				) {
				
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
				
		});
		scrollPane.setViewportView(tabelaCarrinho);
		
		lbValorTotal = new JLabel("Valor Total: R$ ....");
		lbValorTotal.setFont(new Font("Georgia", Font.PLAIN, 15));
		add(lbValorTotal, "cell 4 7,alignx right");
		
		btAumeQtd.setBorderPainted(false);
		btDimiQtd.setBorderPainted(false);
		btExcluir.setBorderPainted(false);
		
		btConcluirCompra = new JButton("Concluir Compra");
		btConcluirCompra.setFont(new Font("Georgia", Font.PLAIN, 20));
		btConcluirCompra.setBackground(new Color(188, 199, 243));
		add(btConcluirCompra, "cell 3 8,growx");
		btConcluirCompra.setBorderPainted(false);

	}
	
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbIcone_Voltar.addMouseListener(mouseListener);
	}
	
	public void aumentarQtd(ActionListener actionListener) {
		this.btAumeQtd.addActionListener(actionListener);
	}

	public void diminuirQtd(ActionListener actionListener) {
		this.btDimiQtd.addActionListener(actionListener);
	}
	
	public void concluirCompra(ActionListener actionListener) {
		this.btConcluirCompra.addActionListener(actionListener);
	}

	public JLabel getLbValorTotal() {
		return lbValorTotal;
	}

	public void setLbValorTotal(JLabel lbValorTotal) {
		this.lbValorTotal = lbValorTotal;
	}
	
	
}
