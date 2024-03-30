package com.exporter.ExporterService.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exporter.ExporterService.dto.ExporterDTO;
import com.exporter.ExporterService.entity.Exporter;
import com.exporter.ExporterService.exception.ExporterServiceCustomException;
import com.exporter.ExporterService.repository.ExporterRepository;

@Service
public class ExporterServiceImpl implements ExporterService{

	@Autowired
	private ModelMapper mapper ;
	@Autowired
	private ExporterRepository repository;
	
	@Override
	public long addExporter(ExporterDTO exporterdto) {
		
		 Exporter newExporter = mapper.map(exporterdto , Exporter.class);
		
		 Optional<Exporter> expfromdb = repository.findByEmail(exporterdto.getEmail());
		 
		 if(expfromdb.isPresent()){
			 throw new ExporterServiceCustomException("Exporter is already present", "DUPLICATE_EXPORTER");
		 }else {
			 newExporter.setCreatedAt(LocalDateTime.now());
			return repository.save(newExporter).getId();
		 }
		
	}

	@Override
	public List<Exporter> getAllExporters() {
		
			return repository.findAll();
		
	}

	@Override
	public Exporter getExporterById(long exporterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateExporterData(long exporterId, ExporterDTO updatedexporter) {
		
		  
		 if(repository.existsById(exporterId)) {
			 Optional<Exporter> exporter = repository.findById(exporterId);
			 
			 
			 Exporter upexpt = mapper.map(updatedexporter, Exporter.class);
			 upexpt.setUpdataedAt(LocalDateTime.now());
			 upexpt.setCreatedAt(exporter.get().getCreatedAt());
			 upexpt.setId(exporterId);
			 repository.save(upexpt);
		 }	 
	}

	@Override
	public void deleteExporter(long exporterId) {
		
		repository.deleteById(exporterId);
	}

}

