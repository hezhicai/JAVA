package hiai.view;
/**
 * 系统主界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/Teacher.png")));
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/student01.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u9000\u51FA\u7A0B\u5E8F");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出程序？");
				if(result==0){
					dispose();//销毁程序
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classmanage.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeTypeAddFrm gradeTypeAddFrm=new GradeTypeAddFrm();
				gradeTypeAddFrm.setVisible(true);
				table.add(gradeTypeAddFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u73ED\u7EA7\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GradeTypeManageFrm gradeTypeManageFrm=new GradeTypeManageFrm();
				gradeTypeManageFrm.setVisible(true);
				table.add(gradeTypeManageFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studengmanage.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAddFrm studentAddFrm=new StudentAddFrm();
				studentAddFrm.setVisible(true);
				table.add(studentAddFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置默认最大化窗口
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}