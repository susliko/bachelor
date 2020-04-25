  var flag: Boolean = false
  def raiseFlag = { flag = true }

  ForkJoinPool.commonPool.execute(DataRaceExample.raiseFlag _)
  while (!flag) {}


