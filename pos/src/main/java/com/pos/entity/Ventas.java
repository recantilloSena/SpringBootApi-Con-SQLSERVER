/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RICARDO
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVentas", query = "SELECT v FROM Ventas v WHERE v.idVentas = :idVentas")
    , @NamedQuery(name = "Ventas.findByNumeroVenta", query = "SELECT v FROM Ventas v WHERE v.numeroVenta = :numeroVenta")
    , @NamedQuery(name = "Ventas.findByDocuemnto", query = "SELECT v FROM Ventas v WHERE v.fkCliente.documento = :documento ")    
    , @NamedQuery(name = "Ventas.findByFkFormaDePago", query = "SELECT v FROM Ventas v WHERE v.fkFormaDePago = :fkFormaDePago")
    , @NamedQuery(name = "Ventas.findByTotalVenta", query = "SELECT v FROM Ventas v WHERE v.totalVenta = :totalVenta")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id_ventas")
    private Integer idVentas;
    @Size(max = 50)
    @Column(name = "numero_venta")
    private String numeroVenta;
    @Column(name = "fk_forma_de_pago")
    private Integer fkFormaDePago;
    @Column(name = "total_venta")
    private Integer totalVenta;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes fkCliente;

    public Ventas() {
    }

    public Ventas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Integer getFkFormaDePago() {
        return fkFormaDePago;
    }

    public void setFkFormaDePago(Integer fkFormaDePago) {
        this.fkFormaDePago = fkFormaDePago;
    }

    public Integer getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Integer totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Clientes getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Clientes fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.Ventas[ idVentas=" + idVentas + " ]";
    }
    
}
