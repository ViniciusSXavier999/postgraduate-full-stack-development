package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

// Estamos realizando uma consulta personalizada que faz uma busca pelo nome do curso no request.
  Optional<Curso> findByNome(@Param("nomeCurso") String nomeCurso);
}