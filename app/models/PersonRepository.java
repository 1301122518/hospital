/**
 * Created by Rita Liang on 2016/4/29.
 */
package models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.inject.Named;
import javax.inject.Singleton;
@Named
@Singleton
public interface PersonRepository extends CrudRepository<Person, String>  {

    @Procedure(name="report")
    void report(@Param("idCardNo")String idCardNo);

}
