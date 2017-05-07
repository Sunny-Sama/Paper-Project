package service.fdu_ac_service.model;

public class Rule {
	private long ruleId;
	private long userId;
	private String userName;
	public Rule(){}
	
	public Rule (long ruleId, long userId, String userName){
		this.setRuleId(ruleId);
		this.setUserId(userId);
		this.setUserName(userName);
	}

	public long getRuleId() {
		return ruleId;
	}

	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
