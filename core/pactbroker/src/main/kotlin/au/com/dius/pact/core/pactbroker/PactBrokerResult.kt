package au.com.dius.pact.core.pactbroker

import au.com.dius.pact.core.support.Json
import au.com.dius.pact.core.support.json.JsonValue

data class PactBrokerResult(
  val name: String,
  val source: String,
  val pactBrokerUrl: String,
  @Deprecated("pactFileAuthentication is not used")
  val pactFileAuthentication: List<String> = listOf(),
  val notices: List<VerificationNotice> = listOf(),
  val pending: Boolean = false,
  val tag: String? = null,
  val wip: Boolean = false,
  val usedNewEndpoint: Boolean = false
)

data class VerificationNotice(
  val `when`: String,
  val text: String
) {
  companion object {
    fun fromJson(json: JsonValue): VerificationNotice? {
      return if (json is JsonValue.Object) {
        VerificationNotice(Json.toString(json["when"]), Json.toString(json["text"]))
      } else {
        null
      }
    }
  }
}
