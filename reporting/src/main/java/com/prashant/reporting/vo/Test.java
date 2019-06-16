package com.prashant.reporting.vo;

public class Test {
	private int id;
	private String name;
	private int stepsPassed;
	private int stepsFailed;
	private int stepsWithWarning;
	private int slNo;
	private String overAllStatus;
	private String executionTime;
	
	public Test() {
		
	}
	
	public Test(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStepsPassed() {
		return stepsPassed;
	}

	public void setStepsPassed(int stepsPassed) {
		this.stepsPassed = stepsPassed;
	}

	public int getStepsFailed() {
		return stepsFailed;
	}

	public void setStepsFailed(int stepsFailed) {
		this.stepsFailed = stepsFailed;
	}

	public int getStepsWithWarning() {
		return stepsWithWarning;
	}

	public void setStepsWithWarning(int stepsWithWarning) {
		this.stepsWithWarning = stepsWithWarning;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getOverAllStatus() {
		return overAllStatus;
	}

	public void setOverAllStatus(String overAllStatus) {
		this.overAllStatus = overAllStatus;
	}

	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", stepsPassed=" + stepsPassed + ", stepsFailed=" + stepsFailed
				+ ", stepsWithWarning=" + stepsWithWarning + "]";
	}
}
