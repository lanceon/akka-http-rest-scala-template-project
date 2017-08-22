package com.devscala

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  * Created by AZ on 20.06.2017
  */
trait JsonFormats extends SprayJsonSupport with DefaultJsonProtocol {

}
