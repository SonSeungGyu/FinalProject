package com.example.demo.board.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Component
public class FileUtil {

	@Value("${filepath}")
	String filepath;
	
	public String fileUpload(MultipartFile multipartFile) {
		Path copyOfLocation = null;
		
		if(multipartFile.isEmpty()) {
			return null;
		}
		try {
			copyOfLocation = Paths.get(filepath + File.separator + 
					StringUtils.cleanPath(multipartFile.getOriginalFilename()));
				Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		return multipartFile.getOriginalFilename();
	}
	
	
}
