import play.api.mvc.RequestHeader

class NormalizedRequest(request: RequestHeader) extends RequestHeader {

  val headers = request.headers
  val queryString = request.queryString
  val remoteAddress = request.remoteAddress
  val method = request.method
  val path = request.path.stripSuffix("/")
  val uri = path + request.uri.stripPrefix(request.path)

  override def id: Long = request.id
  override def secure: Boolean = request.secure
  override def version: String = request.version
  override def tags: Map[String, String] = request.tags

}
