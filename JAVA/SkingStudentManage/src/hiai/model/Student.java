package hiai.model;
/**
 * ѧ��ģ��
 */
public class Student {
	private int id;//ѧ�����
	private String stuName;//ѧ������
	private String stuXue;//ѧ��ѧԺ
	private String stuIdcard;//ѧ��ѧ��
	private String stuSex;//ѧ���Ա�
	private String stuAge;//ѧ������
	private String stuAddress;//ѧ����ַ
	private String stuPhone;//��ϵ��ʽ
	private Integer stuTypeid;//ѧ���༶���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuXue() {
		return stuXue;
	}
	public void setStuXue(String stuXue) {
		this.stuXue = stuXue;
	}
	public String getStuIdcard() {
		return stuIdcard;
	}
	public void setStuIdcard(String stuIdcard) {
		this.stuIdcard = stuIdcard;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public Integer getStuTypeid() {
		return stuTypeid;
	}
	public void setStuTypeid(Integer stuTypeid) {
		this.stuTypeid = stuTypeid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String stuName, String stuXue, String stuIdcard, String stuSex, String stuAge, String stuAddress,
			String stuPhone, Integer stuTypeid) {
		super();
		this.stuName = stuName;
		this.stuXue = stuXue;
		this.stuIdcard = stuIdcard;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuAddress = stuAddress;
		this.stuPhone = stuPhone;
		this.stuTypeid = stuTypeid;
	}
	
	
}