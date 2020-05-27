  val cfg = TestConfig(parallelism = 2,
                       scenarioLength = 2,
                       scenarioRepetition = 20,
                       scenarioCount = 5,
                       operationTimeout = 1.second)

  val runTest: IO[TestResult] = 
    LotosTest.forSpec(hashMapSpec, cfg, Consistency.linearizable)

