package com.example

import akka.actor._
import scala.collection.immutable.Map

trait ReplyToSupport {
  def reply(message: Any) = { }
  def setUpReplyToSupport(returnAddress: String) = { }
}

trait RegisterCustomer {

}

trait RabbitMQReplyToSupport extends ReplyToSupport {
  override def reply(message: Any): Unit = {
  }

  override def setUpReplyToSupport(returnAddress: String): Unit = {
  }
}

case class RegisterCustomerRabbitMQReplyToMapEnvelope(mapMessage: Map[String, String])
  extends RegisterCustomer with RabbitMQReplyToSupport {

  this.setUpReplyToSupport(mapMessage("returnAddress"))
}

object EnvelopeWrapperDriver {
}
