package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import models.*;
import play.mvc.*;

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

        final Person retrievedPerson = personRepository.findOne(1L);
        final Iterator examSet = retrievedPerson.exams.iterator();
        final Iterator applieSet = retrievedPerson.applies.iterator();

//        final Examination exam = (Examination) exams.next();
        final List<Examination> exams = new ArrayList<Examination>();
//        final models.Application apply = (models.Application) applies.next();

        while(examSet.hasNext()){
            Examination exam = (Examination) examSet.next();
            exams.add(exam);
        }

        return ok(views.html.index.render(retrievedPerson, exams));
    }

    public Result guide() {

        final Person retrievedPerson = personRepository.findOne(1L);
        final Iterator examSet = retrievedPerson.exams.iterator();
        final List<Examination> exams = new ArrayList<Examination>();

        while(examSet.hasNext()){
            Examination exam = (Examination) examSet.next();
            exams.add(exam);
        }

        return ok(views.html.guide.render(retrievedPerson, exams));
    }

    public Result apply() {

        final Person retrievedPerson = personRepository.findOne(1L);
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
