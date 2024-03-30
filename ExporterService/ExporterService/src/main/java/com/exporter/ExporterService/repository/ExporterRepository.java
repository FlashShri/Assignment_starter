package com.exporter.ExporterService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exporter.ExporterService.entity.Exporter;

public interface ExporterRepository  extends JpaRepository<Exporter, Long>{

	public Optional<Exporter> findByEmail(String email);

}
