package hiai.view;
/**
 * 学生添加窗口
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import hiai.dao.GradeTypeDao;
import hiai.dao.StudentDao;
import hiai.model.GradeType;
import hiai.model.Student;
import hiai.util.DbUtil;
import hiai.util.StringUtil;
public class StudentAddFrm extends JInternalFrame {
	private JTextField stuNameTxt;
	private JTextField stuXueTxt;
	private JTextField stuIdcardTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField stuAgeTxt;
	private JTextField stuPhoneTxt;
	private JTextField stuAddressTxt;
	private JComboBox stuGradeTxt;
	private JRadioButton manJcb;
	private JRadioButton femaleJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private GradeTypeDao gradeTypeDao=new GradeTypeDao(); 
	private StudentDao studentDao=new StudentDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddFrm frame = new StudentAddFrm();
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
	public StudentAddFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5B66\u751F\u6DFB\u52A0");
		setBounds(100, 100, 474, 362);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		stuNameTxt = new JTextField();
		stuNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5B66\u9662\uFF1A");
		
		stuXueTxt = new JTextField();
		stuXueTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u73ED\u7EA7\uFF1A");
		
		stuGradeTxt = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		
		stuIdcardTxt = new JTextField();
		stuIdcardTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		
		manJcb = new JRadioButton("\u7537");
		buttonGroup.add(manJcb);
		manJcb.setSelected(true);
		
		femaleJcb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJcb);
		
		JLabel lblNewLabel_5 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		
		stuAgeTxt = new JTextField();
		stuAgeTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		stuPhoneTxt = new JTextField();
		stuPhoneTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		
		stuAddressTxt = new JTextField();
		stuAddressTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentResetActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/reset.gif")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuAddressTxt, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuPhoneTxt))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(stuGradeTxt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(manJcb)
									.addGap(18)
									.addComponent(femaleJcb)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuAgeTxt, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuXueTxt, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuIdcardTxt, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))))
					.addGap(16))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(btnNewButton)
					.addGap(32)
					.addComponent(btnNewButton_1)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(stuXueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(stuGradeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(stuIdcardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(manJcb)
							.addComponent(femaleJcb)
							.addComponent(lblNewLabel_5)
							.addComponent(stuAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(stuPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(stuAddressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		/**
		 * 调用初始化班级下拉框
		 */
		this.fillGradeType();
	}
	/**
	 * 学生添加操作
	 * @param e
	 */
	private void studentAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String stuName=this.stuNameTxt.getText();
		String stuXue=this.stuXueTxt.getText();
		String stuIdcard=this.stuIdcardTxt.getText();
		String stuAge=this.stuAgeTxt.getText();
		String stuAddress=this.stuAddressTxt.getText();
		String stuPhone=this.stuPhoneTxt.getText();
		
		//判断不为空
		if(StringUtil.isEmpty(stuName)){
			JOptionPane.showMessageDialog(null, "学生姓名不能为空");
			return;//如果出现错误终止执行下面
		}
		if(StringUtil.isEmpty(stuXue)){
			JOptionPane.showMessageDialog(null, "学生学院不能为空");
			return;//如果出现错误终止执行下面
		}
		if(StringUtil.isEmpty(stuIdcard)){
			JOptionPane.showMessageDialog(null, "学生学号不能为空");
			return;//如果出现错误终止执行下面
		}
		if(StringUtil.isEmpty(stuAge)){
			JOptionPane.showMessageDialog(null, "学生年龄不能为空");
			return;//如果出现错误终止执行下面
		}
		if(StringUtil.isEmpty(stuAddress)){
			JOptionPane.showMessageDialog(null, "家庭住址不能为空");
			return;//如果出现错误终止执行下面
		}
		if(StringUtil.isEmpty(stuPhone)){
			JOptionPane.showMessageDialog(null, "联系方式不能为空");
			return;//如果出现错误终止执行下面
		}
		
		//判断用户输入的性别
		String stuSex=null;
		if(manJcb.isSelected()){
			stuSex="男";
		}else if(femaleJcb.isSelected()){
			stuSex="女";
		}
		//获取班级
		GradeType gradeType=(GradeType)stuGradeTxt.getSelectedItem();
		int stuTypeid=gradeType.getId();
		//上面全是用户输入  下面进行存储
		Student student=new Student( stuName,  stuXue,  stuIdcard,  stuSex,  stuAge,  stuAddress,
				 stuPhone,  stuTypeid);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addNum=studentDao.add(con, student);
			if(addNum>0){//改变的行数
				JOptionPane.showMessageDialog(null, "学生添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "学生添加失败");
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
	 * 重置操作
	 * @param e
	 */
	private void studentResetActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}
	public void resetValue(){
		this.stuNameTxt.setText("");
		this.stuXueTxt.setText("");
		this.stuAddressTxt.setText("");
		this.stuIdcardTxt.setText("");
		this.stuAgeTxt.setText("");
		this.stuPhoneTxt.setText("");
	}

	/**
	 * 初始化班级下拉框
	 */
	private void fillGradeType(){
		Connection con=null;
		GradeType gradeType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=gradeTypeDao.list(con, new GradeType());
			while(rs.next()){
				gradeType=new GradeType();
				gradeType.setId(rs.getInt("id"));
				gradeType.setGradeName(rs.getString("gradeName"));
				this.stuGradeTxt.addItem(gradeType);
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