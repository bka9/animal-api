package io.devmix.demo.animals.service

import akka.actor.Actor
import io.devmix.demo.animals.model.hyper.{HyperJsonProtocol, HyperObj, HyperJson}
import spray.http.{MediaType, ContentType}
import spray.http.HttpHeaders.`Content-Type`
import spray.routing.HttpService

/**
 * Created by kevin.anderson on 11/20/14.
 */
trait AnimalService extends HttpService with Http{
  val indexRoute = path(""){
    import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
    import io.devmix.demo.animals.model.hyper.HyperJsonProtocol._
    get{
      requestInstance { req =>
        implicit val request = req
        respondWithHeader(`Content-Type`(ContentType(MediaType.custom("application/hyper+json")))) {
          complete {
            HyperJson(url("/"), ("animals", HyperObj(url("/animals"))))
          }
        }
      }
    }
  }

  val animalsRoute = path("animals"){
    import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
    import io.devmix.demo.animals.model.hyper.HyperJsonProtocol._
    get{
      requestInstance { req =>
        implicit val request = req
        respondWithHeader(`Content-Type`(ContentType(MediaType.custom("application/hyper+json")))) {
          complete {
            HyperJson(url("/animals"), ("lion", HyperObj(url("/animals/lion"))),("tiger",HyperObj(url("/animals/tiger"))),("bear",HyperObj(url("/animals/bear"))))
          }
        }
      }
    }
  }
}

class AnimalServiceActor extends Actor with AnimalService{
  def actorRefFactory = context

  def receive = runRoute(indexRoute ~ animalsRoute)
}
