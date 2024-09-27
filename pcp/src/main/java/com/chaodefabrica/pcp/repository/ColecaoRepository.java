package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.Colecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Long> {}
