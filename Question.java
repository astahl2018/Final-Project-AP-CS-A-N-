//Andrew and Nico

public abstract class Question {
	private String question;
	private String answer;
	
	public Question(String q , String a){
		question = q;
		answer = a;
	}
	
	public String getQuestion(){
		return this.question;
	}
	
	public String getAnswer(){
		return this.answer;
	}
	
	public abstract boolean checkResponse(String response);
}
