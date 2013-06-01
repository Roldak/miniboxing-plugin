package miniboxing.plugin

trait MiniboxDefinitions {
  this: MiniboxInfoTransformation =>

  import global._
  import miniboxing.runtime.MiniboxConstants._

  // array ops
  lazy val MiniboxArrayObjectSymbol = rootMirror.getRequiredModule("miniboxing.runtime.MiniboxArray_FullSwitch")
  lazy val array_update = definitions.getMember(MiniboxArrayObjectSymbol, newTermName("array_update"))
  lazy val array_apply  = definitions.getMember(MiniboxArrayObjectSymbol, newTermName("array_apply"))
  lazy val array_length = definitions.getMember(MiniboxArrayObjectSymbol, newTermName("array_length"))
  lazy val array_new    = definitions.getMember(MiniboxArrayObjectSymbol, newTermName("array_new"))

  // Any ops
  lazy val TagDipatchObjectSymbol = rootMirror.getRequiredModule("miniboxing.runtime.MiniboxTypeTagDispatch")
  lazy val tag_hashCode = definitions.getMember(TagDipatchObjectSymbol, newTermName("mboxed_hashCode"))
  lazy val tag_==       = definitions.getMember(TagDipatchObjectSymbol, newTermName("mboxed_eqeq_tag"))
  lazy val notag_==     = definitions.getMember(TagDipatchObjectSymbol, newTermName("mboxed_eqeq_notag"))
  lazy val tag_toString = definitions.getMember(TagDipatchObjectSymbol, newTermName("mboxed_toString"))

  // conversions
  lazy val ConversionsObjectSymbol = rootMirror.getRequiredModule("miniboxing.runtime.MiniboxConversions")
  // type tag conversions
  lazy val minibox2box       =  definitions.getMember(ConversionsObjectSymbol, newTermName("minibox2box"))
  lazy val box2minibox       =  definitions.getMember(ConversionsObjectSymbol, newTermName("box2minibox"))
  // direct conversions
  lazy val x2minibox = Map(
      UNIT ->    definitions.getMember(ConversionsObjectSymbol, newTermName("UnitToMinibox")),
      BOOLEAN -> definitions.getMember(ConversionsObjectSymbol, newTermName("BooleanToMinibox")),
      BYTE ->    definitions.getMember(ConversionsObjectSymbol, newTermName("ByteToMinibox")),
      CHAR ->    definitions.getMember(ConversionsObjectSymbol, newTermName("CharToMinibox")),
      SHORT ->   definitions.getMember(ConversionsObjectSymbol, newTermName("ShortToMinibox")),
      INT ->     definitions.getMember(ConversionsObjectSymbol, newTermName("IntToMinibox")),
      LONG ->    definitions.getMember(ConversionsObjectSymbol, newTermName("LongToMinibox")),
      DOUBLE ->  definitions.getMember(ConversionsObjectSymbol, newTermName("DoubleToMinibox")),
      FLOAT ->   definitions.getMember(ConversionsObjectSymbol, newTermName("FloatToMinibox"))
    )
  lazy val minibox2x = Map(
      UNIT ->    definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToUnit")),
      BOOLEAN -> definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToBoolean")),
      BYTE ->    definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToByte")),
      CHAR ->    definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToChar")),
      SHORT ->   definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToShort")),
      INT ->     definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToInt")),
      LONG ->    definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToLong")),
      DOUBLE ->  definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToDouble")),
      FLOAT ->   definitions.getMember(ConversionsObjectSymbol, newTermName("MiniboxToFloat"))
    )

}
