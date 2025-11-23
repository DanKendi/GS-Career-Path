package br.com.fiap.CareerPath.service;

import br.com.fiap.CareerPath.controller.dto.ProfissionalRequestDTO;
import br.com.fiap.CareerPath.controller.dto.ProfissionalResponseDTO;
import br.com.fiap.CareerPath.entity.Profissional;
import br.com.fiap.CareerPath.repository.ProfissionalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public Page<ProfissionalResponseDTO> findByNome(String nome, Pageable pageable){
        return repository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(this::toProfissionalRespDTO);
    }

    @Transactional
    public void salvarProfissional(ProfissionalRequestDTO request){
        Integer proximoId = buscarProximoId();
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_PROFISSIONAL(:id_profissional, :nome, :email, :profissao_atual)"
        );
        query.setParameter("id_profissional", proximoId);
        query.setParameter("nome", request.getNome());
        query.setParameter("email", request.getEmail());
        query.setParameter("profissao_atual", request.getProfissaoAtual());
        query.executeUpdate();
    }

    public List<ProfissionalResponseDTO> buscarTodos(){
        return repository.findAll().stream().map(this::toProfissionalRespDTO).collect(Collectors.toList());
    }

    @Transactional
    public void atualizar(Integer id, ProfissionalRequestDTO requestDTO){
        Query query = entityManager.createNativeQuery(
                "CALL SP_UPD_PROFISSIONAL(:id_profissional, :nome, :email, :profissao_atual)"
        );
        query.setParameter("id_profissional", id);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("email", requestDTO.getEmail());
        query.setParameter("profissao_atual", requestDTO.getProfissaoAtual());
        query.executeUpdate();
    }

    @Transactional
    public void deletar(Integer id){
        Query query = entityManager.createNativeQuery("CALL SP_DEL_PROFISSIONAL(:id_profissional)");
        query.setParameter("id_profissional", id);
        query.executeUpdate();
    }


    private ProfissionalResponseDTO toProfissionalRespDTO(Profissional profissional){
        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNome(),
                profissional.getProfissaoAtual(),
                profissional.getEmail()
        );
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_PROFISSIONAL), 0) + 1 FROM T_CP_PROFISSIONAL");
        return  ((Number) query.getSingleResult()).intValue();
    }
}
