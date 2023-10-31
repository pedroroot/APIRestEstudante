package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/estudante")
public class EstudanteControlador
{
	
	private final EstudanteService estudanteService;
	
	@Autowired
	public EstudanteControlador(EstudanteService estudanteService) 
	{
		this.estudanteService = estudanteService;		
	}
	
	@GetMapping
	public List<Estudante> getEstudante()
	{		
		return estudanteService.getEstudante();				
	}
	
	@PostMapping
	public void registrarEstudante(@RequestBody Estudante estudante)
	{
		estudanteService.addNovoEstudante(estudante);
		
	}
	
	@DeleteMapping(path = "{estudanteId}")
	public void deletarEstudante(@PathVariable("estudanteId")Long estudanteId) 
	{
		estudanteService.deletarEstudante(estudanteId);
		
	}
	
	@PostMapping(path = "{estudanteId}")
	public void atualizarEstudante(@PathVariable("estudanteId")Long estudanteId, @RequestParam(required = false) String nome, @RequestParam(required = false) String email)
	{
		estudanteService.atualizarEstudante(estudanteId, nome, email);
	}
	
}
