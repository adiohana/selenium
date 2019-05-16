package org.openqa.selenium.devtools.network.model;

import static java.util.Objects.requireNonNull;

import org.openqa.selenium.json.JsonInput;

/**
 * Details of a signed certificate timestamp (SCT)
 */
public class SignedCertificateTimestamp {

  private String status;

  private String origin;

  private String logDescription;

  private String logId;

  private Double timestamp;

  private String hashAlgorithm;

  private String signatureAlgorithm;

  private String signatureData;


  public SignedCertificateTimestamp(String status, String origin, String logDescription,
                                    String logId, Double timestamp, String hashAlgorithm,
                                    String signatureAlgorithm, String signatureData) {
    this.status = requireNonNull(status, "'status' is require");

    this.origin = requireNonNull(origin, "'origin' is require");

    this.logDescription = requireNonNull(logDescription, "'logDescription' is require");

    this.logId = requireNonNull(logId, "'logId' is require");

    this.timestamp = requireNonNull(timestamp, "'timestamp' is require");

    this.hashAlgorithm = requireNonNull(hashAlgorithm, "'hashAlgorithm' is require");

    this.signatureAlgorithm = requireNonNull(signatureAlgorithm, "'signatureAlgorithm' is require");

    this.signatureData = requireNonNull(signatureData, "'signatureData' is require");

  }

  public static SignedCertificateTimestamp parseSignedCertificateTimestamp(JsonInput input) {

    String status = null;

    String origin = null;

    String logDescription = null;

    String logId = null;

    Number timestamp = null;

    String hashAlgorithm = null;

    String signatureAlgorithm = null;

    String signatureData = null;

    input.beginObject();

    while (input.hasNext()) {

      switch (input.nextName()) {
        case "status":
          status = input.nextString();
          break;
        case "origin":
          origin = input.nextString();
          break;
        case "logDescription":
          logDescription = input.nextString();
          break;
        case "logId":
          logId = input.nextString();
          break;
        case "timestamp":
          timestamp = input.nextNumber();
          break;
        case "hashAlgorithm":
          hashAlgorithm = input.nextString();
          break;
        case "signatureAlgorithm":
          signatureAlgorithm = input.nextString();
          break;
        case "signatureData":
          signatureData = input.nextString();
          break;
        default:
          input.skipValue();
          break;
      }

    }

    return new SignedCertificateTimestamp(status, origin, logDescription, logId,
                                          Double.valueOf(String.valueOf(timestamp)), hashAlgorithm,
                                          signatureAlgorithm, signatureData);

  }

  /**
   * Validation status.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Validation status.
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Origin.
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Origin.
   */
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Log name / description.
   */
  public String getLogDescription() {
    return logDescription;
  }

  /**
   * Log name / description.
   */
  public void setLogDescription(String logDescription) {
    this.logDescription = logDescription;
  }

  /**
   * Log ID.
   */
  public String getLogId() {
    return logId;
  }

  /**
   * Log ID.
   */
  public void setLogId(String logId) {
    this.logId = logId;
  }

  /**
   * Issuance date.
   */
  public Double getTimestamp() {
    return timestamp;
  }

  /**
   * Issuance date.
   */
  public void setTimestamp(Double timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Hash algorithm.
   */
  public String getHashAlgorithm() {
    return hashAlgorithm;
  }

  /**
   * Hash algorithm.
   */
  public void setHashAlgorithm(String hashAlgorithm) {
    this.hashAlgorithm = hashAlgorithm;
  }

  /**
   * Signature algorithm.
   */
  public String getSignatureAlgorithm() {
    return signatureAlgorithm;
  }

  /**
   * Signature algorithm.
   */
  public void setSignatureAlgorithm(String signatureAlgorithm) {
    this.signatureAlgorithm = signatureAlgorithm;
  }

  /**
   * Signature data.
   */
  public String getSignatureData() {
    return signatureData;
  }

  /**
   * Signature data.
   */
  public void setSignatureData(String signatureData) {
    this.signatureData = signatureData;
  }
}
