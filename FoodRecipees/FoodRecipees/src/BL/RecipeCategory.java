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
@Table(name = "RecipeCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeCategory.findAll", query = "SELECT r FROM RecipeCategory r"),
    @NamedQuery(name = "RecipeCategory.findById", query = "SELECT r FROM RecipeCategory r WHERE r.id = :id"),
    @NamedQuery(name = "RecipeCategory.findByRecipeCategoryDescription", query = "SELECT r FROM RecipeCategory r WHERE r.recipeCategoryDescription = :recipeCategoryDescription")})
public class RecipeCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    @Column(name = "RecipeCategoryDescription")
    private String recipeCategoryDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeCategoryID")
    private Collection<Recipe> recipeCollection;

    public RecipeCategory() {
    }

    public RecipeCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeCategoryDescription() {
        return recipeCategoryDescription;
    }

    public void setRecipeCategoryDescription(String recipeCategoryDescription) {
        this.recipeCategoryDescription = recipeCategoryDescription;
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
        if (!(object instanceof RecipeCategory)) {
            return false;
        }
        RecipeCategory other = (RecipeCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return recipeCategoryDescription;
    }
    
}
