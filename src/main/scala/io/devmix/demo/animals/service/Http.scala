package io.devmix.demo.animals.service

import spray.http.{HttpProtocols, HttpProtocol, HttpHeaders, HttpRequest}

/**
 * Created by kevin.anderson on 1/17/15.
 */
trait Http {
  def url(href:String)(implicit request:HttpRequest) = {
    val hostOption = request.headers.filter(p => p is HttpHeaders.Host.lowercaseName).headOption
    hostOption.fold(href)(f => s"http://${f.value}${href}")
  }
}
