  val stackSpec =
    spec(new LFStack[Int])
      .withMethod(method("push").param("item")(Gen.int(10)))
      .withMethod(method("pop"))

  val cfg = TestConfig(
    parallelism = 2,
    scenarioLength = 2,
    scenarioRepetition = 200,
    scenarioCount = 100
  )

  val runTest = LotosTest.forSpec(stackSpec, cfg, Consistency.linearizable)

