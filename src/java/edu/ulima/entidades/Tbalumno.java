/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "tbalumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbalumno.findAll", query = "SELECT t FROM Tbalumno t"),
    @NamedQuery(name = "Tbalumno.findById", query = "SELECT t FROM Tbalumno t WHERE t.id = :id"),
    @NamedQuery(name = "Tbalumno.findByNombre", query = "SELECT t FROM Tbalumno t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tbalumno.findByApellido", query = "SELECT t FROM Tbalumno t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "Tbalumno.findBySexo", query = "SELECT t FROM Tbalumno t WHERE t.sexo = :sexo"),
    @NamedQuery(name = "Tbalumno.findByPassword", query = "SELECT t FROM Tbalumno t WHERE t.password = :password")})
public class Tbalumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "fkeyestacionamiento", referencedColumnName = "pkeyestacionamiento")
    @OneToOne
    private Tbestacionamiento fkeyestacionamiento;
    @JoinColumn(name = "fkeycarrera", referencedColumnName = "pkeycarrera")
    @ManyToOne
    private Tbcarrera fkeycarrera;

    public Tbalumno() {
    }

    public Tbalumno(Integer id) {
        this.id = id;
    }

    public Tbalumno(Integer id, String nombre, String apellido, String sexo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tbestacionamiento getFkeyestacionamiento() {
        return fkeyestacionamiento;
    }

    public void setFkeyestacionamiento(Tbestacionamiento fkeyestacionamiento) {
        this.fkeyestacionamiento = fkeyestacionamiento;
    }

    public Tbcarrera getFkeycarrera() {
        return fkeycarrera;
    }

    public void setFkeycarrera(Tbcarrera fkeycarrera) {
        this.fkeycarrera = fkeycarrera;
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
        if (!(object instanceof Tbalumno)) {
            return false;
        }
        Tbalumno other = (Tbalumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mains.Tbalumno[ id=" + id + " ]";
    }
    
}
