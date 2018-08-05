package ui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.BookTypeDao;
import model.BookType;
import util.MysqlUtil;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManagerUI extends JFrame {

	private JPanel contentPane;
	private JTable typeTable;
	private JLabel label;
	private JTextField searchtxt;
	private JButton button;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextArea desctxt;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerUI frame = new BookTypeManagerUI();
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
	public BookTypeManagerUI() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 784, 842);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		
		label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		
		searchtxt = new JTextField();
		searchtxt.setFont(new Font("宋体", Font.PLAIN, 20));
		searchtxt.setColumns(10);
		
		button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPreform(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 19));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setForeground(Color.WHITE);
		panel.setToolTipText("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(label)
							.addGap(22)
							.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(button)))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u8868\u5355\u64CD\u4F5C");
		label_1.setFont(new Font("幼圆", Font.BOLD, 21));
		
		JLabel label_2 = new JLabel("\u7F16\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		idtxt = new JTextField();
		idtxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idtxt.setEditable(false);
		idtxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("宋体", Font.PLAIN, 20));
		nametxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u63CF\u8FF0");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		desctxt = new JTextArea();
		desctxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdatePerform(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    deletePerform(e); 
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_4))
							.addGap(41)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(81)
									.addComponent(label_3)
									.addGap(29)
									.addComponent(nametxt, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addComponent(desctxt, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(204)
							.addComponent(button_1)
							.addGap(102)
							.addComponent(button_2)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(nametxt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(desctxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		typeTable = new JTable();
		typeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedPerform(e);
			}
		});
		typeTable.setColumnSelectionAllowed(true);
		typeTable.setFillsViewportHeight(true);
		typeTable.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		typeTable.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 20));
		typeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  \u7F16\u53F7", " \u56FE\u4E66\u7C7B\u578B\u540D\u79F0", " \u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		typeTable.getColumnModel().getColumn(0).setPreferredWidth(86);
		typeTable.getColumnModel().getColumn(1).setPreferredWidth(136);
		typeTable.getColumnModel().getColumn(2).setPreferredWidth(138);
		scrollPane.setViewportView(typeTable);
		contentPane.setLayout(gl_contentPane);
		typeTable.setRowHeight(30);
	}
	
	private void deletePerform(ActionEvent e) {
		String id = idtxt.getText();
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "没有选中内容");
			return ;
		}
		
		int res = new BookTypeDao().delete(id);
		if(res == 0) {
			JOptionPane.showMessageDialog(null, "修改失败");
			return;
		}else {
			JOptionPane.showMessageDialog(null, "成功修改"+res+"条记录");
		}
		
		fillTable(new BookType());
		
	}

	private void bookTypeUpdatePerform(ActionEvent e) {
		String id = idtxt.getText();
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "没有选中内容");
			return;
		}
		String name = nametxt.getText();
		String desc = desctxt.getText();
		BookType bt = new BookType(id,name,desc);
		BookTypeDao btd = new BookTypeDao();
		if(btd.delete(id) == 1 &&btd.addBookType(bt) == 1) {
			JOptionPane.showMessageDialog(null, "完成修改！");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}	
		fillTable(new BookType());
	}

	private void mousePressedPerform(MouseEvent e) {
		int row = typeTable.getSelectedRow();
		idtxt.setText(String.valueOf(typeTable.getValueAt(row, 0)));
		nametxt.setText((String) typeTable.getValueAt(row, 1));
		desctxt.setText((String) typeTable.getValueAt(row, 2));
	}

	private void searchPreform(ActionEvent e) {
		String str = searchtxt.getText();
		BookType bt = new BookType(str,null);
		fillTable(bt);
	}

	private void fillTable(BookType bt) { //typeTable
		ResultSet rs = null;

		DefaultTableModel dtm = (DefaultTableModel) typeTable.getModel();
		dtm.setRowCount(0); //清除记录
		try {
			rs = new BookTypeDao().list(bt);
			while(rs.next()) {
				Vector temp = new Vector();
				temp.add(rs.getInt(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				dtm.addRow(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
