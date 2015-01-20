package io.devmix.demo.animals.model.hyper

/**
 * Created by kevin.anderson on 11/20/14.
 */
case class HyperJson(href: String,attributes: (String,HyperObj)*)
case class HyperObj(href: String)

