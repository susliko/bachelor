  trait Gen[T] {
    def gen(seed: Long): T
  }

  object Gen{
    // Gen example
    def int(limit: Int = 10): Gen[Int] = new Gen[Int] {
      def gen(seed: Long): Int = (seed % limit).toInt
    }
  }


