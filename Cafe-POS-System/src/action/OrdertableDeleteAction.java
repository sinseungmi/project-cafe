package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import swing.frame.OrderFrame;

public class OrdertableDeleteAction implements ActionListener {

	JTable table;
	DefaultTableModel model;
	JLabel totalmoney;
	int price;
	int quantity;
	int originalPrice;
	int tablemoney;

	public OrdertableDeleteAction(JTable table, JLabel totalmoney, int tablemoney) {
		this.table = table;
		this.totalmoney = totalmoney;
		this.tablemoney = tablemoney;
	}

	public void actionPerformed(ActionEvent e) {
		model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		
		if(row != -1) {			
			quantity = Integer.parseInt(String.valueOf(model.getValueAt(row, 2)));
			
			
			if (quantity == 1) {
				// ���õ� �ุ �����. model.setRowCount(0);�� 1���� ���ᵵ �� �������� 
				model.removeRow(row);
				OrderFrame.GettableInfo().remove(row);
			}else if(quantity != 1) {
				
				price = Integer.parseInt(String.valueOf(model.getValueAt(row, 3)));
				originalPrice = price / quantity;
				
				quantity--;
				price -= originalPrice;
				
				model.setValueAt(quantity, row, 2);
				model.setValueAt(price, row, 3);
				//model.fireTableDataChanged();
			}
		}
		
			
		}
		

	}
