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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.ColumnResult;

import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="view_examination")
@SqlResultSetMapping(name="exams",
        entities = {
                @EntityResult(entityClass = Examination.class, fields={
                    @FieldResult(name="id", column="id"),
                        @FieldResult(name="idCardNo", column="idCardNo"),
                        @FieldResult(name="examDepartment", column="examDepartment"),
                        @FieldResult(name="examAddress", column="examAddress"),
                        @FieldResult(name="examItem", column="examItem"),
                        @FieldResult(name="admin", column="admin"),
                })
        }
)
public class Examination implements Serializable {
    
	@Id
    @GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
    public String id;

    public String idCardNo;

    public String examDepartment;

    public String examAddress;

    public String examItem;

    public String admin;

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
	
    public String toString(){
        return this.examItem + this.examDepartment + this.examAddress;
    }

//    hibernate自动一对多关联
//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
//    @JoinColumn(name = "idCardNo",  referencedColumnName="idCardNo", insertable = false, updatable = false)
//    public Person person;
}
