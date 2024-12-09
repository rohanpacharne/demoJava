package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMMON_MASTER_VALUES")
public class CommonMasterValues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MASTER_VALUE_ID")
	private Long masterValueId;
	
	@Column(name = "MASTER_ID")
	private Long masterId;
	
	@Column(name = "VALUE_CODE")
	private String valueCode;
	
	@Column(name = "VALUE_NAME")
	private String valueName;

	public CommonMasterValues() {
		super();
	}

	public CommonMasterValues(Long masterValueId, Long masterId, String valueCode, String valueName) {
		super();
		this.masterValueId = masterValueId;
		this.masterId = masterId;
		this.valueCode = valueCode;
		this.valueName = valueName;
	}

	public Long getMasterValueId() {
		return masterValueId;
	}

	public void setMasterValueId(Long masterValueId) {
		this.masterValueId = masterValueId;
	}

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	@Override
	public String toString() {
		return "CommonMasterValues [masterValueId=" + masterValueId + ", masterId=" + masterId + ", valueCode="
				+ valueCode + ", valueName=" + valueName + "]";
	}
	
	
	

}
