package com.devscala

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.Materializer

import scala.concurrent.ExecutionContextExecutor

/**
  * Created by AZ on 20.06.2017
  */
trait REST extends JsonFormats {

  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  val route: Route =
    pathPrefix("api") {
      path("service") {
        get {
          complete("GET /api/service")
        } ~
        post {
          complete("POST /api/service")
        } ~
        delete {
          complete("DELETE /api/service")
        }
      }
    }

}
