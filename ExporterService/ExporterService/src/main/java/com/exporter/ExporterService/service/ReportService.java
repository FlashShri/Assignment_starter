package com.exporter.ExporterService.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.exporter.ExporterService.entity.Exporter;
import com.exporter.ExporterService.repository.ExporterRepository;

import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine .data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ReportService {
	@Autowired
	private ExporterRepository exporterRepo;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		// get the data from DB
		List<Exporter> list = exporterRepo.findAll();
		
		//load a file and complie it
		File file = ResourceUtils.getFile("classpath:expo.jrxml");
		JasperReport  jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		
		Map<String , Object> parameters = new HashMap<>();
		parameters.put("Created By", "Shri");
		
		JasperPrint jsPrinter = JasperFillManager.fillReport(jasperReport, parameters,  beanCollectionDataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jsPrinter,"C:\\ECGC_starter\\js_reports"+"\\exporters.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jsPrinter,"C:\\ECGC_starter\\js_reports"+"\\exporters.pdf");
		}
		
		return "Report Generated, Check JasperReports Folder ";
	}
}
