import miniboxing.plugin.minispec

class C[@minispec T](var x: T) {
  def u: T = ???
  def y(arg: T): T = ???
  def z(arg1: T, arg2: List[T]): T = ???
}
