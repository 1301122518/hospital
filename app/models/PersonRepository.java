/**
 * Created by Rita Liang on 2016/4/29.
 */
package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.inject.Procedure;


@Named
@Singleton
public interface PersonRepository extends CrudRepository<Person, String>  {
    @Procedure(name="person_report")
    void personReport(@Param("idCardNo") String idCardNo);

}
