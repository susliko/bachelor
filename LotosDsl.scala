  class MethodT[Name, Params <: HList](
      protected val name: String,
      protected val paramGens: Map[String, AnyRef]
  ) {
    def param[Key <: String with Singleton, T](key: Key)(
        implicit gen: Gen[T]): MethodT[Name, FieldType[Key, T] :: Params] =
      new MethodT(name, paramGens + (key -> gen))
  }


  class MethodT[Name, Params <: HList](
      protected val name: String,
      protected val paramGens: Map[String, AnyRef]
  ) {
    def param[Key <: String with Singleton, T](key: Key)(
        implicit gen: Gen[T]): MethodT[Name, FieldType[Key, T] :: Params] =
      new MethodT(name, paramGens + (key -> gen))
  }

  object syntax {
    def method[Name <: String](name: Witness.Aux[Name]): MethodT[Name, HNil] =
      new MethodT(name = name.value, paramGens = Map.empty)

    def spec[I](construct: => I): SpecT[I, HNil] =
      new SpecT(construct = () => construct, methods = Map.empty)
  }
