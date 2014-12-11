package io.devmix.demo.animals

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.util.Timeout
import io.devmix.demo.animals.service.AnimalServiceActor
import com.typesafe.config.{ConfigFactory, Config}
import spray.can.Http
import scala.concurrent.duration._


object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("animals")

  val conf = ConfigFactory.load()

  // create and start our service actor
  val service = system.actorOf(Props[AnimalServiceActor], "animal-service")

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = "0.0.0.0", port = conf.getInt("http.port"))
}