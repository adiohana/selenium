package org.openqa.selenium.devtools.network.model;

/**
 * Field type for a signed exchange related error
 */
public enum SignedExchangeErrorField {

  SIGNATURE_SIG("signatureSig"),
  SIGNATURE_INTEGRITY("signatureIntegrity"),
  SIGNATURE_CERT_URL("signatureCertUrl"),
  SIGNATURE_CERT_SHA_256("signatureCertSha256"),
  SIGNATURE_VALIDITY_URL("signatureValidityUrl"),
  SIGNATURE_TIMESTAMPS("signatureTimestamps");

  private String error;

  SignedExchangeErrorField(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}
