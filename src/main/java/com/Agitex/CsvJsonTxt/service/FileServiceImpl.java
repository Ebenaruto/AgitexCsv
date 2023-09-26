package com.Agitex.CsvJsonTxt.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Agitex.CsvJsonTxt.entity.Collab;
import com.Agitex.CsvJsonTxt.repository.CollabRepository;

@Service 
public class FileServiceImpl implements FileService {

	@Autowired
	private CollabRepository respository;
	
	@Override
	public boolean hasCsvFormat(MultipartFile file) {
		String type="text/csv";
		if(!type.equals(file.getContentType()))
			return false;
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file) {
		try {
			List<Collab> collabs=csvToCollabs(file.getInputStream());
			respository.saveAll(collabs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private List<Collab> csvToCollabs(InputStream inputStream) {
		try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader, 
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
				){
			List<Collab> collabs = new ArrayList<Collab>();
			List<CSVRecord> records = csvParser.getRecords();
			for(CSVRecord csvRecord: records) {
				Collab collab = new Collab(Long.parseLong(csvRecord.get("Id")), csvRecord.get("nom"), 
                        csvRecord.get("prenom"), Integer.parseInt(csvRecord.get("age")), 
                        csvRecord.get("profession"), Double.parseDouble(csvRecord.get("revenu")));
				collabs.add(collab);
			}
			return collabs;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}

}
