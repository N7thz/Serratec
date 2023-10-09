package com.trabalhoapigrupo05.trabalhoapi.swagger.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Doguinhos;
import com.trabalhoapigrupo05.trabalhoapi.swagger.repository.DoguinhosRepository;

@Service
public class DoguinhoService {
    
    @Autowired
    private DoguinhosRepository doguinhosRepository;

    public List<Doguinhos> listaDeDoginhos(Doguinhos doguinho) {
        
        return doguinhosRepository.listaDeDoginhos(doguinho);
    }
}
