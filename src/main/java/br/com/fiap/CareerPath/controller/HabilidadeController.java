package br.com.fiap.CareerPath.controller;

import br.com.fiap.CareerPath.controller.dto.HabilidadeRequestDTO;
import br.com.fiap.CareerPath.controller.dto.HabilidadeResponseDTO;
import br.com.fiap.CareerPath.service.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public List<HabilidadeResponseDTO> listarTodasHabilidades() {return habilidadeService.buscarTodos();}

    @PostMapping
    public ResponseEntity<Void> criarHabilidade(@RequestBody HabilidadeRequestDTO requestDTO){
        try{
            habilidadeService.salvarHabilidade(requestDTO);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarHabilidade(@PathVariable Integer id, @RequestBody HabilidadeRequestDTO requestDTO){
        try{
            habilidadeService.update(id, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHabilidade(@PathVariable Integer id){
        habilidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}