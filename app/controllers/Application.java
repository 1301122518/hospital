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

        Person person;

        try {
            person = personRepository.findOne(idCardNo);
            barcode = new Barcode(person.examImage.toString());
            barcode.getBarCode();
        }catch(Exception e){
            person = new Person();
            person.id = null;
        }

        return person;
    }

    public Result guideDemo() {

        String testID =null;
        //testID = "51018419880821006X";
//        testID = "510503198901295276";

        final Person person = getPerson(testID);

        if(person.id==null){
            return ok(views.html.disappear.render("没有您的档案，请联系工作人员。"));
        }

        return ok(views.html.guide.render(person, person.getExams(), person.hasApply()));
    }

    public Result guide() {

        DynamicForm values = Form.form().bindFromRequest();
        String idCardNo = values.data().get("tcardID");

        final Person person = getPerson(idCardNo);

        if(person.id==null){
            return ok(views.html.disappear.render("没有您的档案，请联系工作人员。"));
        }

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
