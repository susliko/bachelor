  val lock1 = new Object
  val lock2 = new Object
  Future {
    lock1.synchronized {
      lock2.synchronized()
    }
  }
  Future {
    lock2.synchronized {
      lock1.synchronized()
    }
  }

