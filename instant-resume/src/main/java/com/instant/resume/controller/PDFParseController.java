package com.instant.resume.controller;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

@Component
public class PDFParseController {

	public String parse() throws IOException {
		
		File f = new File("N:\\WorkSpace\\InstantResume\\instant-resume\\src\\main\\resources\\naveenkumarresume.pdf");
		
		PDFParser parser;
		PDDocument pdDoc = null ;
		try {
			parser = new PDFParser(new RandomAccessFile(f, "r"));
			parser.parse();
			COSDocument cosDoc = parser.getDocument();
			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			return pdfStripper.getText(pdDoc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			pdDoc.close();
		}
		return "Parse Failed";
		

	}

}
