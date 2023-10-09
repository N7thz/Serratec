package com.trabalhoapigrupo05.trabalhoapi.swagger.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.trabalhoapigrupo05.trabalhoapi.swagger.business.DoguinhoService;
import com.trabalhoapigrupo05.trabalhoapi.swagger.business.SwaggerService;
import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Base64FileRequest;
import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Doguinhos;
import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Raca;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Anotação indicando que esta classe é um controlador para endpoints REST
@RestController
// Anotação para habilitar o logging na classe usando SLF4J (Simple Logging
// Facade for Java)
@Slf4j
// Mapeamento do caminho base para todos os endpoints nesta classe
@RequestMapping(value = "/teste-open-api", produces = { "application/json" })
// Tag OpenAPI para documentação de especificação
@Tag(name = "open-api")
public class SwaggerController {

    private DoguinhoService doguinhoService;

    long ultimoId = 0;

    // Injeção de dependência do serviço SwaggerService no controlador
    private final SwaggerService service;

    // Construtor que recebe um objeto SwaggerService como argumento e o inicializa
    public SwaggerController(SwaggerService service) {
        this.service = service;
    }

    // Anotação para descrever uma operação de API para upload de arquivos via
    // método POST
    @Operation(summary = "Realiza o upload de arquivos do tipo File e armazena no disco físico do servidor", method = "POST")
    // Definição das respostas possíveis para esta operação
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    // Mapeamento do endpoint para receber uma requisição POST com dados do tipo
    // multipart/form-data
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Doguinhos> uploadDocuments(@RequestPart MultipartFile file,
            @RequestParam("Nome do Doguinho") String nomeDoguinho, @RequestParam("Idade do Doguinho") int idadeDoguinho,
            @RequestParam("Tamanho do Doguinho") String tamanhoDoguinho, @RequestParam("Raça") Raca raca) {
        log.info(format("Upload do arquivo %s iniciado!", file.getOriginalFilename(),
                "Buscando dados de doguinhos por raça = %s!", raca));

        try {
            // Obter o nome do arquivo original
            String fileName = file.getOriginalFilename();

            // Obter a extensão do arquivo
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));

            // Construir o caminho completo do arquivo no servidor (adicionando o nome do
            // Doguinho ao caminho)
            String filePath = "C:\\tmp\\arquivo\\" + raca + fileExtension;
            File newDocument = new File(filePath);

            // Salvar o arquivo no disco
            FileOutputStream fileOutputStream = new FileOutputStream(newDocument);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

            // Criar um objeto Doguinhos com os dados e o caminho do arquivo
            Doguinhos doguinho = new Doguinhos(nomeDoguinho, idadeDoguinho, tamanhoDoguinho, raca, filePath);

            // Retorna o objeto Doguinhos na resposta da API
            return ResponseEntity.ok(doguinho);
        } catch (IOException e) {
            // Em caso de erro, lança uma exceção e retorna uma resposta de erro
            throw new RuntimeException("Erro ao carregar arquivo", e);
        }
    }
    
    // Anotação para documentar a operação da API, descrevendo o resumo e o método
    // HTTP
    @Operation(summary = "Realiza o upload de arquivos do tipo URL convertendo para base-64 no body e armazena no disco físico do servidor", method = "POST")
    // Mapeia a URL da API para manipular solicitações POST para "/upload-base64"
    @PostMapping("/upload-base64")
    public ResponseEntity<String> uploadBase64(@RequestBody Base64FileRequest base64FileRequest) {
        try {
            // Converte a URL da imagem em bytes usando Base64
            URL imageUrl = new URL(base64FileRequest.getImageUrl());
            // Abre um fluxo de entrada para a URL da imagem
            InputStream imageInputStream = imageUrl.openStream();
            // Lê os bytes da imagem e converte para Base64
            byte[] imageBytes = IOUtils.toByteArray(imageInputStream);
            String base64Data = Base64Utils.encodeToString(imageBytes);

            // Decodifica o conteúdo Base64 em bytes
            byte[] fileBytes = Base64Utils.decodeFromString(base64Data);

            // Cria o diretório de destino se não existir
            File directory = new File("C:\\tmp\\arquivo");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Cria o caminho completo para o novo arquivo
            String filePath = directory.getAbsolutePath() + File.separator + base64FileRequest.getFileName();
            // Cria um novo arquivo no caminho especificado
            File newDocument = new File(filePath);
            // Abre um fluxo de saída para o novo arquivo
            FileOutputStream fileOutputStream = new FileOutputStream(newDocument);
            // Escreve os bytes decodificados no arquivo
            fileOutputStream.write(fileBytes);
            // Fecha o fluxo de saída
            fileOutputStream.close();

            // Retorna uma resposta de sucesso com uma mensagem indicando o nome do arquivo
            // carregado
            return ResponseEntity.ok("Arquivo Base64 carregado: " + base64FileRequest.getFileName());
        } catch (IOException e) {
            // Em caso de erro, lança uma exceção RuntimeException com uma mensagem
            // personalizada
            throw new RuntimeException("Erro ao carregar arquivo Base64", e);
        }
    }

    // Anotação para documentar a operação no Swagger/OpenAPI.
    @Operation(summary = "Busca dados dos doguinhos na lista de adoção usando o Swagger (documentação muito legal para API)", method = "GET")
    // Anotação para definir as respostas da operação no Swagger/OpenAPI.
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    // Mapeia a requisição HTTP GET para este método.
    @GetMapping()
    // Método que busca dados dos doguinhos com base nos parâmetros de entrada.
    public ResponseEntity<List<Doguinhos>> buscarDoguinhos(@RequestParam("Raça") Raca raca) {
        // Loga a informação da busca no console.
        log.info(format("Buscando dados de doguinhos por raça = %s!", raca));

        // Chama o serviço para buscar os doguinhos com base nos parâmetros de entrada.
        List<Doguinhos> doguinhosEncontrados = service.buscaDoguinhosPorRaca(raca);

        // Itera sobre a lista de doguinhos encontrados e adiciona o caminho do arquivo
        // no atributo "imagem".
        for (Doguinhos doguinho : doguinhosEncontrados) {
            // Construa o caminho do diretório onde o arquivo foi armazenado.
            String filePath = "C:\\tmp\\arquivo\\" + doguinho.getNome() + ".png"; // ou a extensão correspondente ao
                                                                                  // tipo de arquivo
            doguinho.setImagem(filePath);
        }

        // Retorna uma resposta HTTP 200 OK com a lista de doguinhos encontrados no
        // corpo
        // da resposta.
        return ResponseEntity.ok(doguinhosEncontrados);
    }
}
