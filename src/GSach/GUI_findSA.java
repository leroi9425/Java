package GSach;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GUI_findSA extends JFrame {
	public String[] nhaxb = {"Kim Đồng", "Giáo dục", "Thanh niên"};
	public JComboBox cbbnhaxb = new JComboBox(nhaxb);
	public JButton btntimkiem = new JButton("Tim kiem");
	public JTextField txtgia = new JTextField();
	
	String[] colums = {"Mã sách", "Tên sách", "Nhà xuất bản", "Năm xuất bản", "Giá bán", "Khuyến mại"};
	public DefaultTableModel tablemodel = new DefaultTableModel(colums, 0);
	public JTable table = new JTable(tablemodel);
	public JScrollPane scrollpane = new JScrollPane(table);
	
	public void Window() {
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JPanel panel1 = new JPanel();
		add(panel);
//		add(panel1);
		
		JLabel lbnhaxb = new JLabel("Nha xuat ban");
		panel.add(lbnhaxb);
		panel.add(cbbnhaxb);
		
		JLabel lbgia = new JLabel("Gia ban");
		panel.add(lbgia);
//		txtgia.setPreferredSize(new Dimension(50, 20));
		panel.add(txtgia);
		btntimkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click(e);
			}
		});
		panel.add(btntimkiem);
		add(scrollpane);
		
		XLSach xls = new XLSach();
		ArrayList<Sach> firstdata = xls.getSA();
		updateTable(firstdata);
		
		
		setVisible(true);
	}
	
	public void click(ActionEvent e) {
		XLSach xls = new XLSach();
		String nxb = (String) cbbnhaxb.getSelectedItem();
		String gia = txtgia.getText();
		float fgia = Float.parseFloat(gia);
		ArrayList<Sach> lsach = xls.getSAbyNXBGB(nxb, fgia);
		
		updateTable(lsach);
	}
	
	public void updateTable(ArrayList<Sach> lsach) {
		tablemodel.setRowCount(0);
		
		for(Sach s : lsach) {
			int mas = s.getMas();
			String tens = s.getTens();
			String nhaxb= s.getNhaxb();
			int namsx = s.getNamsx();
			float gia = s.getGia();
			int km = s.Khuyenmai();
			
			String[] row = {mas+"", tens, nhaxb, namsx+"", gia+"", km+""};
			tablemodel.addRow(row);
		}
	}
	
	public static void main(String[] arg) {
		GUI_findSA gui = new GUI_findSA();
		gui.Window();
	}
}
