package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;

public class BookManagerUI extends JFrame {

	private JPanel contentPane;
	private JTextField topNametxt;
	private JTextField topAuthortxt;
	private JTable table;
	private JTextField idtxt;
	private JTextField lowNametxt;
	private JTextField pricetxt;
	private JTextField lowAuthortxt;
	private JComboBox<BookType> topcomboBox;
	private JComboBox<BookType> lowcomboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton man,woman;
	JTextArea desctxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerUI frame = new BookManagerUI();
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
	public BookManagerUI() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1059, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7");
		label_3.setFont(new Font("幼圆", Font.BOLD, 20));
		
		idtxt = new JTextField();
		idtxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idtxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label_4.setFont(new Font("幼圆", Font.BOLD, 20));
		
		lowNametxt = new JTextField();
		lowNametxt.setFont(new Font("宋体", Font.PLAIN, 20));
		lowNametxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F5C\u8005\u6027\u522B");
		label_5.setFont(new Font("幼圆", Font.BOLD, 20));
		
		man = new JRadioButton("\u7537");
		buttonGroup.add(man);
		man.setFont(new Font("宋体", Font.PLAIN, 20));
		
		woman = new JRadioButton("\u5973");
		buttonGroup.add(woman);
		woman.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_6 = new JLabel("\u4EF7\u683C");
		label_6.setFont(new Font("幼圆", Font.BOLD, 20));
		
		pricetxt = new JTextField();
		pricetxt.setFont(new Font("宋体", Font.PLAIN, 20));
		pricetxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		
		lowAuthortxt = new JTextField();
		lowAuthortxt.setFont(new Font("宋体", Font.PLAIN, 20));
		lowAuthortxt.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		label_8.setFont(new Font("幼圆", Font.BOLD, 20));
		
		lowcomboBox = new JComboBox();
		lowcomboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u6982\u8FF0");
		label_9.setFont(new Font("幼圆", Font.BOLD, 20));
		
		desctxt = new JTextArea();
		desctxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton alterButton = new JButton("\u4FEE\u6539");
		alterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePerform(e);
			}
		});
		alterButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePerform(e);
			}
		});
		deleteButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(pricetxt))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addGap(52)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lowNametxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lowAuthortxt))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_9)
							.addGap(18)
							.addComponent(desctxt, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
					.addGap(55)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(label_8)
							.addComponent(label_5))
						.addComponent(alterButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lowcomboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(deleteButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(man)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(woman)
							.addGap(26)))
					.addContainerGap(66, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_3)
							.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4)
							.addComponent(lowNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_5)
							.addComponent(man)
							.addComponent(woman)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(lowAuthortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(lowcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_9)
								.addGap(64))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(desctxt, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(deleteButton)
								.addComponent(alterButton))
							.addGap(33))))
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedPerform(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" \u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", " \u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "  \u56FE\u4E66\u4EF7\u683C", " \u56FE\u4E66\u6982\u8FF0", " \u56FE\u4E66\u7C7B\u522B"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
		table.getColumnModel().getColumn(1).setPreferredWidth(144);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(117);
		table.getColumnModel().getColumn(4).setPreferredWidth(111);
		table.getColumnModel().getColumn(5).setPreferredWidth(175);
		table.getColumnModel().getColumn(6).setPreferredWidth(134);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		label_1.setFont(new Font("幼圆", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		label_2.setFont(new Font("幼圆", Font.BOLD, 20));
		
		JButton searchbutton = new JButton("\u641C\u7D22");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable(e);
			}
		});
		searchbutton.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		topNametxt = new JTextField();
		topNametxt.setFont(new Font("宋体", Font.PLAIN, 20));
		topNametxt.setColumns(10);
		
		topAuthortxt = new JTextField();
		topAuthortxt.setFont(new Font("宋体", Font.PLAIN, 20));
		topAuthortxt.setColumns(10);
		
	    topcomboBox = new JComboBox();
	    topcomboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(topNametxt, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(topAuthortxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(topcomboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchbutton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(topNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchbutton)
						.addComponent(topcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(topAuthortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		try {
			fillComboBox();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updatePerform(ActionEvent e) {
		//idtxt lowNametxt man woman pricetxt lowAuthortxt lowcomboBox desctxt 
		Book b = new Book();
		b.setID(idtxt.getText());
		b.setBookName(lowNametxt.getText());
		b.setAuthor(lowAuthortxt.getText());
		if(man.isSelected()) {
			b.setSex("男");
		}else {
			b.setSex("女");
		}
		b.setPrice(pricetxt.getText());
		b.setDesc(desctxt.getText());
		b.setTypeID(((BookType)lowcomboBox.getSelectedItem()).getId());
		try {
			int result = new BookDao().update(b);
			if(result == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}

	private void deletePerform(ActionEvent e) {
		String id = idtxt.getText();
		try {
			int result = new BookDao().delete(id);
			if(result == 1) {
				JOptionPane.showMessageDialog(null, "删除成功");
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	private void mousePressedPerform(MouseEvent e) {
		int row = table.getSelectedRow();
		//idtxt lowNametxt man woman pricetxt lowAuthortxt lowcomboBox desctxt 
		//编号 名称 作者 性别 价格 概述 类别
		idtxt.setText(String.valueOf(table.getValueAt(row, 0)) );
		lowNametxt.setText((String) table.getValueAt(row, 1));
		lowAuthortxt.setText((String) table.getValueAt(row, 2));
		if(((String) table.getValueAt(row, 3)).equals("男")) {
			man.setSelected(true);
		}else {
			woman.setSelected(true);
		}
		pricetxt.setText( (String) table.getValueAt(row, 4) );
		desctxt.setText((String) table.getValueAt(row, 5));
		
		}

	private void fillTable(ActionEvent evt){
		String bookName = topNametxt.getText();
		String author = topAuthortxt.getText();
		String typeID = ((BookType)topcomboBox.getSelectedItem()).getId();
	    Book b = new Book();
	    b.setBookName(bookName);
	    b.setAuthor(author);
	    b.setTypeID(typeID);    
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    dtm.setRowCount(0);
	    try {
		ResultSet rs = new BookDao().list(b);
		while(rs.next()) {
			Vector v = new Vector(1);
			//编号 名称 作者 性别 价格 概述 类别
			v.add(rs.getString(1));
			v.add(rs.getString(2));
			v.add(rs.getString(4));
			v.add(rs.getString(5));
			v.add(rs.getString(6));
			v.add(rs.getString(7));
			v.add(rs.getString(9));
			dtm.addRow(v);
		}
		
	    }catch(SQLSyntaxErrorException sql) {
			JOptionPane.showMessageDialog(null, "没有该记录");
		} catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}

	private void fillComboBox() throws SQLException {
		ResultSet rs = new BookTypeDao().listAll();
		topcomboBox.removeAllItems();
		lowcomboBox.removeAllItems();
		BookType b = new BookType();
		topcomboBox.addItem(b);
		lowcomboBox.addItem(b);
		while(rs.next()) {
			b = new BookType();
			b.setId(rs.getString(1));
			b.setBookTypeName(rs.getString(2));
			topcomboBox.addItem(b);
			lowcomboBox.addItem(b);
		}
	}
}
