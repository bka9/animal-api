package io.devmix.demo.animals.model.hyper

import spray.json.DefaultJsonProtocol

/**
 * Created by kevin.anderson on 11/20/14.
 */
object HyperJsonProtocol extends DefaultJsonProtocol{
  implicit val hyperJsonFormat = jsonFormat1(HyperJson)
}
