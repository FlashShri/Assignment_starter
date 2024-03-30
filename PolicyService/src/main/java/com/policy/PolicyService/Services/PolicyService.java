package com.policy.PolicyService.Services;

import java.util.List;
import java.util.Optional;

import com.policy.PolicyService.entity.Policy;

public interface PolicyService {
	
	int addPolicy(Policy policy);
	
    void deletePolicy(int policyNumber);
    
    Policy updatePolicy(int policyNumber, Policy updatedPolicy);
    
    List<Policy> getAllPolicies();
    
    Optional<Policy> getPolicyByPolicyNumber(int policyNumber);
}
