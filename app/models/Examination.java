package models;
/**
 * Created by Rita Liang on 2016/4/29.
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Entity
@Table(name="examination")
public class Examination implements Serializable {
    @Id
    @GeneratedValue
    public Long id;

    public String idCardNo;

    public String examDepartment;

    public String examAddress;

    public String examItem;

    public String admin;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "idCardNo", referencedColumnName="idCardNo", insertable = false, updatable = false)
    public Person person;

    public Examination(){};

    public Examination(Long id, String idCardNo, String examDepartment,
                       String examAddress, String examItem, String admin){
        this.id = id;
        this.idCardNo = idCardNo;
        this.examDepartment = examDepartment;
        this.examAddress = examAddress;
        this.examItem = examItem;
        this.admin = admin;
    }

    public String toString(){
        return this.examItem + this.examDepartment + this.examAddress;
    }
}
