package org.openqa.selenium.devtools.network.events;

import org.openqa.selenium.devtools.network.model.MonotonicTime;
import org.openqa.selenium.devtools.network.model.RequestId;
import org.openqa.selenium.json.JsonInput;

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 */
public class WebSocketFrame {

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * timestamp
   */
  private final MonotonicTime timestamp;
  /**
   * WebSocket response data.
   */
  private final org.openqa.selenium.devtools.network.model.WebSocketFrame response;

  public WebSocketFrame(RequestId requestId,
                        MonotonicTime timestamp,
                        org.openqa.selenium.devtools.network.model.WebSocketFrame response) {
    this.requestId = requestId;
    this.timestamp = timestamp;
    this.response = response;
  }

  public static WebSocketFrame fromJson(JsonInput input){
    RequestId requestId = new RequestId(input.nextString());
    MonotonicTime timestamp = null;
    org.openqa.selenium.devtools.network.model.WebSocketFrame response = null;

    while (input.hasNext()){
      switch (input.nextName()){
        case "timestamp":
          timestamp = MonotonicTime.parse(input.nextNumber());
          break;
        case "response":
          response = org.openqa.selenium.devtools.network.model.WebSocketFrame.parse(input);
          break;
        default:
          input.skipValue();
          break;
      }
    }
    return new WebSocketFrame(requestId, timestamp, response);
  }
}
