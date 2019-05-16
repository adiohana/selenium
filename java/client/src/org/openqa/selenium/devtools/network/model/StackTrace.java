package org.openqa.selenium.devtools.network.model;

import static java.util.Objects.requireNonNull;

import org.openqa.selenium.json.JsonInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Call frames for assertions or error messages.
 */
public class StackTrace {

  /**
   * optional
   */
  private String description;

  private List<CallFrame> callFrames;
  /**
   * optional
   */
  private StackTrace parent;
  /**
   * optional
   */
  private StackTraceId parentId;


  private StackTrace(String description,
                     List<CallFrame> callFrames,
                     StackTrace parent,
                     StackTraceId parentId) {
    this.description = description;
    this.callFrames = requireNonNull(callFrames, "'callFrames' is require");
    this.parent = parent;
    this.parentId = parentId;
  }

  /**
   * String label of this stack trace. For async traces this may be a name of the function that
   * initiated the async call.
   */
  public String getDescription() {
    return description;
  }

  /**
   * String label of this stack trace. For async traces this may be a name of the function that
   * initiated the async call.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  public static StackTrace parseStackTrace(JsonInput input) {
    input.beginObject();
    String description = null;
    List<CallFrame> callFrames = null;
    StackTrace parent = null;
    StackTraceId parentId = null;

    while (input.hasNext()) {
      switch (input.nextName()) {
        case "parent":
          parent = StackTrace.parseStackTrace(input);
          break;
        case "parentId":
          parentId = StackTraceId.parse(input);
          break;
        case "description":
          description = input.nextString();
          break;
        case "callFrames":
          input.beginArray();
          callFrames = new ArrayList<>();
          while (input.hasNext()) {
            callFrames.add(CallFrame.parseCallFrame(input));
          }
          input.endArray();
          break;
        default:
          input.skipValue();
          break;
      }
    }
    input.endObject();
    return new StackTrace(description, callFrames, parent, parentId);
  }

  /**
   * JavaScript function name.
   */
  public List<CallFrame> getCallFrames() {
    return callFrames;
  }

  /**
   * JavaScript function name.
   */
  public void setCallFrames(List<CallFrame> callFrames) {
    this.callFrames = callFrames;
  }

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  public StackTrace getParent() {
    return parent;
  }

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  public void setParent(StackTrace parent) {
    this.parent = parent;
  }

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  public StackTraceId getParentId() {
    return parentId;
  }

  /**
   * Asynchronous JavaScript stack trace that preceded this stack, if available.
   */
  public void setParentId(StackTraceId parentId) {
    this.parentId = parentId;
  }
}
