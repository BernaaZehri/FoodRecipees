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
@Table(name = "RecipeType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeType.findAll", query = "SELECT r FROM RecipeType r"),
    @NamedQuery(name = "RecipeType.findById", query = "SELECT r FROM RecipeType r WHERE r.id = :id"),
    @NamedQuery(name = "RecipeType.findByRecipeTypeDescription", query = "SELECT r FROM RecipeType r WHERE r.recipeTypeDescription = :recipeTypeDescription")})
public class RecipeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Column(name = "RecipeTypeDescription")
    private String recipeTypeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeTypeID")
    private Collection<Recipe> recipeCollection;

    public RecipeType() {
    }

    public RecipeType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeTypeDescription() {
        return recipeTypeDescription;
    }

    public void setRecipeTypeDescription(String recipeTypeDescription) {
        this.recipeTypeDescription = recipeTypeDescription;
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
        if (!(object instanceof RecipeType)) {
            return false;
        }
        RecipeType other = (RecipeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return recipeTypeDescription;
    }
    
}
