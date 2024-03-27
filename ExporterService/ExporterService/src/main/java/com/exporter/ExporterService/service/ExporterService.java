package com.exporter.ExporterService.service;

import java.util.List;

import com.exporter.ExporterService.dto.ExporterDTO;
import com.exporter.ExporterService.entity.Exporter;

public interface ExporterService {
	
	long addExporter(ExporterDTO exporterdto);
	
	List<Exporter> getAllExporters();
	
	Exporter getExporterById(long exporterId);
	
	void updateExporterData(long exporterId , ExporterDTO updatedexporter);
	
	void deleteExporter(long productId);
	 
}
