package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.FetchType;

/**
 * This declares a model object for persistence usage. Model objects are generally anaemic structures that represent
 * the database entity. Behaviour associated with instances of a model class are also captured, but behaviours
 * associated with collections of these model objects belong to the PersonRepository e.g. findOne, findAll etc.
 * Play Java will synthesise getter and setter methods for us and therefore keep JPA happy (JPA expects them).
 */
@Entity
@Table(name="Patient")
public class Patient{
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String gender;

    public Integer age;

    public String idCardNo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="patient_department", joinColumns=@JoinColumn(name="patient_id"),
                inverseJoinColumns=@JoinColumn(name="department_id"))
    public Set<Department> departments = new HashSet<Department>();

    public Patient(){};

    public Patient(Long id, String name, String gender, Integer age, String idCardNo){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.idCardNo = idCardNo;
    }

    public String toString(){
        return "体检人员身份证号: " + this.idCardNo + "  姓名: " + this.name;
    }
}
