package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

@Entity
@Table(name="department")
public class Department{
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String address;

    @ManyToMany(mappedBy="departments",fetch=FetchType.EAGER)
    public Set<Patient> patients = new HashSet<Patient>();

    public Department(){};

    public Department(Long id, String name, String address){

        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String toString(){
        return name;
    }
}