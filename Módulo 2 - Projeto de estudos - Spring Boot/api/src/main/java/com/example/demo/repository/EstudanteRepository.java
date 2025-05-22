package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

	// QUERY NATIVA
	
	@Query(value = "SELECT e.* FROM api.estudante e " + 
	               " left join api.avaliacao_curso ac ON ac.estudante_id = e.id " + 
			       " where ac.estudante_id is null", nativeQuery = true)
	List<Estudante> findByAvaliacaoCursosEstudantesIsNullNativeQuery();
	
	
	// QUERY JPQL
	@Query(value = "SELECT e FROM Estudante e LEFT JOIN e.avaliacaoCursos ac WHERE ac IS NULL")
	List<Estudante> findByAvaliacaoCursosEstudantesIsNullJPQL();

	
		
	
	// QUERY CRIADA PELO SPRING AUTOMATICAMENTE A PARTIR DO NOME
	List<Estudante> findByAvaliacaoCursosEstudanteIsNull();
	

}
