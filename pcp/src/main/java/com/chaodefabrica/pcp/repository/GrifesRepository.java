package com.chaodefabrica.pcp.repository;

import com.chaodefabrica.pcp.model.Grifes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrifesRepository extends JpaRepository<Grifes, Long> {}
