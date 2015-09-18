package models

import java.net.URL

import org.joda.time.DateTime

abstract class Project {
  val name: String
  val title: String
  val date: DateTime
  val url: Option[URL] = None
  val codeUrl: Option[URL] = None
  val tools: List[String] = List.empty
  val description: String
  val featureDescriptions: List[String] = List.empty
}

object KaeberleinLabWebsiteProject extends Project {
  override val name = "kaeberlein-lab-website"
  override val title = "Kaeberlein Lab Website"
  override val url = Some(new URL("http://kaeberleinlab.org"))
  override val date = DateTime.parse("2008-9-01")
  override val tools = List("PHP", "Zend Framework", "Doctrine ORM", "jQuery", "jQuery UI", "tinyMCE")
  override val description = """
    |The Kaeberlein Lab website It provides a minimalist content management interface for creating and editing
    |Pages, Publications, News Entries, and People.
    |""".stripMargin
  override val featureDescriptions = List(
     "Adding and removing automatically updates the lab mailing list"
  )
}

object UwAgingWebsiteProject extends Project {
  override val name = "uw-aging-department-website"
  override val title = "UW Aging Department Website"
  override val url = Some(new URL("http://uwaging.org"))
  override val date = DateTime.parse("2009-9-01")
  override val tools = List("PHP", "Zend Framework", "Doctrine ORM", "jQuery", "jQuery UI", "tinyMCE")
  override val description = """..."""
  override val featureDescriptions = List(
    "Editable website navigation menu"
  )
}

object SagewebProject extends Project {
  override val name = "sageweb"
  override val title = "Science of Aging Website (Sageweb)"
  override val url = Some(new URL("http://sageweb.org"))
  override val date = DateTime.parse("2010-9-01")
  override val tools = List("PHP", "Zend Framework", "Doctrine ORM 2", "jQuery", "jQuery UI", "tinyMCE", "Lucene", "UserVoice")
  override val description = """
      |This site is for listing resources available to the community of gerontology researchers.
      |The user interface allows users to add protocol files, videos, links, events, and articles.
      |It has an open work flow system that allows non-members to contribute content with moderator approval.
      |""".stripMargin
  override val featureDescriptions = List(
    "Editable website navigation menu"
  )
}

object PolysomeAnalysisProject extends Project {
  override val name = "polysome-analysis"
  override val title = "Polysome Curve Fitting Analysis"
  override val date = DateTime.parse("2010-10-01")
  override val tools = List("R", "Python")
  override val description = """
      |We needed a way to detect the density of active ribosome binding to study overall gene expression
      |levels. We used R curve fitting to calculate the density of RNA being transcribed with N number of
      |ribosomes. More ribosomes indicates higher transient translation in the organism.
      |""".stripMargin
}


object GeneExpressionAnalysisProject extends Project {
  override val name = "gene-expression-analysis"
  override val title = "Chromatin-Dependent Gene Expression"
  override val date = DateTime.parse("2008-07-01")
  override val tools = List("PCR", "DNA Extraction", "Chromatin Capture", "GeneOntology", "GenomeBrowser")
  override val description = """
      |I performed a genome wide analysis in mammals to map regulatory binding site fragments collected from a
      |chromatic conformation capture PCR assay to downstream target genes. Functional analysis of mapped genes
      |was used to classify potential biological roles of upstream regulatory elements.
      |""".stripMargin
}