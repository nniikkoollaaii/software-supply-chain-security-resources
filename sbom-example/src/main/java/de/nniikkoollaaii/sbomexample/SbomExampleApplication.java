package de.nniikkoollaaii.sbomexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbomExampleApplication {
    
    private static final Logger logger = LogManager.getLogger(SbomExampleApplication.class);

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(SbomExampleApplication.class, args);
        logger.error("Vulnerable log4j version");
	}

}
