package com.ambev.revenda.repository;

import com.ambev.revenda.model.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda, Long> {
    boolean existsByCnpj(String cnpj);
}
