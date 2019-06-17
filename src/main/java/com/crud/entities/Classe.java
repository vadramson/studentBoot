/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vadrama
 */
@Entity
@Table(name = "classe", catalog = "student", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findByIdClasse", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse")
    , @NamedQuery(name = "Classe.findByClasCode", query = "SELECT c FROM Classe c WHERE c.clasCode = :clasCode")
    , @NamedQuery(name = "Classe.findByClasName", query = "SELECT c FROM Classe c WHERE c.clasName = :clasName")
    , @NamedQuery(name = "Classe.findByMaxNum", query = "SELECT c FROM Classe c WHERE c.maxNum = :maxNum")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClasse")
    private Integer idClasse;
    @Size(max = 254)
    @Column(name = "clasCode")
    private String clasCode;
    @Size(max = 254)
    @Column(name = "clasName")
    private String clasName;
    @Column(name = "maxNum")
    private Integer maxNum;
    @JoinColumn(name = "idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne(optional = false)
    private Department idDepartment;
    @OneToMany(mappedBy = "idClasse")
    private List<Students> studentsList;

    public Classe() {
    }

    public Classe(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public String getClasCode() {
        return clasCode;
    }

    public void setClasCode(String clasCode) {
        this.clasCode = clasCode;
    }

    public String getClasName() {
        return clasName;
    }

    public void setClasName(String clasName) {
        this.clasName = clasName;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Department getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Department idDepartment) {
        this.idDepartment = idDepartment;
    }

    @XmlTransient
    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crud.entities.Classe[ idClasse=" + idClasse + " ]";
    }
    
}
