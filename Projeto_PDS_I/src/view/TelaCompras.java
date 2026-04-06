package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaCompras() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][235.00][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 223, 251));
		add(panel, "cell 1 2 3 1,grow");
		panel.setLayout(new GridLayout(1, 3, 20, 10));
		
		JPanel panel_item1 = new JPanel();
		panel_item1.setBackground(new Color(227, 236, 253));
		panel.add(panel_item1);
		
		JPanel panel_item2 = new JPanel();
		panel_item2.setBackground(new Color(227, 236, 253));
		panel.add(panel_item2);
		
		JPanel panel_item3 = new JPanel();
		panel_item3.setBackground(new Color(227, 236, 253));
		panel.add(panel_item3);
		
		panel_item1.setLayout(new MigLayout("fill", "[grow, center]", "[][][][]"));
		panel_item2.setLayout(new MigLayout("fill", "[grow, center]", "[][][][]"));
		panel_item3.setLayout(new MigLayout("fill", "[grow, center]", "[][][][]"));
		
		
		JLabel lbNomeProduto = new JLabel("Nome do Produto");
		lbNomeProduto.setFont(new Font("Georgia", Font.BOLD, 18));
		panel_item1.add(lbNomeProduto, "cell 0 0");
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Georgia", Font.PLAIN, 20));
		panel_item1.add(lbValor, "cell 0 1");
		
		JLabel lbSaibaMais = new JLabel("Saiba Mais");
		lbSaibaMais.setBackground(new Color(248, 165, 250));
		lbSaibaMais.setForeground(new Color(146, 9, 149));
		lbSaibaMais.setFont(new Font("Georgia", Font.PLAIN, 15));
		panel_item1.add(lbSaibaMais, "cell 0 2");
		
		JButton btAddCarrinho = new JButton("Adicionar ao Carrinho");
		btAddCarrinho.setBackground(new Color(188, 199, 243));
		btAddCarrinho.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel_item1.add(btAddCarrinho, "cell 0 3,growy");
		
		
		
		JLabel lbNomeProduto2 = new JLabel("Nome do Produto 2");
		lbNomeProduto2.setFont(new Font("Georgia", Font.BOLD, 18));
		panel_item2.add(lbNomeProduto2, "cell 0 0");
		
		JLabel lbValor2 = new JLabel("Valor 2");
		lbValor2.setFont(new Font("Georgia", Font.PLAIN, 20));
		panel_item2.add(lbValor2, "cell 0 1");
		
		JLabel lbSaibaMais2 = new JLabel("Saiba Mais 2");
		lbSaibaMais2.setForeground(new Color(146, 9, 149));
		lbSaibaMais2.setFont(new Font("Georgia", Font.PLAIN, 15));
		panel_item2.add(lbSaibaMais2, "cell 0 2");
		
		JButton btAddCarrinho2 = new JButton("Adicionar ao Carrinho");
		btAddCarrinho2.setBackground(new Color(188, 199, 243));
		btAddCarrinho2.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel_item2.add(btAddCarrinho2, "cell 0 3,growy");
				
		
		
		JLabel lbNomeProduto3 = new JLabel("Nome do Produto 3");
		lbNomeProduto3.setFont(new Font("Georgia", Font.BOLD, 18));
		panel_item3.add(lbNomeProduto3, "cell 0 0");
		
		JLabel lbValor3 = new JLabel("Valor 3");
		lbValor3.setFont(new Font("Georgia", Font.PLAIN, 20));
		panel_item3.add(lbValor3, "cell 0 1");
		
		JLabel lbSaibaMais3 = new JLabel("Saiba Mais 3");
		lbSaibaMais3.setForeground(new Color(146, 9, 149));
		lbSaibaMais3.setFont(new Font("Georgia", Font.PLAIN, 15));
		panel_item3.add(lbSaibaMais3, "cell 0 2");
		
		JButton btAddCarrinho3 = new JButton("Adicionar ao Carrinho");
		btAddCarrinho3.setBackground(new Color(188, 199, 243));
		btAddCarrinho3.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel_item3.add(btAddCarrinho3, "cell 0 3,growy");
		
		btAddCarrinho.setBorderPainted(false);
		btAddCarrinho2.setBorderPainted(false);
		btAddCarrinho3.setBorderPainted(false);
		

	}
}
