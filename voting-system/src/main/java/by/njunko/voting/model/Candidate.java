package by.njunko.voting.model;

public class Candidate{
	
	private Integer id;
	
	private String fullName;
	
	private Integer counterVotes;

	public Candidate(Integer id, String fullName){

		this.id = id;
		this.fullName = fullName;
	}

	public Candidate(Integer id, String fullName, Integer counterVotes){
		
		this.id = id;
		this.fullName = fullName;
		this.counterVotes = counterVotes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getCounterVotes() {
		return counterVotes;
	}

	public void setCounterVotes(Integer counterVotes) {
		this.counterVotes = counterVotes;
	}
	
}
