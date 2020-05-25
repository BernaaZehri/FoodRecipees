/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PreparationWay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreparationWay.findAll", query = "SELECT p FROM PreparationWay p"),
    @NamedQuery(name = "PreparationWay.findById", query = "SELECT p FROM PreparationWay p WHERE p.id = :id"),
    @NamedQuery(name = "PreparationWay.findByPreparationWayDescription", query = "SELECT p FROM PreparationWay p WHERE p.preparationWayDescription = :preparationWayDescription")})
public class PreparationWay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PreparationWayDescription")
    private String preparationWayDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparationWayID")
    private Collection<Recipe> recipeCollection;

    public PreparationWay() {
    }

    public PreparationWay(Integer id) {
        this.id = id;
    }

    public PreparationWay(Integer id, String preparationWayDescription) {
        this.id = id;
        this.preparationWayDescription = preparationWayDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreparationWayDescription() {
        return preparationWayDescription;
    }

    public void setPreparationWayDescription(String preparationWayDescription) {
        this.preparationWayDescription = preparationWayDescription;
    }

    @XmlTransient
    public Collection<Recipe> getRecipeCollection() {
        return recipeCollection;
    }

    public void setRecipeCollection(Collection<Recipe> recipeCollection) {
        this.recipeCollection = recipeCollection;
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
        if (!(object instanceof PreparationWay)) {
            return false;
        }
        PreparationWay other = (PreparationWay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return preparationWayDescription;
    }
    
}
