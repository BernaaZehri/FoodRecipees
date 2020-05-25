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
@Table(name = "Useri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useri.findAll", query = "SELECT u FROM Useri u"),
    @NamedQuery(name = "Useri.findByUserID", query = "SELECT u FROM Useri u WHERE u.userID = :userID"),
    @NamedQuery(name = "Useri.findByName", query = "SELECT u FROM Useri u WHERE u.name = :name"),
    @NamedQuery(name = "Useri.findByLastName", query = "SELECT u FROM Useri u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Useri.findByBirthdayDate", query = "SELECT u FROM Useri u WHERE u.birthdayDate = :birthdayDate"),
    @NamedQuery(name = "Useri.findByEmail", query = "SELECT u FROM Useri u WHERE u.email = :email"),
    @NamedQuery(name = "Useri.findByUsername", query = "SELECT u FROM Useri u WHERE u.username = :username"),
    @NamedQuery(name = "Useri.findByPassword", query = "SELECT u FROM Useri u WHERE u.password = :password"),
    @NamedQuery(name = "Useri.findByGender", query = "SELECT u FROM Useri u WHERE u.gender = :gender")})
public class Useri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "BirthdayDate")
    @Temporal(TemporalType.DATE)
    private Date birthdayDate;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "Gender")
    private String gender;
    @OneToMany(mappedBy = "userID")
    private Collection<Recipe> recipeCollection;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne
    private Role roleID;

    public Useri() {
    }

    public Useri(Integer userID) {
        this.userID = userID;
    }

    public Useri(Integer userID, String name, String lastName, Date birthdayDate, String email, String username, String password) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlTransient
    public Collection<Recipe> getRecipeCollection() {
        return recipeCollection;
    }

    public void setRecipeCollection(Collection<Recipe> recipeCollection) {
        this.recipeCollection = recipeCollection;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useri)) {
            return false;
        }
        Useri other = (Useri) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
