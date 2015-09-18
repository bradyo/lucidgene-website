import javax.inject.Inject

import play.api.http.{HttpFilters, HttpConfiguration, HttpErrorHandler, DefaultHttpRequestHandler}
import play.api.mvc.{Action, Handler, RequestHeader}
import play.api.mvc.Results._
import play.api.routing.Router

class RequestHandler @Inject() (
    router: Router, errorHandler: HttpErrorHandler, configuration: HttpConfiguration, filters: HttpFilters
  ) extends DefaultHttpRequestHandler(router, errorHandler, configuration, filters) {

  val redirectsMap = Map(
    "" -> "/about",
    "/" -> "/about",
    "/2014/12/narrowing-overly-generic-contracts" -> "/articles/narrowing-overly-generic-contracts",
    "/2014/11/deductive-reasoning-for-integration-test-combos" -> "/articles/deductive-reasoning-in-integration-tests",
    "/2014/07/scala-operator-precendence-and-maps" -> "/articles/scala-operator-precedence-gotcha",
    "/2014/06/closure-pattern-to-reduce-boilerplate" -> "/articles/closure-pattern-to-reduce-boilerplate",
    "/2013/09/using-loggers-to-find-dead-code" -> "/articles/loggers-to-find-dead-code",
    "/2013/04/handling-pdo-lost-mysql-connection-error" -> "/articles/pdo-lost-mysql-connection-error",
    "/2013/04/using-the-observer-pattern-for-mailing-address" -> "/articles/observer-pattern-in-real-life",
    "/2012/04/dependency-injection-container-dic-for-lazy-loading-services" -> "/articles/dependency-injection-container",
    "/2012/04/how-to-create-good-namespaces-and-class-names-in-php-5-3" -> "/articles/good-namespaces-and-class-names",
    "/2012/04/optimizing-service-layer-fetches" -> "/articles/optimize-service-fetches",
    "/2012/03/a-data-model-and-workflow-for-crowd-sourced-web-applications" -> "/articles/crowd-sourced-data-model-and-workflow",
    "/2011/11/how-to-organize-your-files" -> "/articles/organize-your-files"
  )

  override def handlerForRequest(request: RequestHeader): (RequestHeader, Handler) = {
    val normalizedRequest = new NormalizedRequest(request)
    redirectsMap.get(normalizedRequest.uri) match {
      case Some(newUri) =>
        // Redirect old URLs
        (normalizedRequest, Action(MovedPermanently("http://" + request.host + newUri)))
      case None =>
        if (normalizedRequest.uri != request.uri)
          // Redirect to normalized uri
          (normalizedRequest, Action(MovedPermanently("http://" + request.host + normalizedRequest.uri)))
        else
          super.handlerForRequest(normalizedRequest)
    }
  }
}
