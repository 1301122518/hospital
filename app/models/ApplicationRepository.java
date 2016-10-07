/**
 * Created by Rita Liang on 2016/4/29.
 */
package models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
@Repository
public interface ApplicationRepository extends CrudRepository<Application, String>  {

    @Query(name="applies",
            value = "select distinct view_application.* " +
            "from view_person join view_application " +
            "on view_application.idCardNo = view_person.idCardNo " +
            "where view_person.idCardNo = ?1 and YEAR(view_application.applyTime) = YEAR(NOW())",
            nativeQuery = true)
    List<Application> findApplies(String idCardNo);

}
