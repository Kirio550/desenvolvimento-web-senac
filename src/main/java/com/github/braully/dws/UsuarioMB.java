/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

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

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void salvarUsuario(){
        usuarioDAO.save(usuario);
        FacesContext . getCurrentInstance()
                . addMessage( null , new FacesMessage ("Usuario salvo com sucesso" ));
        
        usuario = new Usuario();
        
    }
}
