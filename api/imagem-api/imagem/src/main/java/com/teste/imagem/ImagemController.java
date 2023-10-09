package com.teste.imagem;

import com.teste.imagem.Repository.ImagemRepository;
import com.teste.imagem.model.Imagem;

@RestController
@RequestMapping("/imagens")
public class ImagemController {
    @Autowired
    private ImagemRepository imagemRepository;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImagem(@RequestParam("arquivo") MultipartFile arquivo) {
        try {
            Imagem imagem = new Imagem();
            imagem.setNome(arquivo.getOriginalFilename());
            imagem.setContentType(arquivo.getContentType());
            imagem.setDados(arquivo.getBytes());
            imagemRepository.save(imagem);
            return ResponseEntity.ok("Imagem salva com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a imagem.");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImagem(@PathVariable Long id) {
        Optional<Imagem> imagemOptional = imagemRepository.findById(id);
        if (imagemOptional.isPresent()) {
            Imagem imagem = imagemOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(imagem.getContentType()));
            headers.setContentDispositionFormData(imagem.getNome(), imagem.getNome());
            return new ResponseEntity<>(imagem.getDados(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}

