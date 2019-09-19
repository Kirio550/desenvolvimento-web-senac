/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Scope("view")
@Component
public class UsuarioMB {

    @Autowired
    UsuarioDAO usuarioDAO;

    Usuario usuario = new Usuario();
    private Object listaGrupos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void salvarUsuario() {
        gruposSelecionados.forEach(k,v) -> {if (v) usuario.adicionaGrupo(k));
        
        usuarioDAO.save(usuario);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Usuario salvo com sucesso"));

        usuario = new Usuario();

    }
    List<Grupo> listraGrupos;

    public List<Grupo> getListaGrupos() {
        if (listaGrupos == null) {
            listaGrupos = new ArrayList<>() ;
            for (Grupo g : grupoDAO.findAll()) {
                listaGrupos.add(g);
            }
        }
        return listaGrupos;
    }
    Map<grupo, Boolean> gruposSelecionados = new HashMap<>();
    
    public Map<grupo, Boolean
}
