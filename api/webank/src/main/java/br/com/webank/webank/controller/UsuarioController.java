package br.com.webank.webank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.webank.webank.dto.usuario.UsuarioLoginRequestDTO;
import br.com.webank.webank.dto.usuario.UsuarioLoginResponseDTO;
import br.com.webank.webank.dto.usuario.UsuarioRequestDTO;
import br.com.webank.webank.dto.usuario.UsuarioResponseDTO;
import br.com.webank.webank.service.EmailService;
import br.com.webank.webank.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obterTodos(){
        return ResponseEntity.ok(usuarioService.obterTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> adicionar(@RequestBody UsuarioRequestDTO usuario){
        UsuarioResponseDTO usuarioAdicionado = usuarioService.adicionar(usuario);

        return ResponseEntity
            .status(201)
            .body(usuarioAdicionado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuario){
        UsuarioResponseDTO usuarioAtualizado = usuarioService.atualizar(id, usuario);

        return ResponseEntity
            .status(200)
            .body(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        
        return ResponseEntity
            .status(204)
            .build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponseDTO> logar(@RequestBody UsuarioLoginRequestDTO usuariologinRequest){
        
        UsuarioLoginResponseDTO usuarioLogado = usuarioService.logar(usuariologinRequest.getEmail(), usuariologinRequest.getSenha());
        
        return ResponseEntity
            .status(200)
            .body(usuarioLogado);
    }
}
