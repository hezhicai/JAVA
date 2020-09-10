package hiai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import hiai.dao.GradeTypeDao;
import hiai.model.GradeType;
import hiai.util.DbUtil;
import hiai.util.StringUtil;


public class GradeTypeAddFrm extends JInternalFrame {
	private JTextField gradeXueTxt;
	private JTextField gradeNameTxt;
	private JTextArea gradeDescTxt;
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeTypeAddFrm frame = new GradeTypeAddFrm();
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
	public GradeTypeAddFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		
		gradeXueTxt = new JTextField();
		gradeXueTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		
		gradeNameTxt = new JTextField();
		gradeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		
		gradeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeTypeAddActionPerfromed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GradeTypeAddFrm.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(GradeTypeAddFrm.class.getResource("/images/reset.gif")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gradeDescTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(gradeNameTxt)
								.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))
					.addGap(119))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(btnNewButton)
					.addGap(36)
					.addComponent(btnNewButton_1)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(gradeXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(gradeDescTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);
		
		//优化文本域边框
		gradeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));


	}
	/**
	 * 班级添加事件
	 * @param e
	 */
	private void gradeTypeAddActionPerfromed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String gradeXue=this.gradeXueTxt.getText();//得到用户输入的学院信息
		String gradeName=this.gradeNameTxt.getText();//班级名称
		String gradeDesc=this.gradeDescTxt.getText();//班级备注
		
		//进行判断是否为空
		if(StringUtil.isEmpty(gradeXue)){
			JOptionPane.showMessageDialog(null, "学院名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(gradeName)){
			JOptionPane.showMessageDialog(null, "班级名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(gradeDesc)){
			JOptionPane.showMessageDialog(null, "班级备注不能为空");
			return;//如果出现错误终止执行下面
		}
		
		GradeType gradeType=new GradeType( gradeXue,  gradeName,  gradeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=gradeTypeDao.add(con, gradeType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "班级添加成功");
				resetValues();
			}else{
				JOptionPane.showMessageDialog(null, "班级添加失败");
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

	/**
	 * 重置事件操作
	 * @param e
	 */
	private void resetActionPerformed(ActionEvent evt) {
		this.resetValues();
		
	}
	private void resetValues(){
		this.gradeXueTxt.setText("");
		this.gradeNameTxt.setText("");
		this.gradeDescTxt.setText("");
	}
}
