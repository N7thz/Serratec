package br.com.webank.webank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webank.webank.model.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    
}
