package br.com.alura.api.languages;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// O Spring implementa p/ conectar ao MongoBD
public interface LanguageRepository extends MongoRepository<Language, String> {	
	List<Language>  findByOrderByRanking();
	
}
