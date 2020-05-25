/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "RecipeIngredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeIngredient.findAll", query = "SELECT r FROM RecipeIngredient r"),
    @NamedQuery(name = "RecipeIngredient.findByRecipeIngredientID", query = "SELECT r FROM RecipeIngredient r WHERE r.recipeIngredientID = :recipeIngredientID"),
    @NamedQuery(name = "RecipeIngredient.findByQuantity", query = "SELECT r FROM RecipeIngredient r WHERE r.quantity = :quantity")})
public class RecipeIngredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RecipeIngredientID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer recipeIngredientID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Quantity")
    private BigDecimal quantity;
    @JoinColumn(name = "IngredientID", referencedColumnName = "IngredientID")
    @ManyToOne
    private Ingredient ingredientID;
    @JoinColumn(name = "RecipeID", referencedColumnName = "RecipeID")
    @ManyToOne
    private Recipe recipeID;
    @JoinColumn(name = "UnitDetailsID", referencedColumnName = "UnitDetailsID")
    @ManyToOne(optional = false)
    private UnitDetails unitDetailsID;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Integer recipeIngredientID) {
        this.recipeIngredientID = recipeIngredientID;
    }

    public RecipeIngredient(Integer recipeIngredientID, BigDecimal quantity) {
        this.recipeIngredientID = recipeIngredientID;
        this.quantity = quantity;
    }

    public Integer getRecipeIngredientID() {
        return recipeIngredientID;
    }

    public void setRecipeIngredientID(Integer recipeIngredientID) {
        this.recipeIngredientID = recipeIngredientID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Ingredient getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Ingredient ingredientID) {
        this.ingredientID = ingredientID;
    }

    public Recipe getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Recipe recipeID) {
        this.recipeID = recipeID;
    }

    public UnitDetails getUnitDetailsID() {
        return unitDetailsID;
    }

    public void setUnitDetailsID(UnitDetails unitDetailsID) {
        this.unitDetailsID = unitDetailsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeIngredientID != null ? recipeIngredientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeIngredient)) {
            return false;
        }
        RecipeIngredient other = (RecipeIngredient) object;
        if ((this.recipeIngredientID == null && other.recipeIngredientID != null) || (this.recipeIngredientID != null && !this.recipeIngredientID.equals(other.recipeIngredientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ingredientID + " ";
    }
    
}
