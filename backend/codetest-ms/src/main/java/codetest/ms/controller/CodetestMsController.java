package codetest.ms.controller;

import org.jetbrains.teamcity.rest.TeamCityInstanceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CodetestMsController {
    @Value("${message}")
	private String message;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> get() {
		try {
            TeamCityInstanceFactory.INSTANCE.getClass();
			return ResponseEntity.ok(message);
		} catch (Exception e) {
			log.error("Ocurrio un error en get de message", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
