package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.GradeLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GradeListaRepository extends JpaRepository<GradeLista, Long> {
    @Query("from GradeLista where gradeEntity.codigo = ?1")
    List<GradeLista> FindByCodigo(Long id);
}