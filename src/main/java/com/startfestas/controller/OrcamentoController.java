package com.startfestas.controller;

import com.startfestas.model.Orcamento;
import com.startfestas.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

@PostMapping("/salvar")
public String salvarOrcamento(@RequestParam String nome, @RequestParam String email,
                               @RequestParam String telefone, @RequestParam String endereco,
                               @RequestParam String dataEvento, @RequestParam String observacoes,
                               @RequestParam String faixaEtaria, @RequestParam String[] tipoServico,
                               Model model) {

    Orcamento orcamento = new Orcamento();
    orcamento.setNome(nome);
    orcamento.setEmail(email);
    orcamento.setTelefone(telefone);
    orcamento.setEndereco(endereco);
    orcamento.setDataEvento(dataEvento);
    orcamento.setObservacoes(observacoes);
    orcamento.setFaixaEtaria(faixaEtaria);
    
    // Converte o array de tipoServico para uma String separada por vírgulas
    String tiposServico = String.join(", ", tipoServico);
    orcamento.setTipoServico(tiposServico); // Armazena os tipos de serviço selecionados

    // Salva o orçamento no banco de dados
    orcamentoService.salvarOrcamento(orcamento);

    // Passa as informações para a página de sucesso
    model.addAttribute("orcamento", orcamento);

    return "sucesso"; // Redireciona para a página de sucesso
}
}
