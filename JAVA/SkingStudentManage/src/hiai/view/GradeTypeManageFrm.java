package hiai.view;
/**
 * 班级维护窗口
 */
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import hiai.dao.GradeTypeDao;
import hiai.model.GradeType;
import hiai.util.DbUtil;
import hiai.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GradeTypeManageFrm extends JInternalFrame {
	private JTextField s_gradeNameTxt;
	private JTable gradeTypeTable;
	
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao(); 
	private JTextField gradeIdTxt;
	private JTextField gradeXueTxt;
	private JTextField gradeNameTxt;
	private JTextArea gradeDescTxt ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeTypeManageFrm frame = new GradeTypeManageFrm();
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
	public GradeTypeManageFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u7EF4\u62A4");
		setBounds(100, 100, 461, 471);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		s_gradeNameTxt = new JTextField();
		s_gradeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeNameSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GradeTypeManageFrm.class.getResource("/images/search.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(GradeTypeManageFrm.class.getResource("/images/reset.gif")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(GradeTypeManageFrm.class.getResource("/images/exit.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_gradeNameTxt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addComponent(btnNewButton_1)
					.addGap(32)
					.addComponent(btnNewButton_2)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u7F16\u53F7\uFF1A");
		
		gradeIdTxt = new JTextField();
		gradeIdTxt.setEditable(false);
		gradeIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		
		gradeXueTxt = new JTextField();
		gradeXueTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		gradeNameTxt = new JTextField();
		gradeNameTxt.setText("");
		gradeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		
		gradeDescTxt = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeDescTxt)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(gradeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(gradeDescTxt, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		gradeTypeTable = new JTable();
		gradeTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gradeTypeTableMousePressed(e);
			}
		});
		gradeTypeTable.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		gradeTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u9662\u540D\u79F0", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(gradeTypeTable);
		getContentPane().setLayout(groupLayout);
		//调用初始化表格
		this.fillTable(new GradeType());
		//优化文本域边框
		gradeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}
	/**
	 * 班级删除
	 * @param e
	 */
	private void gradeTypeDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=gradeIdTxt.getText();//得到用户要删除的班级id
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该条记录吗？");
		if(n==0){
			Connection con=null;
			try {
				con=dbUtil.getCon();
				//删除班级之前先要判断该班级下是否有学生，、
				//如果有学生就不能删除
				int deleteNum=gradeTypeDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功！");
					resetValue();
					fillTable(new GradeType());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					dbUtil.closeCon(con);//关闭数据库
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 班级修改
	 * @param e
	 */
	private void gradeTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=gradeIdTxt.getText();
		String gradeXue=gradeXueTxt.getText();
		String gradeName=gradeNameTxt.getText();
		String gradeDesc=gradeDescTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(gradeXue)){
			JOptionPane.showMessageDialog(null, "学院名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(gradeName)){
			JOptionPane.showMessageDialog(null, "班级名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(gradeDesc)){
			JOptionPane.showMessageDialog(null, "班级备注不能为空！");
			return;
		}
		GradeType gradeType=new GradeType(Integer.parseInt(id),  gradeXue,  gradeName, gradeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=gradeTypeDao.update(con, gradeType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				fillTable(new GradeType());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 重置表单操作
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.gradeIdTxt.setText("");
		this.gradeXueTxt.setText("");
		this.gradeNameTxt.setText("");
		this.gradeDescTxt.setText("");
	}

	/**
	 * 表格单击事件，单击表格在下面显示信息
	 */
	private void gradeTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=gradeTypeTable.getSelectedRow();
		gradeIdTxt.setText((String)gradeTypeTable.getValueAt(row, 0));
		gradeXueTxt.setText((String)gradeTypeTable.getValueAt(row, 1));
		gradeNameTxt.setText((String)gradeTypeTable.getValueAt(row, 2));
		gradeDescTxt.setText((String)gradeTypeTable.getValueAt(row, 3));
	}
	/**
	 * 班级查询
	 * @param e
	 */
	private void gradeNameSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_gradeName=this.s_gradeNameTxt.getText();
		GradeType gradeType=new GradeType();
		gradeType.setGradeName(s_gradeName);
		this.fillTable(gradeType);
	}

	/**
	 * 初始化表格
	 */
	private void fillTable(GradeType gradeType){
		DefaultTableModel dtm=(DefaultTableModel)gradeTypeTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=gradeTypeDao.list(con, gradeType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("gradeXue"));
				v.add(rs.getString("gradeName"));
				v.add(rs.getString("gradeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
