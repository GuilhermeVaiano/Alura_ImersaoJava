package br.com.alura.api.languages;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LanguageController {
	
	@Autowired
	private LanguageRepository repositorio;
	
	@GetMapping("/languages")
	public List<Language> getLanguages() {
		List<Language> languages = repositorio.findByOrderByRanking();
		return languages;
	}
	
	
	@PostMapping("/languages")
	public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
		Language sLanguage = repositorio.save(language);
		return new ResponseEntity<>(sLanguage, HttpStatus.CREATED);
	}
	
	@GetMapping("/languages/{id}")
	public Language getLangById(@PathVariable String id) {
		return repositorio.findById(id)
			   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	
	@PutMapping("/languages/{id}")
	public Language updateLanguage(@PathVariable String id, @RequestBody Language language) {
		if(!repositorio.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		language.setId(id);
		Language sLanguage = repositorio.save(language);
		return sLanguage;
	}
	
	
	
	@DeleteMapping("/languages/{id}")
	public void deleteLanguage(@PathVariable String id) {
		repositorio.deleteById(id);
	}
	
}
