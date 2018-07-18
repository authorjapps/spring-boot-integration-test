package com.springboot.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    private static Logger LOGGER = LogManager.getLogger(FileUploadController.class);

    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile fileTOBeUploaded)
    {
        LOGGER.info("\n File Upload process started !! File Name :- " + fileTOBeUploaded.getOriginalFilename());
        try {
            String fileContent = new String(fileTOBeUploaded.getBytes());
            LOGGER.info("file cotent \n" +fileContent);
        }catch (Exception ex){
            LOGGER.error("Exception occured while access file content !!");
            return new ResponseEntity<String>("Exception occured file reading file !!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("File uploaded successfully !!", HttpStatus.OK);
    }
}
