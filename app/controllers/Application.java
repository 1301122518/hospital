package controllers;

import java.util.*;

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
    private final ExaminationRepository examRepository;
    private final ApplicationRepository applyRepository;
    private Barcode barcode;

    @Inject
    public Application(final PersonRepository personRepository,
                       final ExaminationRepository examRepository,
                       final ApplicationRepository applyRepository) {
        this.personRepository = personRepository;
        this.examRepository = examRepository;
        this.applyRepository = applyRepository;
    }

    public Result index() {
        String welcome = "欢迎来泸州市人民医院参加体检。";
        return ok(views.html.index.render(welcome));
    }

    public Person getPerson(String idCardNo){

        Person person;

        try {
            person = personRepository.findByIdCardNo(idCardNo);
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
        testID = "51018419880821006X";
//        testID = "510503198901295276";

        final Person person = getPerson(testID);

//        if(person.id==null){
//            return ok(views.html.disappear.render("没有您的档案，请联系工作人员。"));
//        }
//
//        if(person.printNumber==0){
//            person.printNumber = 1;
//            personRepository.save(person);
//        }else {
//            return ok(views.html.disappear.render("您的档案已经打印，不能二次打印。"));
//        }
        List<Examination> exams = examRepository.findExams(person.idCardNo);
        List<models.Application> applies = applyRepository.findApplies(person.idCardNo);

        return ok(views.html.guide.render(person, exams, applies.size()));
    }

    public Result guide() {

        DynamicForm values = Form.form().bindFromRequest();
        String idCardNo = values.data().get("tcardID");

        final Person person = getPerson(idCardNo);

        if(person.id==null){
            return ok(views.html.disappear.render("没有您的档案，或者您的档案已经被打印,不能进行二次打印，请联系相关工作人员。"));
        }

        List<Examination> exams = examRepository.findExams(idCardNo);
        List<models.Application> applies = applyRepository.findApplies(idCardNo);

        if(applies.size() == 0){
            personRepository.savePerson(person.id);
        }

        return ok(views.html.guide.render(person, exams, applies.size()));
    }

    public Result apply(String idCardNo) {

        Person person = personRepository.findByIdCardNo(idCardNo);
        List<models.Application> applies = applyRepository.findApplies(idCardNo);

        TreeMap<String, List<models.Application>> tm = new TreeMap<String, List<models.Application>>();

          for(models.Application app:applies){
            if(tm.containsKey(app.applyDepartment)){
                ArrayList<models.Application> templist = (ArrayList<models.Application>)tm.get(app.applyDepartment);
                templist.add(app);
            }else{
                ArrayList<models.Application> templist = new ArrayList<models.Application>();
                templist.add(app);
                tm.put(app.applyDepartment, templist);
            }
        }

        personRepository.savePerson(person.id);
        return ok(views.html.apply.render(person, tm));
    }

}
