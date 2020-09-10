package com.zc.week12.cn;

import com.zc.week12.util.AddressDao;
import com.zc.week12.util.AddressObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;

public class AdressListFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel panel1,panel2;
	Box boxH;
	Box boxOne,boxTwo;
	JTextField nameField,telField,qqField;
	JButton enterBtn,listBtn,searchBtn,delBtn,updateBtn;
	JTextArea showFile;
	File file;
	RandomAccessFile access;
	FileChannel channel;
	FileLock lock;
	
	public AdressListFrame(JTextArea area) {
		showFile=area;
		panel1=new JPanel();
		panel2=new JPanel();
		nameField=new JTextField(10);
		telField=new JTextField(10);
		qqField=new JTextField(10);
		enterBtn=new JButton("新增");
		enterBtn.addActionListener(this);
		listBtn=new JButton("查看通讯录");
		listBtn.addActionListener(this);
		searchBtn=new JButton("搜索");
		searchBtn.addActionListener(this);
		updateBtn=new JButton("修改");
		updateBtn.addActionListener(this);
		delBtn=new JButton("删除");
		delBtn.addActionListener(this);
		boxH=Box.createHorizontalBox();
		boxOne=Box.createVerticalBox();
		boxTwo=Box.createVerticalBox();
		boxOne.add(new JLabel("姓名："));
		boxOne.add(new JLabel("电话："));
		boxOne.add(new JLabel("QQ："));		
		boxTwo.add(nameField);
		boxTwo.add(telField);
		boxTwo.add(qqField);		
		boxH.add(boxOne);
		boxH.add(Box.createHorizontalStrut(20));
		boxH.add(boxTwo);
		panel1.add(boxH);
		panel2.add(enterBtn);
		panel2.add(searchBtn);
		panel2.add(updateBtn);
		panel2.add(delBtn);
		panel2.add(listBtn);
		add(panel1,BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setTitle("通讯录");
		setBounds(200, 200, 400, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int num=1;
		String name=nameField.getText();
		String tel=telField.getText();
		String qq=qqField.getText();
		AddressObject addr=new AddressObject(name,tel,qq );
		//file=new File("d://通讯录.txt");		
		if(e.getSource()==enterBtn){   //添加通讯录信息			
			if("".equals(name)||"".equals(tel)){
				nameField.setText("必须输入姓名和电话");
				return;
			}		
			//ReadWriteTools.randomWrite(file, addr); //随机流写
			//ReadWriteTools.dataWrite(file,addr);  //数据流写
			//ReadWriteTools.ObjectWrite(file, addr);  //对象流写
			int rtn=AddressDao.addAddress(addr);  //数据库写
			if(rtn==-1)
				showFile.setText("添加信息不成功");
			else
				showFile.setText("添加信息成功");
			nameField.setText(null);	
			telField.setText(null);
			qqField.setText(null);
		}else if(e.getSource()==listBtn){ //查看所有通讯录信息
			showFile.setText(null);
			//String content=ReadWriteTools.randomRead(file); //随机流读
			//String content=ReadWriteTools.dataRead(file); //数据流读
			//showFile.setText(content);
			
			//List<AddressObject> list=ReadWriteTools.ObjectRead(file); //对象流读									
			List<AddressObject> list=AddressDao.selectAddress(); //数据库读
			for(AddressObject obj:list){
				String s=num+" 姓名："+obj.getName()+" 电话："
			+obj.getTel()+"  QQ:"+obj.getQq()+"\n";
				showFile.append(s);
				num++;
			}					
		}else if(e.getSource()==searchBtn){  //根据姓名搜索通讯录
			if("".equals(name))
				nameField.setText("请输入姓名");
			else{
				List<AddressObject> list=AddressDao.searchAddr(name);
				if(list.size()==0){
					telField.setText("查无信息");
					return;
				}
				for(AddressObject obj:list){
					telField.setText(obj.getTel());
				    qqField.setText(obj.getQq());
				}
			}
		}else if(e.getSource()==delBtn){//根据姓名删除通讯录信息
			if("".equals(name))
				nameField.setText("不能正确删除");
			else{
			    int rtn=AddressDao.delAddress(addr);
			    if(rtn==-1)
					showFile.setText("删除信息不成功");
				else
					showFile.setText("删除信息成功");
			}
			nameField.setText(null);	
			telField.setText(null);
			qqField.setText(null);
		}else if(e.getSource()==updateBtn){//根据姓名修改通讯录信息
			if("".equals(name)||"".equals(tel))
				nameField.setText("不能正确更新");
			else{
				int rtn=AddressDao.updateAddress(addr);
				if(rtn==-1)//这里不应该
					showFile.setText("更新信息不成功");
				else
					showFile.setText("更新信息成功");	
			}
			nameField.setText(null);	
			telField.setText(null);
			qqField.setText(null);
		}
	}
	
}

