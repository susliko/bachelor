  def transfer(amount: Int, from: AtomicInteger, to: AtomicInteger) = {
    val fromBalance = from.get()
    val toBalance   = to.get()
    from.set(fromBalance - amount)
    to.set(toBalance + amount)
  }

