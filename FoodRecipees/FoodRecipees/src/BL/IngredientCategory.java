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
@Table(name = "IngredientCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngredientCategory.findAll", query = "SELECT i FROM IngredientCategory i"),
    @NamedQuery(name = "IngredientCategory.findByIngredientCategoryID", query = "SELECT i FROM IngredientCategory i WHERE i.ingredientCategoryID = :ingredientCategoryID"),
    @NamedQuery(name = "IngredientCategory.findByTitle", query = "SELECT i FROM IngredientCategory i WHERE i.title = :title")})
public class IngredientCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IngredientCategoryID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer ingredientCategoryID;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredientCategoryID")
    private Collection<Ingredient> ingredientCollection;

    public IngredientCategory() {
    }

    public IngredientCategory(Integer ingredientCategoryID) {
        this.ingredientCategoryID = ingredientCategoryID;
    }

    public IngredientCategory(Integer ingredientCategoryID, String title) {
        this.ingredientCategoryID = ingredientCategoryID;
        this.title = title;
    }

    public Integer getIngredientCategoryID() {
        return ingredientCategoryID;
    }

    public void setIngredientCategoryID(Integer ingredientCategoryID) {
        this.ingredientCategoryID = ingredientCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<Ingredient> getIngredientCollection() {
        return ingredientCollection;
    }

    public void setIngredientCollection(Collection<Ingredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientCategoryID != null ? ingredientCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientCategory)) {
            return false;
        }
        IngredientCategory other = (IngredientCategory) object;
        if ((this.ingredientCategoryID == null && other.ingredientCategoryID != null) || (this.ingredientCategoryID != null && !this.ingredientCategoryID.equals(other.ingredientCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
