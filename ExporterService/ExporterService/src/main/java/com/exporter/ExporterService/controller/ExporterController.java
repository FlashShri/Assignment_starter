package com.exporter.ExporterService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exporter.ExporterService.dto.ExporterDTO;
import com.exporter.ExporterService.entity.Exporter;
import com.exporter.ExporterService.exception.ExporterServiceCustomException;
import com.exporter.ExporterService.service.ExporterService;

@RestController
@RequestMapping("/exporter")
public class ExporterController {

	@Autowired
	private  ExporterService exporterService ;
	
	@PostMapping
	 public ResponseEntity<Long> addExporter(@RequestBody ExporterDTO expdto) {
        try {
        	//System.out.println("in controller");
            long expId = exporterService.addExporter(expdto);
            return new ResponseEntity<>(expId, HttpStatus.CREATED);
        } catch (ExporterServiceCustomException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
	
	@GetMapping
	public ResponseEntity<List<Exporter>> getAllExporters(){
		 List<Exporter> exporters = exporterService.getAllExporters();
		
		  if (exporters.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(exporters, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateExporter(@PathVariable Long id , @RequestBody ExporterDTO updateinfo){
		  exporterService.updateExporterData(id, updateinfo);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExporter(@PathVariable Long id){
		exporterService.deleteExporter(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}
