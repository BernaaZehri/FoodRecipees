package BL;

import BL.Difficulty;
import BL.PreparationWay;
import BL.RecipeCategory;
import BL.RecipeIngredient;
import BL.RecipeType;
import BL.Useri;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T07:44:25")
@StaticMetamodel(Recipe.class)
public class Recipe_ { 

    public static volatile SingularAttribute<Recipe, PreparationWay> preparationWayID;
    public static volatile CollectionAttribute<Recipe, RecipeIngredient> recipeIngredientCollection;
    public static volatile SingularAttribute<Recipe, String> city;
    public static volatile SingularAttribute<Recipe, String> recipeDescription;
    public static volatile SingularAttribute<Recipe, Integer> rating;
    public static volatile SingularAttribute<Recipe, String> authorComment;
    public static volatile SingularAttribute<Recipe, Integer> calories;
    public static volatile SingularAttribute<Recipe, String> title;
    public static volatile SingularAttribute<Recipe, Date> creationDate;
    public static volatile SingularAttribute<Recipe, Useri> userID;
    public static volatile SingularAttribute<Recipe, Integer> recipeID;
    public static volatile SingularAttribute<Recipe, Integer> cookingTime;
    public static volatile SingularAttribute<Recipe, Integer> recipeNumber;
    public static volatile SingularAttribute<Recipe, RecipeCategory> recipeCategoryID;
    public static volatile SingularAttribute<Recipe, Difficulty> difficultyID;
    public static volatile SingularAttribute<Recipe, RecipeType> recipeTypeID;

}