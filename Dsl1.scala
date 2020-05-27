  // DSL definition
  trait HttpReq
  case class GET(url: String) extends HttpReq
  case class QueryParam(k: String, v: String) extends HttpReq
  case class Body(data: Array[Byte]) extends HttpReq
  class Resp[T] extends HttpReq
  class |>[L <: HttpReq, R <: HttpReq] extends HttpReq

  def get(url: String) = GET(url)
  def param(k: String, v: String) = QueryParam(k, v)
  def body(data: Array[Byte]) = Body(data)
  def |>[L <: HttpReq, R <: HttpReq](l: L, r: R) = new |>[L,R]

  // Usage example
  val httpReq = get("example.com") |> 
                param("login", "foo") |> 
                body(bytes) |>
                resp[String]

