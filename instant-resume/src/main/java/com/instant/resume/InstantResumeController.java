package com.instant.resume;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.instant.resume.controller.*;

@RestController
public class InstantResumeController {
	
	@Autowired
	PDFParseController PDFParseController;
	
	private String message = "Welcome to Instant Resume";

	@GetMapping("getWelcomeMsg")
	public String welcome(Map<String, Object> model) throws IOException {
		model.put("message", this.message);
		System.out.println("Requested :");
		return PDFParseController.parse();
		
	}

}
