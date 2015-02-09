package im.actor.api

import spray.json._
import scala.reflect.runtime.universe._

trait JsonHelpers {
  implicit class ValidableJsonObject(obj: JsObject) {
    def withField[A](key: String, errorPrefix: String)(f: JsValue => A): A = {
      obj.fields.get(key) match {
        case Some(value) => f(value)
        case None =>
          val pref = if (errorPrefix.isEmpty) {
            ""
          } else {
            errorPrefix + " "
          }
          deserializationError(f"$pref%s$key%s is required")
      }
    }

    def withField[A](key: String)(f: JsValue => A): A = withField[A](key, "")(f)
  }
}