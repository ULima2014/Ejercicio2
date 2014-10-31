/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author bryan
 */
@Entity
@Table(name = "tbcarrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcarrera.findAll", query = "SELECT t FROM Tbcarrera t"),
    @NamedQuery(name = "Tbcarrera.findByPkeycarrera", query = "SELECT t FROM Tbcarrera t WHERE t.pkeycarrera = :pkeycarrera"),
    @NamedQuery(name = "Tbcarrera.findByNombre", query = "SELECT t FROM Tbcarrera t WHERE t.nombre = :nombre")})
public class Tbcarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pkeycarrera")
    private Integer pkeycarrera;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "fkeycarrera")
    private Collection<Tbalumno> tbalumnoCollection;

    public Tbcarrera() {
    }

    public Tbcarrera(Integer pkeycarrera) {
        this.pkeycarrera = pkeycarrera;
    }

    public Integer getPkeycarrera() {
        return pkeycarrera;
    }

    public void setPkeycarrera(Integer pkeycarrera) {
        this.pkeycarrera = pkeycarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Tbalumno> getTbalumnoCollection() {
        return tbalumnoCollection;
    }

    public void setTbalumnoCollection(Collection<Tbalumno> tbalumnoCollection) {
        this.tbalumnoCollection = tbalumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkeycarrera != null ? pkeycarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcarrera)) {
            return false;
        }
        Tbcarrera other = (Tbcarrera) object;
        if ((this.pkeycarrera == null && other.pkeycarrera != null) || (this.pkeycarrera != null && !this.pkeycarrera.equals(other.pkeycarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ulima.entidades.Tbcarrera[ pkeycarrera=" + pkeycarrera + " ]";
    }
    
}
