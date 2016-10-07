package models;
/**
 * Created by Rita Liang on 2016/4/29.
 */
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="view_person")

public class Person implements Serializable{

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    public String id;

    public String idCardNo;

    public String organization;

    public String name;

    public String gender;

    public String age;

    public String tel;

    public String marryStatus;

    public Integer examImage;

    public String address;

    public Integer printNumber;

    public Person(){};

    public Person(String id, String idCardNo, String organisation, String name,
                  String gender, String age, String tel,
                String marryStatus, Integer examImage,String address, Integer printNumber){
        this.id = id;
        this.idCardNo = idCardNo;
        this.organization = organisation;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.marryStatus = marryStatus;
        this.examImage = examImage;
        this.address = address;
        this.printNumber = printNumber;
    }

    public String toString(){
        return this.id + "  " + this.name;
    }

    /*
    指引单上的一些属性信息，没有使用到，在这里先注释。
    病人对指引单，签字单的一对多方法因为都用到了SQL原生代码，
    所以将其注释。

    public String examID;
    public String examImage;
    public String applyID;
    public String applyImage;
    public Integer cost;
    public Integer allCost;

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public List<Examination> exams = new ArrayList<Examination>();

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public Set<Application> applies = new HashSet<Application>();
    */
}
