package hiai.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import hiai.dao.UserDao;
import hiai.model.User;
import hiai.util.DbUtil;
import hiai.util.StringUtil;


public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passWord;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogOnFrm.class.getResource("/images/Teacher.png")));
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/student.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/Teacher.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/user.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		passWord = new JPasswordField();
		
		JButton loginBut = new JButton("\u767B\u5F55");
		loginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginBut.setFont(new Font("宋体", Font.PLAIN, 14));
		loginBut.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		
		JButton resetBut = new JButton("\u91CD\u7F6E");
		resetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		resetBut.setFont(new Font("宋体", Font.PLAIN, 14));
		resetBut.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.gif")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addComponent(lblNewLabel_1)
					.addGap(24))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passWord))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userName, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(loginBut)
					.addGap(18)
					.addComponent(resetBut)
					.addContainerGap(126, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					
					.addGap(96))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(lblNewLabel)))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBut)
						.addComponent(resetBut))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
				
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 用户登录操作
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName=this.userName.getText();
		String passWord=new String(this.passWord.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(passWord)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user=new User(userName,passWord);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currenUser=userDao.login(con, user);
			if(currenUser!=null){
				dispose();//销毁当前窗口
				new MainFrm().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "用户名或者密码错误");
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
	 * 重置操作
	 * @param e
	 */
	private void resetActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userName.setText("");
		this.passWord.setText("");
	}

}
