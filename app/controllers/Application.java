package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import models.*;
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

    @Inject
    public Application(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Result index() {

        String welcome = "欢迎来泸州市人民医院参加体检。";
        return ok(views.html.index.render(welcome));
    }

    public Result guide() {

        DynamicForm values = Form.form().bindFromRequest();
        String idCardNo = values.data().get("tcardID");

        if(idCardNo==null){
            //TODO:if cannot read the id card no ,it's shoule be redirect to other page.
        }

        final Person retrievedPerson = personRepository.findOne(idCardNo);
        final Iterator examSet = retrievedPerson.exams.iterator();
        final List<Examination> exams = new ArrayList<Examination>();

        while(examSet.hasNext()){
            Examination exam = (Examination) examSet.next();
            exams.add(exam);
        }

        return ok(views.html.guide.render(retrievedPerson, exams));
    }

    public Result apply() {

        final Person retrievedPerson = personRepository.findOne("51018419880821006X");
        final Iterator applySet = retrievedPerson.applies.iterator();
        final List<models.Application> applies = new ArrayList<models.Application>();

        while(applySet.hasNext()){
            models.Application apply = (models.Application) applySet.next();
            applies.add(apply);
        }

        return ok(views.html.apply.render(retrievedPerson, applies));
    }

//    public Result readCard(){
//        return ok(views.html.index.render("贾洁的页面。"));
//    }
}
