package dika.hadir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String clientName;

  @Column(nullable = false, unique = true)
  private String clientId;

  @Column(nullable = false)
  private String clientSecret;

  public Client() {}

  public Client(
    UUID id,
    String clientName,
    String clientId,
    String clientSecret
  ) {
    this.id = id;
    this.clientName = clientName;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getClientName() {
    return this.clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientId() {
    return this.clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return this.clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public Client id(UUID id) {
    setId(id);
    return this;
  }

  public Client clientName(String clientName) {
    setClientName(clientName);
    return this;
  }

  public Client clientId(String clientId) {
    setClientId(clientId);
    return this;
  }

  public Client clientSecret(String clientSecret) {
    setClientSecret(clientSecret);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Client)) {
      return false;
    }
    Client client = (Client) o;
    return (
      Objects.equals(id, client.id) &&
      Objects.equals(clientName, client.clientName) &&
      Objects.equals(clientId, client.clientId) &&
      Objects.equals(clientSecret, client.clientSecret)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientName, clientId, clientSecret);
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", clientName='" +
      getClientName() +
      "'" +
      ", clientId='" +
      getClientId() +
      "'" +
      ", clientSecret='" +
      getClientSecret() +
      "'" +
      "}"
    );
  }
}
