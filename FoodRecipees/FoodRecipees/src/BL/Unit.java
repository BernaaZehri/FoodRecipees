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
@Table(name = "Unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findByUnitID", query = "SELECT u FROM Unit u WHERE u.unitID = :unitID"),
    @NamedQuery(name = "Unit.findByTitle", query = "SELECT u FROM Unit u WHERE u.title = :title")})
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UnitID")
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer unitID;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitID")
    private Collection<UnitDetails> unitDetailsCollection;

    public Unit() {
    }

    public Unit(Integer unitID) {
        this.unitID = unitID;
    }

    public Unit(Integer unitID, String title) {
        this.unitID = unitID;
        this.title = title;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<UnitDetails> getUnitDetailsCollection() {
        return unitDetailsCollection;
    }

    public void setUnitDetailsCollection(Collection<UnitDetails> unitDetailsCollection) {
        this.unitDetailsCollection = unitDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitID != null ? unitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitID == null && other.unitID != null) || (this.unitID != null && !this.unitID.equals(other.unitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
