package com.startfestas.service;

import com.startfestas.model.Orcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvarOrcamento(Orcamento orcamento) {
        String sql = "INSERT INTO orcamento (nome, email, telefone, endereco, data_evento, observacoes, faixa_etaria, tipo_servico) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orcamento.getNome(), orcamento.getEmail(), orcamento.getTelefone(),
                            orcamento.getEndereco(), orcamento.getDataEvento(), orcamento.getObservacoes(),
                            orcamento.getFaixaEtaria(), orcamento.getTipoServico());
    }
}
