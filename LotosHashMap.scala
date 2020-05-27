  class UnsafeHashMap {
    val underlying = new ju.HashMap[Int, String]
    def put(key: Int, value: String): Option[String] = 
      Option(underlying.put(key, value))
    def get(key: Int): Option[String] = 
      Option(underlying.get(key))
  }

  val hashMapSpec =
    spec(new UnsafeHashMap)
      .withMethod(
        method("put")
          .param("key")(Gen.int(1))
          .param("value")(Gen.string(1)))
      .withMethod(
        method("get")
          .param("key")(Gen.int(1)))

