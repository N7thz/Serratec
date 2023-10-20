package br.com.webank.webank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webank.webank.model.Auditoria;
import br.com.webank.webank.repository.AuditoriaRepository;

@Service
public class AuditoriaService {
    
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void registrarAuditoria(Auditoria auditoria){
        this.auditoriaRepository.save(auditoria);
    }
}
