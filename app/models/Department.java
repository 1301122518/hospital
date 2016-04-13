package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

@Entity
public class Department{
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String address;

    @ManyToMany(mappedBy="departments",fetch=FetchType.EAGER)
    public Set<Patient> patients = new HashSet<Patient>();
}