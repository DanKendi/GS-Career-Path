package br.com.fiap.CareerPath.repository;

import br.com.fiap.CareerPath.entity.Habilidade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer> {
    @Modifying
    @Transactional
    @Query(value = "CALL SP_INS_HABILIDADE(:id_habilidade, :nome, :nivel_necessario)", nativeQuery = true)
    void inserirHabilidade(@Param("id_habilidade") Integer id_habilidade,
                           @Param("nome")String nome,
                           @Param("nivel_necessario") Integer nivel_necessario);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_UPD_HABILIDADE(:id_habilidade, :nome, :nivel_necessario)", nativeQuery = true)
    void updateHabilidade( @Param("id_habilidade") Integer id_habilidade,
                           @Param("nome")String nome,
                           @Param("nivel_necessario") String nivel_necessario);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_HABILIDADE(:id_habilidade)", nativeQuery = true)
    void deletarHabilidade(@Param("id_habilidade") Integer id_habilidade);
}
