package com.exporter.ExporterService.exception;

import lombok.Data;

@Data
public class ExporterServiceCustomException extends RuntimeException {
	
	private String errorcode ;
	
	public ExporterServiceCustomException(String msg , String errorcode ) {
		super( msg );
		this.errorcode= errorcode ;
	}
}
