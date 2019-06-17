/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vadrama
 */
@Entity
@Table(name = "students", catalog = "student", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByIdStudents", query = "SELECT s FROM Students s WHERE s.idStudents = :idStudents")
    , @NamedQuery(name = "Students.findByStuName", query = "SELECT s FROM Students s WHERE s.stuName = :stuName")
    , @NamedQuery(name = "Students.findByStuEmail", query = "SELECT s FROM Students s WHERE s.stuEmail = :stuEmail")
    , @NamedQuery(name = "Students.findByStuPhone", query = "SELECT s FROM Students s WHERE s.stuPhone = :stuPhone")
    , @NamedQuery(name = "Students.findByStuAddress", query = "SELECT s FROM Students s WHERE s.stuAddress = :stuAddress")
    , @NamedQuery(name = "Students.findByStuAge", query = "SELECT s FROM Students s WHERE s.stuAge = :stuAge")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStudents")
    private Integer idStudents;
    @Size(max = 254)
    @Column(name = "stuName")
    private String stuName;
    @Size(max = 254)
    @Column(name = "stuEmail")
    private String stuEmail;
    @Size(max = 254)
    @Column(name = "stuPhone")
    private String stuPhone;
    @Size(max = 254)
    @Column(name = "stuAddress")
    private String stuAddress;
    @Column(name = "stuAge")
    private Integer stuAge;
    @JoinColumn(name = "idClasse", referencedColumnName = "idClasse")
    @ManyToOne
    private Classe idClasse;

    public Students() {
    }

    public Students(Integer idStudents) {
        this.idStudents = idStudents;
    }

    public Integer getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(Integer idStudents) {
        this.idStudents = idStudents;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudents != null ? idStudents.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.idStudents == null && other.idStudents != null) || (this.idStudents != null && !this.idStudents.equals(other.idStudents))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crud.entities.Students[ idStudents=" + idStudents + " ]";
    }
    
}
