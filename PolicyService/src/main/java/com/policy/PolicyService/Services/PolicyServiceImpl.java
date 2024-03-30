package com.policy.PolicyService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.PolicyService.Exception.PolicyServiceException;
import com.policy.PolicyService.Repository.PolicyRepo;
import com.policy.PolicyService.entity.Policy;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepo policyRepository;
	
	@Override
	public int addPolicy(Policy policy) {
	    Optional<Policy> existingPolicy = policyRepository.findByPolicyName(policy.getPolicyName());
	    if (existingPolicy.isPresent()) {
	        throw new PolicyServiceException("Policy with name " + policy.getPolicyName() + " already exists");
	    }
	    else {
	    Policy newPolicy = policyRepository.save(policy);
	    
	    return newPolicy.getPolicyNumber();
	    }
	}


    @Override
    public void deletePolicy(int policyNumber) {
    	policyRepository.deleteById(policyNumber);
    }

    @Override
    public Policy updatePolicy(int policyNumber, Policy updatedPolicy) {
        Optional<Policy> optionalPolicy = policyRepository.findById(policyNumber);
        if (optionalPolicy.isPresent()) {
            Policy existingPolicy = optionalPolicy.get();
            existingPolicy.setPolicyName(updatedPolicy.getPolicyName());
            existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
            existingPolicy.setMaxNoOfYears(updatedPolicy.getMaxNoOfYears());
            existingPolicy.setPremiumRate(updatedPolicy.getPremiumRate());
            existingPolicy.setMaxSumAssured(updatedPolicy.getMaxSumAssured());
            return policyRepository.save(existingPolicy);
        } else {
            throw new PolicyServiceException("Policy With This Id "+policyNumber+" Not Found");
        }
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Optional<Policy> getPolicyByPolicyNumber(int policyNumber) {
        return policyRepository.findById(policyNumber);
    }
	
}
