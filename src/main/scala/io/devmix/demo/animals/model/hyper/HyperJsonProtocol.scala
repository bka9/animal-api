package io.devmix.demo.animals.model.hyper

import spray.json._

/**
 * Created by kevin.anderson on 11/20/14.
 */
class HyperJsonProtocol extends DefaultJsonProtocol{
  implicit val hyperObjFormat=jsonFormat1(HyperObj)
}

object HyperJsonProtocol extends HyperJsonProtocol {
  implicit object HyperJsonFormat extends RootJsonFormat[HyperJson] {
    def write(c: HyperJson) = {
      val attr = c.attributes.map(x => (x._1,x._2.toJson)).toMap

      new JsObject(attr + ("href"->JsString(c.href)))
    }

    def read(value: JsValue) = deserializationError("Color expected")
  }
}