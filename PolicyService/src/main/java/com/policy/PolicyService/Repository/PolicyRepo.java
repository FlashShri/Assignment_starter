package com.policy.PolicyService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.PolicyService.entity.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Integer> {

	Optional<Policy> findByPolicyName(String policyName);

}
