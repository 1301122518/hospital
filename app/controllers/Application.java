package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result show(String name) {
        return ok(views.html.hello.render(name));
    }

    public Result index() {
        return ok(views.html.index.render("your application is ready"));
    }
}
