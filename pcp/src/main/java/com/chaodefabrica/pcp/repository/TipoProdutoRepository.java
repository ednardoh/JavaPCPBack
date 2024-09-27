package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto,String> {}
