
package tech.devinhouse.exercicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.devinhouse.m03s01exercicios.ex01.FolhaDePagamento;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FolhaDePagamentoTest {

    private FolhaDePagamento folha;

    @BeforeEach
    void setup() {
        folha = new FolhaDePagamento();
    }

    @Test
    @DisplayName("Quando tem gratificacao, deve adicionar gratificacao no salario")
    void calcularSalarioBruto_comGratificacao() {
        // given
        Double salarioBase = 1000.0;
        Double gratificacao = 200.0;
        String funcao = "dev";
        // when
        Double resultado = folha.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        // then
        assertNotNull(resultado);
        assertEquals(1200.0, resultado);
    }

    @Test
    @DisplayName("Quando nao tem gratificacao, nao deve adicionar gratificacao no salario")
    void calcularSalarioBruto_semGratificacao() {
        // given
        Double salarioBase = 1000.0;
        Double gratificacao = null;
        String funcao = "dev";
        // when
        Double resultado = folha.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        // then
        assertNotNull(resultado);
        assertEquals(1000.0, resultado);
    }

    @Test
    @DisplayName("Quando é gerente, deve adicionar percentual no salário")
    void calcularSalarioBruto_ehGerente() {
        // given
        Double salarioBase = 1000.0;
        Double gratificacao = null;
        String funcao = "gerente";
        // when
        Double resultado = folha.calcularSalarioBruto(salarioBase, gratificacao, funcao);
        // then
        assertNotNull(resultado);
        assertEquals(1300, resultado);
    }


    @Test
    void calcularSalarioLiquido() {
        // given
        Double salario = 100.0;
        List<Double> descontos = new ArrayList<>();
        descontos.add(200.0);
        // then
        assertThrows(IllegalStateException.class, () -> folha.calcularSalarioLiquido(salario, descontos));
    }

    @Test
    void calcularSalarioLiquido_semDesconto() {
        // given
        Double salario = 1000.0;
        List<Double> descontos = new ArrayList<>();
        // when
        Double resultado = folha.calcularSalarioLiquido(salario, descontos);
        // then
        assertEquals(1000.0, resultado);
    }

    @Test
    void calcularSalarioLiquido_comDesconto() {
        // given
        Double salario = 1000.0;
        List<Double> descontos = new ArrayList<>();
        descontos.add(200.0);
        // when
        Double resultado = folha.calcularSalarioLiquido(salario, descontos);
        // then
        assertEquals(800.0, resultado);
    }

}