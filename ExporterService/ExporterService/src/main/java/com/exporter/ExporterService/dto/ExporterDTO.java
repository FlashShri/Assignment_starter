package com.exporter.ExporterService.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExporterDTO {
	
	private String name ;
	
	private String address;
	
	private String email;
	
	private String type;
	
	private String country;
	
	private boolean active ;
	
}
