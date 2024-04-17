package dto;

public class QnADTO {
	private int QnASeq;
	private int furnitureSeq;
	private String question;
	private String answer;
	private int state;
	private String answerDate;
	private String regDate;
	private String name;
	private String password;
	
	
	public QnADTO(int qnASeq, int furnitureSeq, String question, String answer, int state, String answerDate,
			String regDate, String name, String password) {
		super();
		QnASeq = qnASeq;
		this.furnitureSeq = furnitureSeq;
		this.question = question;
		this.answer = answer;
		this.state = state;
		this.answerDate = answerDate;
		this.regDate = regDate;
		this.name = name;
		this.password = password;
	}


	public int getQnASeq() {
		return QnASeq;
	}


	public void setQnASeq(int qnASeq) {
		QnASeq = qnASeq;
	}


	public int getFurnitureSeq() {
		return furnitureSeq;
	}


	public void setFurnitureSeq(int furnitureSeq) {
		this.furnitureSeq = furnitureSeq;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getAnswerDate() {
		return answerDate;
	}


	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
