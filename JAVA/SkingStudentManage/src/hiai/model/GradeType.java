package hiai.model;
/**
 * �༶����ʵ��
 *
 */
public class GradeType {
	
	private int id;//���
	private String gradeXue;//ѧԺ����
	private String gradeName;//�༶����
	private String gradeDesc;//�༶��ע
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGradeXue() {
		return gradeXue;
	}
	public void setGradeXue(String gradeXue) {
		this.gradeXue = gradeXue;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeDesc() {
		return gradeDesc;
	}
	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}
	
	public GradeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeType(String gradeXue, String gradeName, String gradeDesc) {
		super();
		this.gradeXue = gradeXue;
		this.gradeName = gradeName;
		this.gradeDesc = gradeDesc;
	}
	public GradeType(int id, String gradeXue, String gradeName, String gradeDesc) {
		super();
		this.id = id;
		this.gradeXue = gradeXue;
		this.gradeName = gradeName;
		this.gradeDesc = gradeDesc;
	}
	
	public String toString(){
		return gradeName;
	}
	
}
