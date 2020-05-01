package controllers

import javax.inject._
import models.User
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

    def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
    }

  def users() = Action { implicit request: Request[AnyContent] =>
    val users = List(User(), User(id = "ABC-123"))
    Ok(Json.toJson(users)).as("application/json")
  }

  def user(userId: String)   =    Action {
    implicit request: Request[AnyContent] =>
      val user = User(id = userId)
      Ok(Json.toJson(user)).as("application/json")

  }

  def add() = Action(parse.json)  {
    implicit request: Request[JsValue] =>
      val userResult = request.body.validate[User]
      userResult.fold (
        errors => {
          BadRequest (Json.obj("status" -> "error", "message" -> JsError.toJson(errors)))
        },
        user => {
          Ok(Json.toJson(user)).as("application/json")
        }
      )
  }

  /*
  def delete() = Action(parse.json) {
    implicit request: Request[JsValue] =>
      val userResult = request.body.validate[User]
      userResult.fold (
        errors => {
          BadRequest (Json.obj("status" -> "error", "message" -> JsError.toJson(errors)))
        },
        user => {
          Ok(Json.delete(user)).as("application/json")
        }
      )

  }
  */

}
