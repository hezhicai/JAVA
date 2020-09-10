package com.zc.week12.cn;
import com.zc.week12.util.ReadWriteTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class NotePad extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JMenuBar menubar;  //声明菜单条
	JMenu menu1,menu2,menu3,menu4,submenu; //声明菜单
	JMenuItem item11,item12,item13,item14,item15,item16,item17;
	JMenuItem item21,item22,item23;
	JMenuItem item31,item32;
	JMenuItem item41,item42,item43;
	File file;
	JFileChooser fileChooser;
	JTextArea showFile;

	public NotePad() {
		setSize(100, 100);
		setTitles("无标题");
		initMenu();
		fileChooser=new JFileChooser();	
		showFile = new JTextArea(12, 60);
		add(new JScrollPane(showFile), BorderLayout.CENTER);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 初始化菜单部分
	public void initMenu() {
		menubar = new JMenuBar();
		menu1 = new JMenu("文件(F)");
		menu1.setMnemonic(KeyEvent.VK_F);
		item11 = new JMenuItem("新建(N)", KeyEvent.VK_N);
		item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		item11.addActionListener(this);
		item12 = new JMenuItem("打开(O)...", KeyEvent.VK_O);
		item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		item12.addActionListener(this);
		item13 = new JMenuItem("保存(S)", KeyEvent.VK_S);
		item13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		item13.addActionListener(this);
		item14 = new JMenuItem("另存为(A)...", KeyEvent.VK_A);
		item14.addActionListener(this);
		item15 = new JMenuItem("通讯录(U)...", KeyEvent.VK_U);
		item15.addActionListener(this);
		item16 = new JMenuItem("打印(P)...", KeyEvent.VK_P);
		item16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		item17 = new JMenuItem("退出(X)", KeyEvent.VK_N);
		item17.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});

		menu1.add(item11);
		menu1.add(item12);
		menu1.add(item13);
		menu1.add(item14);
		menu1.addSeparator();
		menu1.add(item15);
		menu1.add(item16);
		menu1.addSeparator();
		menu1.add(item17);

		menu2 = new JMenu("编辑(E)");
		menu2.setMnemonic(KeyEvent.VK_E);
		item21=new JMenuItem("复制");
		item22=new JMenuItem("粘贴");
		item23=new JMenuItem("搜索.txt的文件");
		item23.addActionListener(this);
		submenu = new JMenu("更多");
		submenu.add(item21);
		submenu.add(item22);
		menu2.add(item23);
		menu2.addSeparator();
		menu2.add(submenu);

		menu3 = new JMenu("格式(O)");
		menu3.setMnemonic(KeyEvent.VK_O);
		item31 = new JMenuItem("自动换行(W)", KeyEvent.VK_W);
		item32 = new JMenuItem("字体(F)", KeyEvent.VK_F);
		menu3.add(item31);
		menu3.add(item32);

		menu4 = new JMenu("设置(S)");
		menu4.setMnemonic(KeyEvent.VK_S);
		item41 = new JMenuItem("修改标题");
		item41.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = JOptionPane.showInputDialog(null, "请输入新标题", "设置新标题", JOptionPane.INFORMATION_MESSAGE);
				if ("".equals(msg)) {
					JOptionPane.showMessageDialog(null, "没有输入新的标题", "注意", JOptionPane.PLAIN_MESSAGE);
				} else {
					setTitle(msg + " - 记事本");
				}
			}
		});
		item42 = new JMenuItem("修改颜色", new ImageIcon("img/b.gif"));
		item42.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(null, "颜色设置", showFile.getBackground());
				if (newColor != null) {
					showFile.setBackground(newColor);
				}
			}
		});		
		menu4.add(item41);
		menu4.add(item42);
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		setJMenuBar(menubar);
	}
	
	void setTitles(String msg){
		setTitle(msg+" - 记事本");
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item11){  //新建
			String title=getTitle();
			boolean bool=title.startsWith("无标题");
			if (!"".equals(showFile.getText())) {
				int option = JOptionPane.showConfirmDialog(null, "是否保存更改？", "记事本",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {				
					if (bool) {
						saveAs();						
					}else{
						ReadWriteTools.writeToDest3(file,showFile.getText());
				    }				
			    }
				showFile.setText("");
			}else if(!bool){
				ReadWriteTools.writeToDest3(file,showFile.getText());
			}
			setTitles("无标题");	
		}else if(e.getSource()==item12){ //打开
			fileChooser.setDialogTitle("打开");
			int rtn=fileChooser.showOpenDialog(this);
			if(rtn==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
				showFile.setText("");				
				showFile.setText(ReadWriteTools.readFromFile3(file));				
				setTitles(fileChooser.getSelectedFile().getName());
			}		
		}else if(e.getSource()==item13){ //保存
			if(getTitle().startsWith("无标题"))
				saveAs();
			else
				ReadWriteTools.writeToDest3(file,showFile.getText());
		}else if(e.getSource()==item14){//另存为
			    saveAs();
				showFile.setText("");
				ReadWriteTools.readFromFile3(file);
				setTitles(fileChooser.getSelectedFile().getName());				
		}else if(e.getSource()==item15){ //通讯录
			new AdressListFrame(showFile);
		}else if(e.getSource()==item23){ //搜索
			String msg = JOptionPane.showInputDialog(null, "请输入搜索的路径：", "搜索文件", JOptionPane.INFORMATION_MESSAGE);
			if ("".equals(msg)) {
				JOptionPane.showMessageDialog(null, "没有输入路径", "注意", JOptionPane.WARNING_MESSAGE);
			} else {
				File dir=new File(msg);
				//File[] fileName=dir.listFiles();
				FileAccept accept=new FileAccept();
				accept.setExtendName("txt");
				File fileName[]=dir.listFiles(accept);
				showFile.setText("");
				showFile.append("搜索到的文件如下：");
				for(File name:fileName){
					String fileOrDir;
					if(name.isDirectory())
						fileOrDir="是目录";
					else fileOrDir="是文件";
					showFile.append("\n"+name.getName()+fileOrDir);
				}			
			}
		}
	}
	
	void saveAs(){
		fileChooser.setDialogTitle("另存为");
		int rtn=fileChooser.showSaveDialog(this);
		if(rtn==JFileChooser.APPROVE_OPTION){
			file=fileChooser.getSelectedFile();			
			ReadWriteTools.writeToDest3(file,showFile.getText());	
		}
	}

}
