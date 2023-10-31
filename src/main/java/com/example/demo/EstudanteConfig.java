package com.example.demo;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudanteConfig
{
	@Bean
	CommandLineRunner commandLineRunner(EstudanteRepositorio repository) 
	{
		return args -> 
		{
			
		Estudante pedro = new Estudante("Pedro", "pedroroot@teste.com", LocalDate.of(2000, Month.JANUARY, 1));
		
		Estudante joao = new Estudante("Joao", "joao@teste.com", LocalDate.of(2001, Month.DECEMBER, 25));
		
		repository.saveAll(List.of(pedro, joao));
		
		};
	}
}