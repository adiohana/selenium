package org.openqa.selenium.devtools.network.model;

import org.openqa.selenium.json.JsonInput;

import java.util.Objects;

/**
 * Object for storing Network response
 */
public class ResponseBody {

  /**
   * Response body
   */
  private final String body;

  /**
   * True, if content was sent as base64
   */
  private final Boolean base64Encoded;

  public ResponseBody(String body, Boolean base64Encoded) {
    this.body = Objects.requireNonNull(body, "'body' is require");
    this.base64Encoded = Objects.requireNonNull(base64Encoded, "'base64Encoded' is require");
  }

  private static ResponseBody fromJson(JsonInput input) {
    String body = input.nextString();
    Boolean base64Encoded = null;

    while (input.hasNext()) {

      switch (input.nextName()) {
        case "base64Encoded":
          base64Encoded = input.nextBoolean();
          break;
        default:
          input.skipValue();
          break;
      }
    }

    return new ResponseBody(body, base64Encoded);
  }

  public String getBody() {
    return body;
  }

  public Boolean getBase64Encoded() {
    return base64Encoded;
  }

  @Override
  public String toString() {
    return "ResponseBody{" +
           "body='" + body + '\'' +
           ", base64Encoded=" + base64Encoded +
           '}';
  }

}
