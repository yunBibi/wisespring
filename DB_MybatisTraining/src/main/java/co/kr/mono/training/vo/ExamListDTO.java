package co.kr.mono.training.vo;

public class ExamListDTO {
	
	private String name;
	private String className;
	private String kor;
	private String eng;
	private String mat;
	
	public ExamListDTO() {
	}

	public ExamListDTO(String name, String className, String kor, String eng, String mat) {
		super();
		this.name = name;
		this.className = className;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	@Override
	public String toString() {
		return "ExamListDTO [name=" + name + ", className=" + className + ", kor=" + kor + ", eng=" + eng + ", mat="
				+ mat + "]";
	}
	
	
}
