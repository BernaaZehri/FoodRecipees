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
@Table(name = "UnitDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitDetails.findAll", query = "SELECT u FROM UnitDetails u"),
    @NamedQuery(name = "UnitDetails.findByUnitDetailsID", query = "SELECT u FROM UnitDetails u WHERE u.unitDetailsID = :unitDetailsID"),
    @NamedQuery(name = "UnitDetails.findByTitle", query = "SELECT u FROM UnitDetails u WHERE u.title = :title")})
public class UnitDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UnitDetailsID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer unitDetailsID;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @JoinColumn(name = "UnitID", referencedColumnName = "UnitID")
    @ManyToOne(optional = false)
    private Unit unitID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitDetailsID")
    private Collection<RecipeIngredient> recipeIngredientCollection;

    public UnitDetails() {
    }

    public UnitDetails(Integer unitDetailsID) {
        this.unitDetailsID = unitDetailsID;
    }

    public UnitDetails(Integer unitDetailsID, String title) {
        this.unitDetailsID = unitDetailsID;
        this.title = title;
    }

    public Integer getUnitDetailsID() {
        return unitDetailsID;
    }

    public void setUnitDetailsID(Integer unitDetailsID) {
        this.unitDetailsID = unitDetailsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Unit getUnitID() {
        return unitID;
    }

    public void setUnitID(Unit unitID) {
        this.unitID = unitID;
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
        hash += (unitDetailsID != null ? unitDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitDetails)) {
            return false;
        }
        UnitDetails other = (UnitDetails) object;
        if ((this.unitDetailsID == null && other.unitDetailsID != null) || (this.unitDetailsID != null && !this.unitDetailsID.equals(other.unitDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
