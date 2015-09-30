package controllers

import play.api.mvc._
import models._
import views.html.articles._

class NotebookController extends Controller {

  val mappedArticles = List(
    MappedArticle("dry-html-refactoring", DryHtmlArticle),
    MappedArticle("narrowing-overly-generic-contracts", NarrowingContractsArticle),
    MappedArticle("deductive-reasoning-in-integration-tests", IntegrationTestsArticle),
    MappedArticle("scala-operator-precedence-gotcha", ScalaPrecedenceArticle),
    MappedArticle("closure-pattern-to-reduce-boilerplate", ClosurePatternArticle),
    MappedArticle("loggers-to-find-dead-code", DeadCodeLoggersArticle),
    MappedArticle("pdo-lost-mysql-connection-error", PdoConnectionErrorArticle),
    MappedArticle("observer-pattern-in-real-life", ObserverPatternArticle),
    MappedArticle("optimize-service-fetches", OptimizeServiceFetchArticle),
    MappedArticle("dependency-injection-container", DependencyInjectionContainerArticle),
    MappedArticle("good-namespaces-and-class-names", NamespaceAndClassNamesArticle),
    MappedArticle("crowd-sourced-data-model-and-workflow", CrowdSourcedModelArticle),
    MappedArticle("organize-your-files", OrganizeYourFilesArticle)
  )

  val articlesBySlug = mappedArticles.map(article => (article.slug, article)).toMap

  def index = Action {
    Ok(articlesContent(mappedArticles))
  }

  def showArticle(name: String) = Action {
    articlesBySlug.get(name) match {
      case Some(mappedArticle) => Ok(articleContent(mappedArticle.article))
      case None => NotFound(notFoundContent())
    }
  }

}
