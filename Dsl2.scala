  // DSL definition
  class HttpReq[Resp](
    url: String,
    params: Map[String, String],
    body: Array[Byte],
  ) {
    def param(k: String, v: String) = ???
    def body(bytes: Array[Byte]) = ???
    def resp[R] = ???
  }

  object HttpReq {
    def reqGet(url: String) = new HttpReq[Unit]
  }

  // Usage example
  reqGet("example.com")
    .param("login", "foo")
    .body(bytes)
    .resp[String]
