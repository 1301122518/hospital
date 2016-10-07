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
public interface ExaminationRepository extends CrudRepository<Examination, String>  {

//    @Query(name="exams",
//            value = "select distinct view_examination.* " +
//                    " from view_person join view_examination " +
//                    "on view_examination.idCardNo = view_person.idCardNo " +
//                    "where view_person.idCardNo = ?1 and YEAR(view_examination.applyTime) = YEAR(NOW())",
//            nativeQuery = true)
    @Query(name="exams",
            value = "select distinct view_examination.* " +
                    " from view_person join view_examination " +
                    "on view_examination.idCardNo = view_person.idCardNo " +
                    "where view_person.idCardNo = ?1",
            nativeQuery = true)
    List<Examination> findExams(String idCardNo);

}
