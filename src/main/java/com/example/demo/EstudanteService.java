package com.example.demo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudanteService
{
	private final EstudanteRepositorio estudanteRepositorio;

	@Autowired
	public EstudanteService(EstudanteRepositorio estudanteRepositorio)
	{
		this.estudanteRepositorio = estudanteRepositorio;
	}
	
	public List<Estudante> getEstudante()
	{
		return estudanteRepositorio.findAll();
	}	
	
	public void addNovoEstudante(Estudante estudante) 
	{
		Optional<Estudante> estudanteEmail = estudanteRepositorio.findStudentByEmail(estudante.getEmail());
		
		if(estudanteEmail.isPresent()) 
		{
			throw new IllegalStateException("email recebido");
		}
		
		estudanteRepositorio.save(estudante);
		
		System.out.println(estudante);
	}

	public void deletarEstudante(Long estudanteId)
	{
		boolean exists = estudanteRepositorio.existsById(estudanteId);
		
		if(!exists) 
		{
			throw new IllegalStateException("estudante com id" + estudanteId + "não existe");
			
		}
		
		estudanteRepositorio.deleteById(estudanteId);
	}

	@Transactional
	public void atualizarEstudante(Long estudanteId, String nome, String email)
	{
		Estudante estudante = estudanteRepositorio.findById(estudanteId).orElseThrow(() -> new IllegalStateException("estudante com id" + estudanteId + "não existe"));
		
		
	}

	













}

