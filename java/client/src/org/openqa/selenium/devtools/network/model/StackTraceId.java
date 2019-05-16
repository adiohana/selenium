package org.openqa.selenium.devtools.network.model;

import static java.util.Objects.requireNonNull;

import org.openqa.selenium.json.JsonInput;

/**
 * If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This
 * allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
 */
public class StackTraceId {

  /**
   * Optional
   */
  private String debuggerId;

  private String id;

  public StackTraceId(String id, String debuggerId) {
    this.id = requireNonNull(id, "'id' is require");
    this.debuggerId = debuggerId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDebuggerId() {
    return debuggerId;
  }

  public void setDebuggerId(String debuggerId) {
    this.debuggerId = debuggerId;
  }

  public static StackTraceId parse(JsonInput input) {
    String id = input.nextString();
    String debuggerId = null;
    while (input.hasNext()) {
      switch (input.nextName()) {
        case "debuggerId":
          debuggerId = input.nextString();
          break;
        default:
          input.skipValue();
          break;
      }
    }
    return new StackTraceId(id, debuggerId);
  }
}
