package com.trabalhoapigrupo05.trabalhoapi.swagger.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Doguinhos;
import com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities.Raca;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service // Indica que esta classe é um componente de serviço do Spring
@Component // Indica que esta classe é um componente do Spring (pode ser injetada em outras classes)
public class SwaggerService {

    // Injeta o valor da propriedade 'path.documents' do arquivo de configuração
    @Value("${path.documents}")
    private String path;

    // Método para fazer upload de um documento
    public ResponseEntity<String> uploadDocument(MultipartFile file) {
        try {
            // Verifica se o diretório de destino existe, se não, cria o diretório
            File directory = new File("C:\\tmp\\arquivo");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria diretórios recursivamente se não existirem
            }

            // Caminho completo do arquivo no diretório de destino
            String filePath = directory.getAbsolutePath() + File.separator + file.getOriginalFilename();

            // Salva o arquivo no caminho especificado
            File newDocument = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(newDocument, true);
            file.getInputStream().transferTo(fileOutputStream); // Copia os bytes do arquivo para o novo arquivo

            // Retorna uma resposta bem-sucedida com o nome do arquivo carregado
            return ResponseEntity.ok("Arquivo carregado " + file.getName());
        } catch (IOException e) {
            // Lança uma exceção em caso de erro durante o processo de carregamento do arquivo
            throw new RuntimeException("Erro ao carregar arquivo", e);
        }
    }

    /**
     * Método para buscar doguinhos com base na raça.
     *
     * @param raca Raça pela qual os doguinhos devem ser filtrados.
     * @param idade Idade das pessoas a serem filtradas.
     * @return Lista de doguinhos que correspondem aos critérios da raça.
     */
    public List<Doguinhos> buscaDoguinhosPorRaca(Raca raca) {
        // Chama o método privado buscarDoguinhos() para obter a lista completa de doguinhos.
        List<Doguinhos> pessoas = buscarDoguinhos();

        // Usa streams para filtrar os doguinhos com base na raça fornecida.
        return pessoas.stream()
            // Filtra doguinhos não nulos.
            .filter(Objects::nonNull)
            // Filtra doguinhos com a raça especificada.
            .filter(pessoa -> pessoa.getRaca().equals(raca))
            // Coleta os resultados filtrados em uma lista e retorna.
            .collect(Collectors.toList());
    }

    /**
     * @return Lista de doguinhos fixa usada para filtragem.
     */
    private static List<Doguinhos> buscarDoguinhos() {
        // Retorna uma lista de doguinhos predefinidas com nomes, idades, tamanhos e raças.
        return Arrays.asList(
            new Doguinhos("Pongo", 2, "61cm", Raca.DALMATA, ""),
            new Doguinhos("Pluto", 3, "54cm", Raca.VIRA_LATA, ""),
            new Doguinhos("Dante", 4, "43cm", Raca.VIRA_LATA, ""),
            new Doguinhos("Joca", 8, "32cm", Raca.TERRIER, ""),
            new Doguinhos("Prenda", 1, "56cm", Raca.DALMATA, ""),
            new Doguinhos("Jasper", 1, "57cm", Raca.LABRADOR, ""),
            new Doguinhos("Brutus", 6, "53cm", Raca.BULL_TERRIER, ""),
            new Doguinhos("Dug", 7, "56cm", Raca.GOLDEN, ""),
            new Doguinhos("Gigi", 2, "45cm", Raca.POODLE, "")
        );
    }
}
