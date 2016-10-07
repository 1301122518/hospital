/**
 * Created by Rita Liang on 2016/4/30.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
@Table(name="view_application")
@SqlResultSetMapping(name="applies",
        entities = {
                @EntityResult(entityClass = Examination.class, fields={
                        @FieldResult(name="id", column="id"),
                        @FieldResult(name="idCardNo", column="idCardNo"),
                        @FieldResult(name="applyItem", column="applyItem"),
                        @FieldResult(name="signDoctor", column="signDoctor"),
                        @FieldResult(name="applyDepartment", column="applyDepartment"),
                        @FieldResult(name="applyTime", column="applyTime"),
                        @FieldResult(name="examAddress", column="examAddress")
                })
        }
)
public class Application implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
    public String id;

    public String idCardNo;

    public String applyItem;

    public String signDoctor;

    public String applyDepartment;


	public String applyTime;
    /*
     *  applyTime本该是Date类型，医院默认是String类型。
     */
	
    public String examAddress;

    public Application(){};

    public Application(String id, String idCardNo, String applyItem, String signDoctor,
                       String applyDepartment, String applyTime, String examAddress){
        this.id = id;
		this.idCardNo = idCardNo;
        this.applyItem = applyItem;
        this.signDoctor = signDoctor;
        this.applyDepartment = applyDepartment;
        this.applyTime = applyTime;
        this.examAddress = examAddress;
    }

    public String toString(){
        return this.applyItem + "  " + this.signDoctor;
    }

/*
一对多关联
 */
//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
//    @JoinColumn(name = "idCardNo",  referencedColumnName="idCardNo", insertable = false, updatable = false)
//    public Person person;
}
