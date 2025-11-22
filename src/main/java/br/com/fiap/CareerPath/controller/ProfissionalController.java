package br.com.fiap.CareerPath.controller;

import br.com.fiap.CareerPath.controller.dto.ProfissionalRequestDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalResponseDTO;
import br.com.fiap.CareerPath.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public List<ProfissionalResponseDTO> listarTodosProfissionais() {return profissionalService.buscarTodos();}

    @PostMapping
    public ResponseEntity<Void> criarProfissional(@RequestBody ProfissionalRequestDTO requestDTO){
        profissionalService.salvarProfissional(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarProfissional(@PathVariable Integer id, @RequestBody ProfissionalRequestDTO requestDTO){
        try{
            profissionalService.atualizar(id, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Integer id){
        profissionalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
