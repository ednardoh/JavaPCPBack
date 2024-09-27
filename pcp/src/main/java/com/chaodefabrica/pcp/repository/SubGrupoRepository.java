package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.SubGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {}

