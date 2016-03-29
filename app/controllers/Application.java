package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index(String name) {
        return ok(views.html.hello.render(name));
    }

}
