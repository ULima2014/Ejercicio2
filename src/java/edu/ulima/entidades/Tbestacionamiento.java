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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "tbestacionamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbestacionamiento.findAll", query = "SELECT t FROM Tbestacionamiento t"),
    @NamedQuery(name = "Tbestacionamiento.findByPkeyestacionamiento", query = "SELECT t FROM Tbestacionamiento t WHERE t.pkeyestacionamiento = :pkeyestacionamiento"),
    @NamedQuery(name = "Tbestacionamiento.findByPiso", query = "SELECT t FROM Tbestacionamiento t WHERE t.piso = :piso"),
    @NamedQuery(name = "Tbestacionamiento.findByLote", query = "SELECT t FROM Tbestacionamiento t WHERE t.lote = :lote")})
public class Tbestacionamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pkeyestacionamiento")
    private Integer pkeyestacionamiento;
    @Column(name = "piso")
    private Integer piso;
    @Column(name = "lote")
    private Integer lote;
    @OneToOne(mappedBy = "fkeyestacionamiento")
    private Collection<Tbalumno> tbalumnoCollection;

    public Tbestacionamiento() {
    }

    public Tbestacionamiento(Integer pkeyestacionamiento) {
        this.pkeyestacionamiento = pkeyestacionamiento;
    }

    public Integer getPkeyestacionamiento() {
        return pkeyestacionamiento;
    }

    public void setPkeyestacionamiento(Integer pkeyestacionamiento) {
        this.pkeyestacionamiento = pkeyestacionamiento;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
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
        hash += (pkeyestacionamiento != null ? pkeyestacionamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbestacionamiento)) {
            return false;
        }
        Tbestacionamiento other = (Tbestacionamiento) object;
        if ((this.pkeyestacionamiento == null && other.pkeyestacionamiento != null) || (this.pkeyestacionamiento != null && !this.pkeyestacionamiento.equals(other.pkeyestacionamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ulima.entidades.Tbestacionamiento[ pkeyestacionamiento=" + pkeyestacionamiento + " ]";
    }
    
}
