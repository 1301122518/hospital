package models;
/**
 * Created by Rita Liang on 2016/4/29.
 */
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import javax.persistence.FetchType;

@Entity
@Table(name="person")
public class Person implements Serializable{

    @Id
    @GeneratedValue
    public Long id;

    public String idCardNo;

    public String organisation;

    public String name;

    public String gender;

    public Integer age;

    public String tel;

    public String marryStatus;

    public String examID;

    public String examImage;

    public String applyID;

    public String applyImage;

    public Integer cost;

    public Integer allCost;

    public String address;

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public Set<Examination> exams = new HashSet<Examination>();

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public Set<Application> applies = new HashSet<Application>();

    public Person(){};

    public Person(Long id, String idCardNo, String organisation, String name,
                  String gender, Integer age, String tel, String marryStatus, String examID,
                  String examImage, String applyID, String applyImage, Integer cost, Integer allCost,String address){
        this.id = id;
        this.idCardNo = idCardNo;
        this.organisation = organisation;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.marryStatus = marryStatus;
        this.examID = examID;
        this.examImage = examImage;
        this.applyID = applyID;
        this.applyImage = applyImage;
        this.cost = cost;
        this.allCost = allCost;
        this.address=address;
    }

    public String toString(){
        return this.idCardNo + "  " + this.name;
    }

}
