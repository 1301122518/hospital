/**
 * Created by Rita Liang on 2016/4/29.
 */
package models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.ColumnResult;
// 存储过程和参数需要的类
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;

@Named
@Singleton
@Repository
public interface PersonRepository extends CrudRepository<Person, String>  {

    //@Procedure(name="report")
    //void report(@Param("idCardNo")String idCardNo);

    @Query("select person from Person person where person.idCardNo = ?1 and person.printNumber = null")
    Person findByIdCardNo(String idCardNo);

    @Query(name="exams",
            value = "select distinct view_examination.* " +
            " from view_person join view_examination " +
            "on view_examination.idCardNo = view_person.idCardNo " +
            "where view_person.idCardNo = ?1 and YEAR(view_examination.applyTime) = YEAR(NOW())",
            nativeQuery = true)
    List<Examination> findExams(String idCardNo);

}
