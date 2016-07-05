package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import models.*;
import tools.*;
import play.mvc.*;
import play.data.DynamicForm;
import play.data.Form;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {

    private final PersonRepository personRepository;
    private Barcode barcode;

    @Inject
    public Application(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Result index() {

        String welcome = "欢迎来泸州市人民医院参加体检。";
        return ok(views.html.index.render(welcome));
    }

    public Person getPerson(String idCardNo){
        Person person = personRepository.findOne(idCardNo);
        //personRepository.report(idCardNo);
        barcode = new Barcode(person.examImage.toString());
        barcode.getBarCode();
        return person;
    }

    public Result guideDemo() {

        String testID =null;
        //testID = "51018419880821006X";
//        testID = "510503198901295276";
        if(testID==null){
            return ok(views.html.disappear.render("没有您的档案，请联系工作人员。"));
        }

        final Person person = getPerson(testID);
        List<Examination> exams =  person.exams;

        return ok(views.html.guide.render(person, person.getExams(), person.hasApply()));
    }

    public Result guide() {

        DynamicForm values = Form.form().bindFromRequest();
        String idCardNo = values.data().get("tcardID");

        if(idCardNo==null){
            return ok(views.html.disappear.render("没有您的档案，请联系工作人员。"));
        }

        final Person person = getPerson(idCardNo);

        return ok(views.html.guide.render(person, person.getExams(), person.hasApply()));
    }

    public Result apply(String idCardNo) {

        final Person retrievedPerson = personRepository.findOne(idCardNo);
        final Iterator applySet = retrievedPerson.applies.iterator();
        final List<models.Application> applies = new ArrayList<models.Application>();

        while(applySet.hasNext()){
            models.Application apply = (models.Application) applySet.next();
            applies.add(apply);
        }

        return ok(views.html.apply.render(retrievedPerson, applies));
    }

}
