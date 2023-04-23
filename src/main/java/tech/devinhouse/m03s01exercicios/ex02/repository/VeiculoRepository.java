package tech.devinhouse.m03s01exercicios.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m03s01exercicios.ex02.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
