package io.devmix.demo.animals.service

import akka.actor.Actor
import io.devmix.demo.animals.model.hyper.HyperJson
import spray.http.{MediaType, ContentType}
import spray.http.HttpHeaders.`Content-Type`
import spray.routing.HttpService

/**
 * Created by kevin.anderson on 11/20/14.
 */
trait AnimalService extends HttpService{
  val indexRoute = path("animals"){
    import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
    import spray.httpx.SprayJsonSupport.sprayJsonUnmarshaller
    import com.octanner.demo.animals.model.hyper.HyperJsonProtocol._
    get{
      respondWithHeader(`Content-Type`(ContentType(MediaType.custom("application/hyper+json")))) {
        complete{
          HyperJson("/animals")
        }
      }
    }
  }
}

class AnimalServiceActor extends Actor with AnimalService{
  def actorRefFactory = context

  def receive = runRoute(indexRoute)
}
