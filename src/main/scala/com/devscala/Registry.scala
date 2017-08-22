package com.devscala

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn


object Main extends REST {

  override implicit val system = ActorSystem("actor-system")
  override implicit val executor = system.dispatcher
  override implicit val materializer = ActorMaterializer()

  def main(args: Array[String]) {

    val bindingFuture = Http().bindAndHandle(route, "127.0.0.1", 3020)

    println("Suspended")
    StdIn.readLine()

    bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())

  }

}
