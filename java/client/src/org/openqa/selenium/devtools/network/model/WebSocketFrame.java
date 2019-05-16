package org.openqa.selenium.devtools.network.model;

import static java.util.Objects.requireNonNull;

import org.openqa.selenium.json.JsonInput;
import org.openqa.selenium.json.JsonInputConverter;

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 */
public class WebSocketFrame {

  /**
   * WebSocket message opcode.
   */
  private Double opcode;
  /**
   * WebSocket message mask.
   */
  private boolean mask;

  /**
   * WebSocket message payload data. If the opcode is 1, this is a text message and payloadData is a UTF-8 string. If the opcode isn't 1, then payloadData is a base64 encoded string representing binary data.
   */
  private String payloadData;

  public WebSocketFrame(Double opcode, boolean mask, String payloadData) {
    this.opcode = requireNonNull(opcode, "'opcode' is require");
    this.mask = requireNonNull(mask, "'mask' is require");
    this.payloadData = requireNonNull(payloadData, "'payloadData' is require");
  }

  public static WebSocketFrame parse(JsonInput input){
    Double opcode = null;
    Boolean mask = null;
    String payloadData = null;
    while (input.hasNext()){
      switch (input.nextName()){
        case "opcode":
          opcode = JsonInputConverter.extractDouble(input);
          break;
        case "mask" :
          mask = input.nextBoolean();
          break;
        case "payloadData" :
          payloadData = input.nextString();
          break;
        default:
          input.skipValue();
          break;
      }
    }
    return new WebSocketFrame(opcode, mask, payloadData);
  }

  public Number getOpcode() {
    return opcode;
  }

  public void setOpcode(Double opcode) {
    this.opcode = opcode;
  }

  public boolean isMask() {
    return mask;
  }

  public void setMask(boolean mask) {
    this.mask = mask;
  }

  public String getPayloadData() {
    return payloadData;
  }

  public void setPayloadData(String payloadData) {
    this.payloadData = payloadData;
  }


}
