package br.com.fiap.CareerPath.repository;

import br.com.fiap.CareerPath.entity.ProfissionalHabilidade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfissionalHabilidadeRepository extends JpaRepository<ProfissionalHabilidade, Integer> {
    @Modifying
    @Transactional
    @Query(value = "CALL SP_INS_PROFISSIONAL_HABILIDADE(:id_profissional_habilidade,:id_profissional, id_habilidade, :justificativa)", nativeQuery = true)
    void inserirProfissionalHab(@Param("id_profissional_habilidade") Integer id_profissional_habilidade,
                             @Param("id_profissional")Integer id_profissional,
                             @Param("id_habilidade") Integer id_habilidade,
                             @Param("nivel_atual") Integer nivel_atual);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_PROFISSIONAL_HABILIDADE(:id_profissional_habilidade, :id_profissional, id_habilidade, :nivel_atual)", nativeQuery = true)
    void updateProfissionalHab( @Param("id_profissional_habilidade") Integer id_profissional_habilidade,
                             @Param("id_profissional")Integer id_profissional,
                             @Param("id_habilidade") Integer id_habilidade,
                             @Param("nivel_atual") Integer nivel_atual);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_PROFISSIONAL_HABILIDADE(:id_profissional_habilidade)", nativeQuery = true)
    void deletarProfissionalHab(@Param("id_profissional_habilidade")Integer id_profissional_habilidade);
}
