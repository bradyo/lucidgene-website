package controllers

import models._
import play.api.mvc._
import views.html.projects._

class ProjectController extends Controller {

  def index = Action {
    Ok(projectsContent(Map.empty))
  }

}
