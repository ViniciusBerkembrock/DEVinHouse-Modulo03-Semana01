package tech.devinhouse.m03s01exercicios.ex02.dto;

import lombok.Data;

@Data
public class VeiculoResponse {

    private String placa;

    private String tipo;

    private String cor;

    private Integer anoDeFabricacao;

    private Integer qtdMultas;

}
