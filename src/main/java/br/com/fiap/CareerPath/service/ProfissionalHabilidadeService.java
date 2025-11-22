package br.com.fiap.CareerPath.service;

import br.com.fiap.CareerPath.controller.dto.HabilidadeResponseDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalResponseDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalHabilidadeRequestDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalHabilidadeResponseDTO;
import br.com.fiap.CareerPath.entity.Habilidade;
import br.com.fiap.CareerPath.entity.Profissional;
import br.com.fiap.CareerPath.entity.ProfissionalHabilidade;
import br.com.fiap.CareerPath.repository.ProfissionalHabilidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalHabilidadeService {

    @Autowired
    private ProfissionalHabilidadeRepository repository;

    @Transactional
    public void salvarRecomendacao(ProfissionalHabilidadeRequestDTO requestDTO){
        Integer proximodId = buscarProximoId();
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_PROFISSIONAL_HABILIDADE(id_profissional_habilidade, :id_profissional, id_habilidade, :nivel_atual)"
        );
        query.setParameter("id_profissional_habilidade", proximodId);
        query.setParameter("id_profissional", requestDTO.getProfissionalId());
        query.setParameter("id_habilidade", requestDTO.getHabilidadeId());
        query.setParameter("nivel_atual", requestDTO.getNivelAtual());
        query.executeUpdate();
    }

    public List<ProfissionalHabilidadeResponseDTO> buscarTodos(){
        return repository.findAll().stream().map(this::toRespDTO).collect(Collectors.toList());
    }

    @Transactional
    public void update(Integer id, ProfissionalHabilidadeRequestDTO requestDTO){
        Query query = entityManager.createNativeQuery(
                "CALL SP_UPD_PROFISSIONAL_HABILIDADE(:id_profissional_habilidade, :id_profissional, id_habilidade, :nivel_atual)"
        );
        query.setParameter("id_profissional", requestDTO.getProfissionalId());
        query.setParameter("id_habilidade", requestDTO.getHabilidadeId());
        query.setParameter("justificativa", requestDTO.getNivelAtual());
        query.executeUpdate();
    }

    @Transactional
    public void deletar(Integer id){
        Query query = entityManager.createNativeQuery("CALL SP_DEL_PROFISSIONAL_HABILIDADE(:id_profissional_habilidade)");
        query.setParameter("id_profissional_habilidade", id);
        query.executeUpdate();
    }

    private ProfissionalHabilidadeResponseDTO toRespDTO(ProfissionalHabilidade profissionalHabilidade){
        ProfissionalResponseDTO profissionalDTO = toProfissionalRespDTO(profissionalHabilidade.getProfissional());
        HabilidadeResponseDTO habilidadeDTO = toHabilidadeRespDTO(profissionalHabilidade.getHabilidade());
        
        return new ProfissionalHabilidadeResponseDTO(
                profissionalHabilidade.getId(),
                profissionalDTO,
                habilidadeDTO,
                profissionalHabilidade.getNivelAtual()
        );
    }

    private ProfissionalResponseDTO toProfissionalRespDTO(Profissional profissional){
        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNome(),
                profissional.getProfissaoAtual(),
                profissional.getEmail()
        );
    }

    private HabilidadeResponseDTO toHabilidadeRespDTO(Habilidade habilidade){
        return new HabilidadeResponseDTO(
                habilidade.getId(),
                habilidade.getNome(),
                habilidade.getNivelNecessario()
        );
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_PROFISSIONAL_HABILIDADE), 0) + 1 FROM T_CP_PROFISSIONAL_HABILIDADE");
        return  ((Number) query.getSingleResult()).intValue();
    }
}
