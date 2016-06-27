package models;
/**
 * Created by Rita Liang on 2016/4/29.
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="view_examination")
public class Examination implements Serializable {
    
	@Id
    @GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
    public String id;
//	@Id
//	@GeneratedValue(generator="uuid")
//    @GenericGenerator(name="uuid", strategy="uuid")
//	@Column(name="idCardNo")
    public String idCardNo;

    public String examDepartment;

    public String examAddress;

    public String examItem;

    public String admin;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "idCardNo",  insertable = false, updatable = false)
    public Person person;

    public Examination(){};

     public Examination(String id, String idCardNo, String examDepartment,
                       String examAddress, String examItem, String admin){
        this.id = id;
        this.idCardNo = idCardNo;
        this.examDepartment = examDepartment;
        this.examAddress = examAddress;
        this.examItem = examItem;
        this.admin = admin;
    }
	
//	    public Examination(String idCardNo, String examDepartment,
//                       String examAddress, String examItem, String admin){
//        this.id = id;
//        this.examDepartment = examDepartment;
//        this.examAddress = examAddress;
//        this.examItem = examItem;
//        this.admin = admin;
//    }

    public String toString(){
        return this.examItem + this.examDepartment + this.examAddress;
    }
}
