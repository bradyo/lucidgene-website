package controllers

import play.api.mvc._
import views.html._

class DefaultController extends Controller {

  def about = Action {
    Ok(aboutContent())
  }

}
