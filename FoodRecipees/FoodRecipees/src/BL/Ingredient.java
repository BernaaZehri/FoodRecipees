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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Ingredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i"),
    @NamedQuery(name = "Ingredient.findByIngredientID", query = "SELECT i FROM Ingredient i WHERE i.ingredientID = :ingredientID"),
    @NamedQuery(name = "Ingredient.findByTitle", query = "SELECT i FROM Ingredient i WHERE i.title = :title")})
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IngredientID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer ingredientID;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @JoinColumn(name = "IngredientCategoryID", referencedColumnName = "IngredientCategoryID")
    @ManyToOne(optional = false)
    private IngredientCategory ingredientCategoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredientID")
    private Collection<RecipeIngredient> recipeIngredientCollection;

    public Ingredient() {
    }

    public Ingredient(Integer ingredientID) {
        this.ingredientID = ingredientID;
    }

    public Ingredient(Integer ingredientID, String title) {
        this.ingredientID = ingredientID;
        this.title = title;
    }

    public Integer getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Integer ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IngredientCategory getIngredientCategoryID() {
        return ingredientCategoryID;
    }

    public void setIngredientCategoryID(IngredientCategory ingredientCategoryID) {
        this.ingredientCategoryID = ingredientCategoryID;
    }

    @XmlTransient
    public Collection<RecipeIngredient> getRecipeIngredientCollection() {
        return recipeIngredientCollection;
    }

    public void setRecipeIngredientCollection(Collection<RecipeIngredient> recipeIngredientCollection) {
        this.recipeIngredientCollection = recipeIngredientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientID != null ? ingredientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientID == null && other.ingredientID != null) || (this.ingredientID != null && !this.ingredientID.equals(other.ingredientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
