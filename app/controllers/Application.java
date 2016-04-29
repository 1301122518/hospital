package controllers;

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
        final Iterator exams = retrievedPerson.exams.iterator();
        final Iterator applies = retrievedPerson.applies.iterator();

        final Examination exam = (Examination) exams.next();
        final models.Application apply = (models.Application) applies.next();

        return ok(views.html.index.render(retrievedPerson.name + exam.examItem +
                    "  位置在:  "+ exam.examAddress + "   签单医生： " + apply.signDoctor ));
    }

    public Result readCard(){
        return ok(views.html.index.render("贾洁的页面。"));
    }
}
