package controllers;

import models.Patient;
import models.PatientRepository;
import play.mvc.*;
import play.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import views.html.*;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {

    private final PatientRepository patientRepository;

    // We are using constructor injection to receive a repository to support our desire for immutability.
    @Inject
    public Application(final PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Result show(String name) {
        return ok(views.html.hello.render(name));
    }

    public Result index() {
        final Patient patient = new Patient();
        patient.id = 1L;
        patient.name = "Ling";

        final Patient savedPatient = patientRepository.save(patient);


        final Patient retrievedPatient = patientRepository.findOne(savedPatient.id);

        // Deliver the index page with a message showing the id that was generated.

        return ok(views.html.index.render("Found id: " + retrievedPatient.id + retrievedPatient.name + " of person/people"));
    }
}
