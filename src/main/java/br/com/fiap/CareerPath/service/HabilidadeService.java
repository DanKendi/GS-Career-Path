package br.com.fiap.CareerPath.service;

import br.com.fiap.CareerPath.controller.dto.HabilidadeRequestDTO;
import br.com.fiap.CareerPath.controller.dto.HabilidadeResponseDTO;
import br.com.fiap.CareerPath.entity.Habilidade;
import br.com.fiap.CareerPath.repository.HabilidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository repository;

    @Transactional
    public void salvarHabilidade(HabilidadeRequestDTO requestDTO){
        Integer proximodId = buscarProximoId();
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_HABILIDADE(:id_habilidade, :nome, :nivel_necessario)"
        );
        query.setParameter("id_habilidade", proximodId);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("nivel_necessario", requestDTO.getNivelNecessario());
        query.executeUpdate();
    }

    public List<HabilidadeResponseDTO> buscarTodos(){
        return repository.findAll().stream().map(this::toRespDTO).collect(Collectors.toList());
    }

    @Transactional
    public void update(Integer id, HabilidadeRequestDTO requestDTO){
        Query query = entityManager.createNativeQuery(
                "CALL SP_UPD_HABILIDADE(:id_habilidade, :nome, :nivel_necessario)"
        );
        query.setParameter("id_habilidade", id);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("nivel_necessario", requestDTO.getNivelNecessario());
        query.executeUpdate();
    }

    @Transactional
    public void deletar(Integer id){
        Query query = entityManager.createNativeQuery("CALL SP_DEL_HABILIDADE(:id_habilidade)");
        query.setParameter("id_habilidade", id);
        query.executeUpdate();
    }

    private HabilidadeResponseDTO toRespDTO(Habilidade habilidade){
        return new HabilidadeResponseDTO(
                habilidade.getId(),
                habilidade.getNome(),
                habilidade.getNivelNecessario()
        );
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_HABILIDADE), 0) + 1 FROM T_CP_HABILIDADE");
        return  ((Number) query.getSingleResult()).intValue();
    }
}
