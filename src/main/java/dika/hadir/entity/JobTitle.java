package dika.hadir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "job_titles")
public class JobTitle {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Client client;

  public JobTitle() {}

  public JobTitle(UUID id, String name, Client client) {
    this.id = id;
    this.name = name;
    this.client = client;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public JobTitle id(UUID id) {
    setId(id);
    return this;
  }

  public JobTitle name(String name) {
    setName(name);
    return this;
  }

  public JobTitle client(Client client) {
    setClient(client);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof JobTitle)) {
      return false;
    }
    JobTitle jobTitle = (JobTitle) o;
    return (
      Objects.equals(id, jobTitle.id) &&
      Objects.equals(name, jobTitle.name) &&
      Objects.equals(client, jobTitle.client)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, client);
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", name='" +
      getName() +
      "'" +
      ", client='" +
      getClient() +
      "'" +
      "}"
    );
  }
}
