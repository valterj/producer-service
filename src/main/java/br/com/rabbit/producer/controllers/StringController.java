package br.com.rabbit.producer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbit.producer.services.StringService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/produces")
@RequiredArgsConstructor
public class StringController {

	private final StringService service;

	@GetMapping
	public ResponseEntity<String> produces(@RequestParam String message) {

		service.produce(message);

		return ResponseEntity.ok().body("Enviando mensagem");

	}

}
