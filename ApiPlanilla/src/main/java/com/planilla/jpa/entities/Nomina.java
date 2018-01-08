/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planilla.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abels
 */
@Entity
@Table(name = "nominas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nomina.findAll", query = "SELECT n FROM Nomina n")
    , @NamedQuery(name = "Nomina.findById", query = "SELECT n FROM Nomina n WHERE n.id = :id")
    , @NamedQuery(name = "Nomina.findByDescripcion", query = "SELECT n FROM Nomina n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Nomina.findByMes", query = "SELECT n FROM Nomina n WHERE n.mes = :mes")})
public class Nomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    private int mes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNomina")
    private Collection<DetalleNomina> detalleNominaCollection;

    public Nomina() {
    }

    public Nomina(Integer id) {
        this.id = id;
    }

    public Nomina(Integer id, String descripcion, int mes) {
        this.id = id;
        this.descripcion = descripcion;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @XmlTransient
    public Collection<DetalleNomina> getDetalleNominaCollection() {
        return detalleNominaCollection;
    }

    public void setDetalleNominaCollection(Collection<DetalleNomina> detalleNominaCollection) {
        this.detalleNominaCollection = detalleNominaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomina)) {
            return false;
        }
        Nomina other = (Nomina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planilla.jpa.entities.Nomina[ id=" + id + " ]";
    }
    
}
