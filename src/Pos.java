import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.Font;

public class Pos extends JFrame implements MouseListener {
	DefaultTableModel model;
	
	JButton btnsugar = new JButton("Sugar");

	private JPanel contentPane;
	private JTable table;
	JLabel lbltotal = new JLabel("000");
	JButton btnsoda = new JButton("Soda");
	JButton btnflour = new JButton("Unga");
	JButton btnbakingflour = new JButton("Baking Flour");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pos frame = new Pos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pos() {	
		
		JFrame frame = new JFrame("Inserting a Column Example!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		btnsugar.setBackground(Color.CYAN);
		btnsoda.setBackground(Color.CYAN);
		btnflour.setBackground(Color.CYAN);		
		btnbakingflour.setBackground(Color.CYAN);
		
		JScrollPane scrollPane = new JScrollPane();
		DefaultTableModel model = new DefaultTableModel();
		
		
		btnsugar.addMouseListener(this);
		btnsoda.addMouseListener(this);
		btnflour.addMouseListener(this);
		btnbakingflour.addMouseListener(this); 
		
		JLabel lblNewLabel = new JLabel("TOTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		
		
		lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1 = new JLabel("Sh.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnsugar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnsoda, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnflour, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnbakingflour, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lbltotal, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addGap(39))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnsugar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnsoda, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnflour, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnbakingflour, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbltotal, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addGap(91))
		);
		
		table= new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Price", "Quantity", "Total"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnsugar )
		{
		String name = "Sugar";
		int price = 50;
		 
		int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the Qty"));
		int tot = price * qty;
		 
		model = (DefaultTableModel)table.getModel();
		 
		model.addRow(new Object[]
		{
		name,
		price,
		qty,
		tot,
		});
		 
		int sum = 0;
		 
		for(int i = 0; i <table.getRowCount(); i++)
		{
		 
		sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString());
		 
		}
		lbltotal.setText(Integer.toString(sum));
		} else if(e.getSource() == btnsoda )
		{
		String name = "Soda";
		int price = 45;
		 
		int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the Qty"));
		int tot = price * qty;
		 
		model = (DefaultTableModel)table.getModel();
		 
		model.addRow(new Object[]
		{
		name,
		price,
		qty,
		tot,
		});
		 
		int sum = 0;
		 
		for(int i = 0; i <table.getRowCount(); i++)
		{
		 
		sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString());
		 
		}
		lbltotal.setText(Integer.toString(sum));
		}else if(e.getSource() == btnflour )
		{
		String name = "Flour";
		int price = 70;
		 
		int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the Qty"));
		int tot = price * qty;
		 
		model = (DefaultTableModel)table.getModel();
		 
		model.addRow(new Object[]
		{
		name,
		price,
		qty,
		tot,
		});
		 
		int sum = 0;
		 
		for(int i = 0; i <table.getRowCount(); i++)
		{
		 
		sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString());
		 
		}
		lbltotal.setText(Integer.toString(sum));
		}else if (e.getSource() == btnbakingflour )
		{
		String name = "Baking Flour";
		int price = 80;
		 
		int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the Qty"));
		int tot = price * qty;
		 
		model = (DefaultTableModel)table.getModel();
		 
		model.addRow(new Object[]
		{
		name,
		price,
		qty,
		tot,
		});
		 
		int sum = 0;
		 
		for(int i = 0; i <table.getRowCount(); i++)
		{
		 
		sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString());
		 
		}
		lbltotal.setText(Integer.toString(sum));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
