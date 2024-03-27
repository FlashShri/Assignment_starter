package com.exporter.ExporterService.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exporter" )
@Data
@Setter
@Getter
@NoArgsConstructor
public class Exporter {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String name ;
	
	private String address;
	
	private String email;
	
	private String type;
	
	private String country;
	
	private boolean active ;
	
	private LocalDateTime createdAt ;
	
	private LocalDateTime updataedAt ;
	
}
