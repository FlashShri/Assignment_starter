package com.policy.PolicyService.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy.PolicyService.DTO.Status;
import com.policy.PolicyService.Exception.PolicyServiceException;
import com.policy.PolicyService.Services.PolicyService;
import com.policy.PolicyService.Services.ReportService;
import com.policy.PolicyService.entity.Policy;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/policies")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/add-policy")
	public ResponseEntity<Status> addPolicy(@RequestBody Policy policy){
		try {
			int id = policyService.addPolicy(policy);
			Status status = new Status();
			status.setId(id);
			status.setStatus(true);
			status.setStatusMessage("Policy added Successfully");
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		} catch (PolicyServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(status,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/get-all-policies")
	public List<Policy> getPolicies(){
		return policyService.getAllPolicies();
	}
	
	@GetMapping("/get-policy-by-id/{id}")
	public Policy getPolicyById(@PathVariable int id) {
		Policy policy = policyService.getPolicyByPolicyNumber(id).get();
		return policy;
	}
	
	@GetMapping("/get-policies-file/{reportFormat}")
	public String getReport(@PathVariable String reportFormat) throws FileNotFoundException, JRException {
		return reportService.exportReport(reportFormat);
	}
}
