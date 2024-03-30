package com.policy.PolicyService.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.policy.PolicyService.Repository.PolicyRepo;
import com.policy.PolicyService.entity.Policy;

import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ReportService {
	
	@Autowired
	private PolicyRepo policyRepo;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		List<Policy> list = policyRepo.findAll();
		//Load File and Compile it
		File file = ResourceUtils.getFile("classpath:policies.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created By", "Munot Gadale");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanCollectionDataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,"D:\\Reports\\JasperReports"+"\\policies.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\Reports\\JasperReports"+"\\policies.pdf");
		}
		return "Report Generated, Check JasperReports Folder ";
	}
}
