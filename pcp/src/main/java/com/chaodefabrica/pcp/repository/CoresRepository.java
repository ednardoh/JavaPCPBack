package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.Cores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoresRepository extends JpaRepository<Cores, Long> {}
