package models

import org.joda.time.DateTime
import play.twirl.api.Html
import views.html.articles.contents._

abstract class Article() {
  val title: String
  val publishDate: DateTime
  val tags: List[String]
  val content: Html
  val coverImage: String
}

case class MappedArticle(slug: String, article: Article)

object DryArticle extends Article {
  override val title = "Do Not Repeat Yourself (DRY)"
  override val publishDate = DateTime.parse("2015-09-19")
  override val tags = List("Refactoring")
  override val content = dryContent(title, publishDate, tags)
  override val coverImage = "cover-13.jpg"
}

object NarrowingContractsArticle extends Article {
  override val title = "Narrowing Overly Generic Contracts"
  override val publishDate = DateTime.parse("2014-12-13")
  override val tags = List("Design Patterns", "PHP", "Refactoring")
  override val content = narrowingContractsContent(title, publishDate, tags)
  override val coverImage = "cover-12.jpg"
}

object IntegrationTestsArticle extends Article {
  override val title = "Deductive Reasoning for Integration Test Combos"
  override val publishDate = DateTime.parse("2014-11-11")
  override val tags = List("Design Patterns", "Java", "Testing")
  override val content = integrationTestsContent(title, publishDate, tags)
  override val coverImage = "cover-11.jpg"
}

object ScalaPrecedenceArticle extends Article {
  override val title = "Scala Operator Maps Precedence Gotcha"
  override val publishDate = DateTime.parse("2014-07-07")
  override val tags = List("Scala")
  override val content = scalaPrecedenceContent(title, publishDate, tags)
  override val coverImage = "cover-10.jpg"
}

object ClosurePatternArticle extends Article {
  override val title = "Closure Pattern to Reduce Boilerplate"
  override val publishDate = DateTime.parse("2014-06-29")
  override val tags = List("PHP", "Refactoring")
  override val content = closurePatternContent(title, publishDate, tags)
  override val coverImage = "cover-9.jpg"
}

object DeadCodeLoggersArticle extends Article {
  override val title = "Using Loggers to Find Dead Code"
  override val publishDate = DateTime.parse("2013-09-08")
  override val tags = List("PHP", "Refactoring")
  override val content = deadCodeLoggersContent(title, publishDate, tags)
  override val coverImage = "cover-8.jpg"
}

object PdoConnectionErrorArticle extends Article {
  override val title = "Handling PDO Lost MySQL Connection Error"
  override val publishDate = DateTime.parse("2013-04-22")
  override val tags = List("PHP")
  override val content = pdoConnectionErrorContent(title, publishDate, tags)
  override val coverImage = "cover-7.jpg"
}

object ObserverPatternArticle extends Article {
  override val title = "Using the Observer Pattern in Real Life"
  override val publishDate = DateTime.parse("2013-04-22")
  override val tags = List("Design Patterns")
  override val content = observerPatternContent(title, publishDate, tags)
  override val coverImage = "cover-6.jpg"
}

object OptimizeServiceFetchArticle extends Article {
  override val title = "Optimize Service Layer Fetches"
  override val publishDate = DateTime.parse("2012-04-25")
  override val tags = List("Refactoring")
  override val content = optimizeServiceFetchContent(title, publishDate, tags)
  override val coverImage = "cover-5.jpg"
}

object DependencyInjectionContainerArticle extends Article {
  override val title = "Dependency Injection Container (DIC) for Lazy Loading Services"
  override val publishDate = DateTime.parse("2012-04-05")
  override val tags = List("Design Patterns", "PHP")
  override val content = dependencyInjectionContainerContent(title, publishDate, tags)
  override val coverImage = "cover-4.jpg"
}

object NamespaceAndClassNamesArticle extends Article {
  override val title = "Good Namespaces and Class Names in PHP"
  override val publishDate = DateTime.parse("2012-04-01")
  override val tags = List("Design Patterns", "PHP", "Symfony2", "Zend Framework 2")
  override val content = namespaceAndClassNamesContent(title, publishDate, tags)
  override val coverImage = "cover-3.jpg"
}

object CrowdSourcedModelArticle extends Article {
  override val title = "A Data Model and Workflow for Crowd-sourced Web Applications"
  override val publishDate = DateTime.parse("2012-03-04")
  override val tags = List("Design Patterns", "PHP", "Doctrine 2")
  override val content = crowdSourcedModelContent(title, publishDate, tags)
  override val coverImage = "cover-2.jpg"
}

object OrganizeYourFilesArticle extends Article {
  override val title = "Organize Your Files"
  override val publishDate = DateTime.parse("2011-11-22")
  override val tags = List("Organization")
  override val content = organizeYourFilesContent(title, publishDate, tags)
  override val coverImage = "cover-1.jpg"
}
