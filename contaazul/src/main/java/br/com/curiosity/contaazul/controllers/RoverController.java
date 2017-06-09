package br.com.curiosity.contaazul.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curiosity.contaazul.actions.Goto;

@RestController
@RequestMapping("/rest/mars/")
public class RoverController {

	@RequestMapping(method = RequestMethod.POST, value = "{command}")
	public ResponseEntity<String> move(@PathVariable("command") String command) {
		try {
			Goto runTo = new Goto();
			 
			
			return new ResponseEntity<String>(runTo.move(command.toCharArray()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	} 

}
