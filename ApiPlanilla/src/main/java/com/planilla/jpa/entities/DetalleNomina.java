/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planilla.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "detalle_nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleNomina.findAll", query = "SELECT d FROM DetalleNomina d")
    , @NamedQuery(name = "DetalleNomina.findById", query = "SELECT d FROM DetalleNomina d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleNomina.findByDiasLaborados", query = "SELECT d FROM DetalleNomina d WHERE d.diasLaborados = :diasLaborados")
    , @NamedQuery(name = "DetalleNomina.findBySueldoDevengado", query = "SELECT d FROM DetalleNomina d WHERE d.sueldoDevengado = :sueldoDevengado")
    , @NamedQuery(name = "DetalleNomina.findByAuxilioTransporte", query = "SELECT d FROM DetalleNomina d WHERE d.auxilioTransporte = :auxilioTransporte")
    , @NamedQuery(name = "DetalleNomina.findByValorHorasExtras", query = "SELECT d FROM DetalleNomina d WHERE d.valorHorasExtras = :valorHorasExtras")
    , @NamedQuery(name = "DetalleNomina.findByDescuentoSalud", query = "SELECT d FROM DetalleNomina d WHERE d.descuentoSalud = :descuentoSalud")
    , @NamedQuery(name = "DetalleNomina.findByDescuentoPension", query = "SELECT d FROM DetalleNomina d WHERE d.descuentoPension = :descuentoPension")
    , @NamedQuery(name = "DetalleNomina.findByDescuentoFondoSolidaridad", query = "SELECT d FROM DetalleNomina d WHERE d.descuentoFondoSolidaridad = :descuentoFondoSolidaridad")
    , @NamedQuery(name = "DetalleNomina.findByOtrosDescuentos", query = "SELECT d FROM DetalleNomina d WHERE d.otrosDescuentos = :otrosDescuentos")
    , @NamedQuery(name = "DetalleNomina.findByTotalDevengado", query = "SELECT d FROM DetalleNomina d WHERE d.totalDevengado = :totalDevengado")
    , @NamedQuery(name = "DetalleNomina.findByTotalDescuento", query = "SELECT d FROM DetalleNomina d WHERE d.totalDescuento = :totalDescuento")
    , @NamedQuery(name = "DetalleNomina.findByNetoPagar", query = "SELECT d FROM DetalleNomina d WHERE d.netoPagar = :netoPagar")})
public class DetalleNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_laborados")
    private int diasLaborados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo_devengado")
    private double sueldoDevengado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "auxilio_transporte")
    private Double auxilioTransporte;
    @Column(name = "valor_horas_extras")
    private Double valorHorasExtras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_salud")
    private double descuentoSalud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_pension")
    private double descuentoPension;
    @Column(name = "descuento_fondo_solidaridad")
    private Double descuentoFondoSolidaridad;
    @Column(name = "otros_descuentos")
    private Double otrosDescuentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_devengado")
    private double totalDevengado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_descuento")
    private double totalDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "neto_pagar")
    private double netoPagar;
    @JoinColumn(name = "id_nomina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nomina idNomina;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public DetalleNomina() {
    }

    public DetalleNomina(Integer id) {
        this.id = id;
    }

    public DetalleNomina(Integer id, int diasLaborados, double sueldoDevengado, double descuentoSalud, double descuentoPension, double totalDevengado, double totalDescuento, double netoPagar) {
        this.id = id;
        this.diasLaborados = diasLaborados;
        this.sueldoDevengado = sueldoDevengado;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.totalDevengado = totalDevengado;
        this.totalDescuento = totalDescuento;
        this.netoPagar = netoPagar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public double getSueldoDevengado() {
        return sueldoDevengado;
    }

    public void setSueldoDevengado(double sueldoDevengado) {
        this.sueldoDevengado = sueldoDevengado;
    }

    public Double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(Double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public Double getValorHorasExtras() {
        return valorHorasExtras;
    }

    public void setValorHorasExtras(Double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }

    public double getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(double descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public double getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(double descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    public Double getDescuentoFondoSolidaridad() {
        return descuentoFondoSolidaridad;
    }

    public void setDescuentoFondoSolidaridad(Double descuentoFondoSolidaridad) {
        this.descuentoFondoSolidaridad = descuentoFondoSolidaridad;
    }

    public Double getOtrosDescuentos() {
        return otrosDescuentos;
    }

    public void setOtrosDescuentos(Double otrosDescuentos) {
        this.otrosDescuentos = otrosDescuentos;
    }

    public double getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(double totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public double getNetoPagar() {
        return netoPagar;
    }

    public void setNetoPagar(double netoPagar) {
        this.netoPagar = netoPagar;
    }

    public Nomina getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Nomina idNomina) {
        this.idNomina = idNomina;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof DetalleNomina)) {
            return false;
        }
        DetalleNomina other = (DetalleNomina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planilla.jpa.entities.DetalleNomina[ id=" + id + " ]";
    }
    
}
