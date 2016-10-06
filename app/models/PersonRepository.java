/**
 * Created by Rita Liang on 2016/4/29.
 */
package models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

// 存储过程和参数需要的类
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;

@Named
@Singleton
@Repository
public interface PersonRepository extends CrudRepository<Person, String>  {

    //@Procedure(name="report")
    //void report(@Param("idCardNo")String idCardNo);

    @Query("select person from Person person where person.idCardNo = ?1 and person.printNumber = 0")
    Person findByIdCardNo(String idCardNo);
}
