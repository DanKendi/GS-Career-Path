package br.com.fiap.CareerPath.controller;

import br.com.fiap.CareerPath.controller.dto.ProfissionalHabilidadeRequestDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalHabilidadeResponseDTO;
import br.com.fiap.CareerPath.service.ProfissionalHabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais-habilidades")
public class ProfissionalHabilidadeController {

    @Autowired
    private ProfissionalHabilidadeService profissionalHabilidadeService;

    @GetMapping
    public List<ProfissionalHabilidadeResponseDTO> listarTodos() {return profissionalHabilidadeService.buscarTodos();}

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody ProfissionalHabilidadeRequestDTO requestDTO){
        profissionalHabilidadeService.salvarRecomendacao(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody ProfissionalHabilidadeRequestDTO requestDTO){
        try{
            profissionalHabilidadeService.update(id, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        profissionalHabilidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
