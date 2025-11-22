package br.com.fiap.CareerPath.repository;

import br.com.fiap.CareerPath.entity.Profissional;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

    @Modifying
    @Transactional
    @Query(value = "CALL SP_INS_PROFISSIONAL(:id_profissional, :nome, :email, :profissao_atual)", nativeQuery = true)
    void inserirProfissional(
                             @Param("id_profissional") Integer id_profissional,
                             @Param("nome") String nome,
                             @Param("email") String email,
                             @Param("profissao_atual") String profissao_atual);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_UPD_PROFISSIONAL(:id_profissional, :nome, :email, :profissao_atual)", nativeQuery = true)
    void updateProfissional(
                            @Param("id_profissional") Integer id_profissional,
                            @Param("nome") String nome,
                            @Param("email") String email,
                            @Param("profissao_atual") String profissao_atual);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_PROFISSIONAL(:id_profissional)", nativeQuery = true)
    void deletarProfissional(@Param("id_profissional") Integer id_profissional);
}
