package com.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class FileUploadController {
    private static Logger LOGGER = LogManager.getLogger(FileUploadController.class);

    public static final String UPLOADED_FOLDER = "target/uploaded_files";
    public static final String PREFIX = "/new_";

    @PostMapping("/api/abc-bank/upload/filesAndRequestParams")
    public ResponseEntity<Map<String, String>> fileUploadAndBody(
            @RequestParam("file") MultipartFile fileTOBeUploaded,
            @RequestParam("file2") MultipartFile fileTOBeUploaded2,
            @RequestHeader HttpHeaders headers,
            @RequestParam("trainList") String trainList,
            @RequestParam("id") String id
    ) {
        LOGGER.info("\n File1 Upload process started !! File Name :- " + fileTOBeUploaded.getOriginalFilename());

        Path uploadedPath;

        HashMap<String, String> failureMsg = new HashMap<String, String>() {{
            put("message", "Exception occurred while reading the file !");
        }};

        // -=-=-=-=-=-=-
        // Upload file1
        // -=-=-=-=-=-=-
        try {
            byte[] bytes = fileTOBeUploaded.getBytes();
            uploadedPath = Paths.get(getAbsPath(UPLOADED_FOLDER) + PREFIX + fileTOBeUploaded.getOriginalFilename());
            Files.write(uploadedPath, bytes);
            LOGGER.info("  Success: File2 uploaded to >> " + uploadedPath.toString());

        } catch (Exception ex) {
            LOGGER.error("Exception occured while access file1 content !!");
            return new ResponseEntity<>(failureMsg, INTERNAL_SERVER_ERROR);
        }

        // -=-=-=-=-=-=-
        // Upload file2
        // -=-=-=-=-=-=-
        try {
            //String fileContent = new String(fileTOBeUploaded.getBytes());
            //LOGGER.info("file cotent \n" + fileContent);

            byte[] bytes = fileTOBeUploaded2.getBytes();
            uploadedPath = Paths.get(getAbsPath(UPLOADED_FOLDER) + PREFIX + fileTOBeUploaded2.getOriginalFilename());
            Files.write(uploadedPath, bytes);
            LOGGER.info(" Success: File uploaded to >> " + uploadedPath.toString());

        } catch (Exception ex) {
            LOGGER.error("Exception occured while access file2 content !!");
            return new ResponseEntity<>(failureMsg, INTERNAL_SERVER_ERROR);
        }

        System.out.println("headers >> " + headers);
        System.out.println("trainList >> " + trainList);
        System.out.println("id >> " + id);

        HashMap<String, String> successMeg = new HashMap<String, String>() {{
            put("message", "File uploaded successfully ! Check server path- "
            );
        }};
        return new ResponseEntity<>(successMeg, OK);
    }

    @PostMapping("/api/abc-bank/upload")
    public ResponseEntity<Map<String, String>> fileUpload(@RequestParam("file") MultipartFile fileTOBeUploaded,
                                                          @RequestHeader HttpHeaders headers) {
        LOGGER.info("\n File Upload process started !! File Name :- " + fileTOBeUploaded.getOriginalFilename());
        System.out.println("headers >> " + headers);

        Path uploadedPath;

        try {
            //String fileContent = new String(fileTOBeUploaded.getBytes());
            //LOGGER.info("file cotent \n" + fileContent);

            byte[] bytes = fileTOBeUploaded.getBytes();
            uploadedPath = Paths.get(getAbsPath(UPLOADED_FOLDER) + PREFIX + fileTOBeUploaded.getOriginalFilename());
            Files.write(uploadedPath, bytes);
            LOGGER.info("Success: File uploaded to >> " + uploadedPath.toString());

        } catch (Exception ex) {
            LOGGER.error("Exception occured while access file content !!");
            HashMap<String, String> failureMsg = new HashMap<String, String>() {{
                put("message", "Exception occurred while reading the file !");
            }};

            return new ResponseEntity<>(failureMsg, INTERNAL_SERVER_ERROR);
        }

        HashMap<String, String> successMsg = new HashMap<String, String>() {{
            put("message", "File uploaded successfully ! Check server path- " + uploadedPath.toString());
            put("metaData", headers!=null ? headers.toString() : "Not set");
        }};

        return new ResponseEntity<>(successMsg, OK);
    }

    private String getAbsPath(String uploadFolder) {
        ClassLoader classLoader = FileUploadController.class.getClassLoader();
        URL resource = classLoader.getResource(uploadFolder);
        File checkFolder = new File(uploadFolder);
        if (resource == null) {
            checkFolder.mkdirs();
            return checkFolder.getAbsolutePath();
        }
        return resource.getPath();
    }

}
