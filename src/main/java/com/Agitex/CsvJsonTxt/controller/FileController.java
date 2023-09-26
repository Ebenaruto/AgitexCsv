package com.Agitex.CsvJsonTxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Agitex.CsvJsonTxt.response.ResponseMessage;
import com.Agitex.CsvJsonTxt.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	private FileService Service;
	
	//premièrement, uploader le fichier
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		//SI fichier reconnu, proceder a l'extraction puis la sauvegarde des données
		if(Service.hasCsvFormat(file)) {
			Service.processAndSaveData(file);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Fichier Importer avec succès" + file.getOriginalFilename()));
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Importer un fichier CSV SVP"));
	}

}
