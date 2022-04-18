package com.foreheed.ozedemo.rest.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreheed.ozedemo.rest.domain.DeletePatientsRequest;
import com.foreheed.ozedemo.rest.domain.GetAllPatientsResponse;
import com.foreheed.ozedemo.rest.mappers.PatientMapper;
import com.foreheed.ozedemo.service.PatientsService;

@RestController
@RequestMapping(path = "/patients")
public class PatientsController {
	
	@Autowired
	private PatientsService patientsService;
	
	@Autowired
	private PatientMapper patientMapper;
	
	@GetMapping
	public GetAllPatientsResponse getPatients() {
		GetAllPatientsResponse response = new GetAllPatientsResponse();
		response.setPatients(patientsService.getAll().stream()
				.map(patient -> patientMapper.fromPatientToPatientInformation(patient)).collect(Collectors.toList()));
		return response;
	}
	
	@GetMapping("/{id}/csv")
	public ResponseEntity<Resource> getPatientProfileAsCsv(@PathVariable Integer id) throws IOException {
		byte[] content = patientsService.getPatientRecordAsCsv(id);
 	    ByteArrayResource resource = new ByteArrayResource(content);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=patient-profile-" + id + ".csv");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
 	    
	    return ResponseEntity.ok()
	            .headers(header)
	            .contentLength(content.length)
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	
	@DeleteMapping
	public void deletePatients(@RequestBody DeletePatientsRequest request) {
		patientsService.removePatients(request.getBefore(), request.getAfter());
	}
	
}
