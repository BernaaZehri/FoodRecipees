/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByRecipeID", query = "SELECT r FROM Recipe r WHERE r.recipeID = :recipeID"),
    @NamedQuery(name = "Recipe.findByTitle", query = "SELECT r FROM Recipe r WHERE r.title = :title"),
    @NamedQuery(name = "Recipe.findByRecipeNumber", query = "SELECT r FROM Recipe r WHERE r.recipeNumber = :recipeNumber"),
    @NamedQuery(name = "Recipe.findByCreationDate", query = "SELECT r FROM Recipe r WHERE r.creationDate = :creationDate"),
    @NamedQuery(name = "Recipe.findByCookingTime", query = "SELECT r FROM Recipe r WHERE r.cookingTime = :cookingTime"),
    @NamedQuery(name = "Recipe.findByCalories", query = "SELECT r FROM Recipe r WHERE r.calories = :calories"),
    @NamedQuery(name = "Recipe.findByCity", query = "SELECT r FROM Recipe r WHERE r.city = :city"),
    @NamedQuery(name = "Recipe.findByAuthorComment", query = "SELECT r FROM Recipe r WHERE r.authorComment = :authorComment"),
    @NamedQuery(name = "Recipe.findByRecipeDescription", query = "SELECT r FROM Recipe r WHERE r.recipeDescription = :recipeDescription"),
    @NamedQuery(name = "Recipe.addRating", query = "UPDATE Recipe r SET r.rating = 123 WHERE r.recipeNumber = 1 ")})

public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RecipeID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer recipeID;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "RecipeNumber")
    private int recipeNumber;
    @Basic(optional = false)
    @Column(name = "CreationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "CookingTime")
    private int cookingTime;
    @Basic(optional = false)
    @Column(name = "Calories")
    private int calories;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "AuthorComment")
    private String authorComment;
    @Basic(optional = false)
    @Column(name = "RecipeDescription")
    private String recipeDescription;
    @Column(name = "Rating")
    private int rating;
    @JoinColumn(name = "DifficultyID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Difficulty difficultyID;
    @JoinColumn(name = "PreparationWayID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PreparationWay preparationWayID;
    @JoinColumn(name = "RecipeCategoryID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RecipeCategory recipeCategoryID;
    @JoinColumn(name = "RecipeTypeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RecipeType recipeTypeID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Useri userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeID")
    private Collection<RecipeIngredient> recipeIngredientCollection;

    public Recipe() {
    }

    public Recipe(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Recipe(Integer recipeID, String title, int recipeNumber, Date creationDate, int cookingTime, int calories, String city, String authorComment, String recipeDescription, int recipeRating) {
        this.recipeID = recipeID;
        this.title = title;
        this.recipeNumber = recipeNumber;
        this.creationDate = creationDate;
        this.cookingTime = cookingTime;
        this.calories = calories;
        this.city = city;
        this.authorComment = authorComment;
        this.recipeDescription = recipeDescription;
        this.rating = recipeRating;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRecipeNumber() {
        return recipeNumber;
    }

    public void setRecipeNumber(int recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }
    
    public void setRecipeRating(int recipeRating)
    {
        this.rating = recipeRating;
    }
    
    public int getRecipeRating()
    {
        return rating;
    }

    public Difficulty getDifficultyID() {
        return difficultyID;
    }

    public void setDifficultyID(Difficulty difficultyID) {
        this.difficultyID = difficultyID;
    }

    public PreparationWay getPreparationWayID() {
        return preparationWayID;
    }

    public void setPreparationWayID(PreparationWay preparationWayID) {
        this.preparationWayID = preparationWayID;
    }

    public RecipeCategory getRecipeCategoryID() {
        return recipeCategoryID;
    }

    public void setRecipeCategoryID(RecipeCategory recipeCategoryID) {
        this.recipeCategoryID = recipeCategoryID;
    }

    public RecipeType getRecipeTypeID() {
        return recipeTypeID;
    }

    public void setRecipeTypeID(RecipeType recipeTypeID) {
        this.recipeTypeID = recipeTypeID;
    }

    public Useri getUserID() {
        return userID;
    }

    public void setUserID(Useri userID) {
        this.userID = userID;
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
        hash += (recipeID != null ? recipeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeID == null && other.recipeID != null) || (this.recipeID != null && !this.recipeID.equals(other.recipeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Recipe[ recipeID=" + recipeID + " ]";
    }
    
}
