package com.zc.week12.util;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
public class ReadWriteTools {
	static RandomAccessFile access;
	static FileChannel channel;
	static FileLock lock;
	//用文件字节流读取文件
	public static String readFromFile1(File file) {
		int b;
		byte ch[] = new byte[25];
		String s;
		String total="";
		try {
			FileInputStream readfile = new FileInputStream(file);			
			while ((b = readfile.read(ch, 0, 25)) != -1) {
				s = new String(ch, 0, b);
				total=total+s;
			}			
			readfile.close();		
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "File read Error");
		}
		return total;	
	}
	//用文件字节流向文件写信息
	public static void writeToDest1(File file,String content){
		byte[] ch = content.getBytes();
		try {
			FileOutputStream writefile = new FileOutputStream(file);		
			writefile.write(ch, 0, ch.length);			
			writefile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	//用文件字符流读取文件
	public static String readFromFile2(File file) {
		int b;
		char ch[] = new char[25];
		String s;
		String total="";
		try {
			FileReader readfile = new FileReader(file);
			while ((b = readfile.read(ch, 0, 25)) != -1) {
				s = new String(ch, 0, b);
				total=total+s;
			}			
			readfile.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "File read Error");
		}
		return total;
	}
	//用文件字符流向文件写信息
	public static void writeToDest2(File file,String content){
		char[] ch = content.toCharArray();
		try {
			FileWriter writefile = new FileWriter(file);
			writefile.write(ch, 0, ch.length);
			writefile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	//用缓冲流读取文件 
	public static String readFromFile3(File file) {
		String s;
		String total="";
		try {
			FileReader readfile = new FileReader(file);
			BufferedReader bReader=new BufferedReader(readfile);
			while ((s = bReader.readLine() )!=null) 
				total=total+s+"\n";			
			bReader.close();
			readfile.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "File read Error");
		}
		return total;
	}
	//用缓冲流向文件写信息
	public static void writeToDest3(File file,String content){
		try {
			FileWriter writefile = new FileWriter(file);
			BufferedWriter bwriter=new BufferedWriter(writefile);
			bwriter.write(content);
			bwriter.flush();
			bwriter.close();
			writefile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static String readWithProgress(File file,Container con){
		byte ch[] = new byte[50];
		String total="";
		try {
			ProgressMonitorInputStream in=new ProgressMonitorInputStream(con, 
					"读取文件...", new FileInputStream(file));
			in.getProgressMonitor();
			while(in.read(ch)!=-1){			
				String s=new String(ch);
				total=total+s;
				Thread.sleep(100);
			}
			in.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File read Error");
		}catch(InterruptedException e1){}
		return total;
	}
	//用随机流读取文件
	public static String randomRead(File file){
		String name;
		int num = 1;
		String total ="";
		try {
			access = new RandomAccessFile(file, "rw");
			channel = access.getChannel();// 信道对象
			lock = channel.tryLock();
			while ((name = access.readUTF()) != null) {
				String s = num + " " + name + access.readUTF() + access.readUTF() + "\n";
				total = total + s;
				num++;
			}
		} catch (Exception e) {
		}
		try {
			lock.release();
			access.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return total;
	}
	//用随机流向文件写信息
	public static void randomWrite(File file, AddressObject addr) {
		try {
			access = new RandomAccessFile(file, "rw");
			channel = access.getChannel();// 信道对象
			lock = channel.tryLock();
			if (file.exists())
				access.seek(file.length());
			access.writeUTF("姓名：" + addr.getName());		
			access.writeUTF("电话：" + addr.getTel());
			access.writeUTF("QQ：" + addr.getQq());
			lock.release();
			access.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	//用数据流读取文件
	public static String dataRead(File file){
		String name;
		int num = 1;
		String total ="";
		FileInputStream in=null;
		DataInputStream input=null;
		try {
			in=new FileInputStream(file);
			input = new DataInputStream(in);
			while ((name = input.readUTF()) != null) {
				String s = num + " " + name + input.readUTF() + input.readUTF() + "\n";
				total = total + s;
				num++;
			}
		} catch (Exception e) {
		}
		try {
			input.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return total;
	}
	//用数据流向文件写信息
	public static void dataWrite(File file, AddressObject addr) {
		FileOutputStream out=null;
		DataOutputStream output=null;
		try {
			out=new FileOutputStream(file,true);
			output=new DataOutputStream(out);
			output.writeUTF("姓名： "+addr.getName());
			output.writeUTF("电话： "+addr.getTel());
			output.writeUTF("QQ： "+addr.getQq());
			output.close();
			out.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//用对象流读取文件
	public static List<AddressObject> ObjectRead(File file){
		AddressObject addr;
		List<AddressObject> list=new ArrayList<AddressObject>();
		FileInputStream in;
		ObjectInputStream objectin;
		try {
			in = new FileInputStream(file);
			objectin=new ObjectInputStream(in);
			while(in.available()>0){
				addr=(AddressObject) objectin.readObject();
				list.add(addr);
			}
			objectin.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//用对象流向文件写信息
	public static void ObjectWrite(File file, AddressObject addr) {
		ObjectOutputStream output=null;
		FileOutputStream out;
		long pos;
		boolean isExist=false;
		if(file.exists())
			isExist=true;	
		try {
			out=new FileOutputStream(file,true);
			output = new ObjectOutputStream(out);
			if(isExist){
				pos=out.getChannel().position()-4;
				out.getChannel().truncate(pos);
			}
			output.writeObject(addr);
			output.flush();
			output.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static List<AddressObject> databaseRead(){
		return AddressDao.selectAddress();				
	}
	public static int databaseWrite(AddressObject addr){
		return AddressDao.addAddress(addr);
	}
}
