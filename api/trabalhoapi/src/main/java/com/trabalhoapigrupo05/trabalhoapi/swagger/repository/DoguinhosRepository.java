package com.trabalhoapigrupo05.trabalhoapi.swagger.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Doguinhos;

@Repository
public class DoguinhosRepository {

    long ultimoId = 0;
    
    public List<Doguinhos> listaDeDoginhos(Doguinhos doguinho) {

        ArrayList<Doguinhos> listaDoguinhos = new ArrayList<>();

        ultimoId++;

        doguinho.setId(ultimoId);

        listaDoguinhos.add(doguinho);

        return listaDoguinhos;
    }
}
