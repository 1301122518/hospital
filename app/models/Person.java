package models;
/**
 * Created by Rita Liang on 2016/4/29.
 */
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="view_person")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "person_report", procedureName = "hospital.person_report", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "idCardNo", type = String.class) })
})
public class Person implements Serializable{

//    @Id
//    @GeneratedValue
//    public Long ;

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    @Column(name="idCardNo")
    public String id;

    public String organization;

    public String name;

    public String gender;

    public String age;

    public String tel;

    public String marryStatus;

    //public String examID;

   // public String examImage;
	public Integer examImage;

    //public String applyID;

    //public String applyImage;

    //public Integer cost;

    //public Integer allCost;

    public String address;

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public Set<Examination> exams = new HashSet<Examination>();

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    public Set<Application> applies = new HashSet<Application>();

    public Person(){};

/*     public Person(String id,  String organisation, String name,
                  String gender, Integer age, String tel, String marryStatus, String examID,
                  String examImage, String applyID, String applyImage, Integer cost, Integer allCost,String address){
        this.id = id;
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
 */
 
  public Person(String id,  String organisation, String name,
                  String gender, String age, String tel, String marryStatus, Integer examImage,String address){
        this.id = id;
        this.organization = organisation;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.marryStatus = marryStatus;
        this.examImage = examImage;
        this.address=address;
    }
    public String toString(){
        return this.id + "  " + this.name;
    }

}
