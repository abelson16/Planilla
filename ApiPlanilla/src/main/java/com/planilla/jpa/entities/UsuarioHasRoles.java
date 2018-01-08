/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planilla.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "usuarios_has_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasRoles.findAll", query = "SELECT u FROM UsuarioHasRoles u")
    , @NamedQuery(name = "UsuarioHasRoles.findByIdUsuario", query = "SELECT u FROM UsuarioHasRoles u WHERE u.usuarioHasRolesPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioHasRoles.findByIdRol", query = "SELECT u FROM UsuarioHasRoles u WHERE u.usuarioHasRolesPK.idRol = :idRol")
    , @NamedQuery(name = "UsuarioHasRoles.findByActivo", query = "SELECT u FROM UsuarioHasRoles u WHERE u.activo = :activo")})
public class UsuarioHasRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasRolesPK usuarioHasRolesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_rol", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasRoles() {
    }

    public UsuarioHasRoles(UsuarioHasRolesPK usuarioHasRolesPK) {
        this.usuarioHasRolesPK = usuarioHasRolesPK;
    }

    public UsuarioHasRoles(UsuarioHasRolesPK usuarioHasRolesPK, boolean activo) {
        this.usuarioHasRolesPK = usuarioHasRolesPK;
        this.activo = activo;
    }

    public UsuarioHasRoles(int idUsuario, String idRol) {
        this.usuarioHasRolesPK = new UsuarioHasRolesPK(idUsuario, idRol);
    }

    public UsuarioHasRolesPK getUsuarioHasRolesPK() {
        return usuarioHasRolesPK;
    }

    public void setUsuarioHasRolesPK(UsuarioHasRolesPK usuarioHasRolesPK) {
        this.usuarioHasRolesPK = usuarioHasRolesPK;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasRolesPK != null ? usuarioHasRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasRoles)) {
            return false;
        }
        UsuarioHasRoles other = (UsuarioHasRoles) object;
        if ((this.usuarioHasRolesPK == null && other.usuarioHasRolesPK != null) || (this.usuarioHasRolesPK != null && !this.usuarioHasRolesPK.equals(other.usuarioHasRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planilla.jpa.entities.UsuarioHasRoles[ usuarioHasRolesPK=" + usuarioHasRolesPK + " ]";
    }
    
}
