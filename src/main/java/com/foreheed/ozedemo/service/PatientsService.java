package com.foreheed.ozedemo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVPrinter;

import com.foreheed.ozedemo.persistence.entities.Patient;
import com.foreheed.ozedemo.persistence.repositories.PatientsRepository;
import com.foreheed.ozedemo.service.exception.NotFoundBusinessException;

public class PatientsService {

	private static enum CsvHeaderEnum {
		Id, Name, Age, LastVisitDate
	}

	private static final int YEARS_BEHIND = 2;

	private final PatientsRepository patientsRepository;

	public PatientsService(PatientsRepository patientsRepository) {
		this.patientsRepository = patientsRepository;
	}

	public List<Patient> getAll() {
		return patientsRepository.findByLastVisitDateAfter(ZonedDateTime.now().minusYears(YEARS_BEHIND));
	}

	public byte[] getPatientRecordAsCsv(Integer patientId) throws IOException {
		Patient patient = patientsRepository.findById(patientId)
				.orElseThrow(() -> new NotFoundBusinessException("patient not found"));
		Builder builder = Builder.create().setHeader(CsvHeaderEnum.class);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), builder.build());) {
			List<String> data = Arrays.asList(String.valueOf(patient.getId()), patient.getName(),
					String.valueOf(patient.getAge()), patient.getLastVisitDate().toString());
			csvPrinter.printRecord(data);
			csvPrinter.flush();
			return out.toByteArray();
		}
	}
	
	@Transactional
	public void removePatients(ZonedDateTime before, ZonedDateTime after) {
		patientsRepository.removeByLastVisitDateBetween(before, after);
	}

}
