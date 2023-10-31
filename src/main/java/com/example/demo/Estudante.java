package com.example.demo;
import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table
public class Estudante
{
	@Id
	@SequenceGenerator(name = "estudante_sequence", sequenceName = "estudante_sequence", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudante_sequence")
	
	private Long id;
	private String nome;
	private String email;	
	private LocalDate dataNascimento;
	@Transient
	private Integer idade;
				
	public Estudante()
	{
		
	}
	
	public Estudante(String nome, String email, Long id, LocalDate dataNascimento) 
	{		
		this.nome = nome;
		this.email = email;
		this.id = id;
		this.dataNascimento = dataNascimento;	
	}
	
	public Estudante(String nome, String email, LocalDate dataNascimento)
	{	
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getAge() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}
	
	public void setAge(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Estudante{" + 
				" nome='" + nome + '\'' +
				", email= '" + email + '\''
				+ ", id= " + id + 
				", dataNascimento= " + dataNascimento
				+ ", idade= " + idade + '}';
	}
	
}
