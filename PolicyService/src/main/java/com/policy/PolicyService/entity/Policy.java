package com.policy.PolicyService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_tbl")
public class Policy {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "policy_number")
	    private int policyNumber;
	 
	    @Column(name = "policy_name")
	    private String policyName;

	    @Column(name = "policy_type")
	    private String policyType;

	    @Column(name = "max_no_of_years")
	    private int maxNoOfYears;

	    @Column(name = "premium_rate")
	    private double premiumRate;

	    @Column(name = "max_sum_assured")
	    private double maxSumAssured;

		public int getPolicyNumber() {
			return policyNumber;
		}

		public void setPolicyNumber(int policyNumber) {
			this.policyNumber = policyNumber;
		}

		public String getPolicyName() {
			return policyName;
		}

		public void setPolicyName(String policyName) {
			this.policyName = policyName;
		}

		public String getPolicyType() {
			return policyType;
		}

		public void setPolicyType(String policyType) {
			this.policyType = policyType;
		}

		public int getMaxNoOfYears() {
			return maxNoOfYears;
		}

		public void setMaxNoOfYears(int maxNoOfYears) {
			this.maxNoOfYears = maxNoOfYears;
		}

		public double getPremiumRate() {
			return premiumRate;
		}

		public void setPremiumRate(double premiumRate) {
			this.premiumRate = premiumRate;
		}

		public double getMaxSumAssured() {
			return maxSumAssured;
		}

		public void setMaxSumAssured(double maxSumAssured) {
			this.maxSumAssured = maxSumAssured;
		}
	    
	    
}
