package com.dyheart.cointracker.dto;

public class CoinDTO {
	
	private Long coinId; 
	private String coinName; 
	private String coinAbbreviation;
	public Long getCoinId() {
		return coinId;
	}
	public void setCoinId(Long coinId) {
		this.coinId = coinId;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public String getCoinAbbreviation() {
		return coinAbbreviation;
	}
	public void setCoinAbbreviation(String coinAbbreviation) {
		this.coinAbbreviation = coinAbbreviation;
	} 
	
	
}
