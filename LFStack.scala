  case class Node[T](value: T, next: Node[T] = null)

  class LFStack[T] extends Serializable {
    val stack: AtomicReference[Node[T]] = new AtomicReference[Node[T]]()

    def push(item: T): Unit = {
      var oldHead: Node[T] = null
      var newHead          = Node(item)
      oldHead = stack.get();
      newHead = newHead.copy(next = oldHead)
      stack.set(newHead)
    }

    def pop: Option[T] = {
      var oldHead: Node[T] = null
      var newHead: Node[T] = null
      do {
        oldHead = stack.get()
        if (oldHead == null)
          return None

        newHead = oldHead.next
      } while (!stack.compareAndSet(oldHead, newHead))
      Some(oldHead.value)
    }
  }

