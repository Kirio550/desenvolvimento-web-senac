/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static javax.swing.Spring.scale;
import static javax.swing.Spring.width;
import static org.eclipse.jdt.internal.compiler.flow.FlowInfo.initial;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aluno
 */
@Controller
public class ContatoServico {

    List<SolicitacaoContato> solicitacoes = new ArrayList<>();

    @RequestMapping("/processar-form-contato")
    public String recebeDadosParaContato(@RequestParam Map<String, String> todosParametros) {
        System.out.println("entrei no metodo: /processar-form-contato");
        //System.out.println(todosParametros);

        SolicitacaoContato novaSolicitacao = new SolicitacaoContato();
        novaSolicitacao.nome = todosParametros.get("nome");
        novaSolicitacao.email = todosParametros.get("Email");
        novaSolicitacao.duvida = todosParametros.get("Duvida");

        System.out.println("Solicitações anteriores: " + solicitacoes);

        System.out.println("Nova solicitação recebida: " + novaSolicitacao);

        solicitacoes.add(novaSolicitacao);
        return "redirect/principal.html";

    }

    @RequestMapping("/todas-solicitacoes")
    @ResponseBody
    public String gerarTelaTodasSolcontatos() {
        String html = "<html>\n"
                + "    <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>Catalogo</h1>\n"
                + "        <p>Esta e a pagina do catalogo da nosso catalogo.</p>\n"
                + "        <table>";
        for (SolicitacaoContato sol : solicitacoes) {
            String linhaTabela = "<tr>";

            //nome
            linhaTabela += "<td>";
            linhaTabela += sol.nome;
            linhaTabela += "</td>";
            //email
            linhaTabela += "<td>";
            linhaTabela += sol.email;
            linhaTabela += "</td>";
            //duvida
            linhaTabela += "</tr>";

            html += linhaTabela;
        }

        html += "        </table>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
        return html;
    }
}
