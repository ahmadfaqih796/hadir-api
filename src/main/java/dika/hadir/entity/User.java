package dika.hadir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String name;

  @Column(unique = true)
  private String email;

  private String password;

  @ManyToOne
  private Client client;

  @ManyToOne
  private Department department;

  @ManyToOne
  private Division division;

  @ManyToOne
  private JobUnit jobUnit;

  @ManyToOne
  private JobLevel jobLevel;

  @ManyToOne
  private JobTitle jobTitle;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Role role;

  public User() {}

  public User(
    String name,
    String email,
    String password,
    String role,
    UUID clientId,
    UUID departmentId,
    UUID divisionId,
    UUID jobUnitId,
    UUID jobLevelId,
    UUID jobTitleId
  ) {
    this.name = name;
    this.email = email;
    this.password = password;
    if (role != null) {
      Role roleModel = new Role();
      roleModel.setId(role);
      this.role = roleModel;
    }
    if (clientId != null) {
      Client clientModel = new Client();
      client.setId(clientId);
      this.client = clientModel;
    }
    if (departmentId != null) {
      Department departmentModel = new Department();
      department.setId(departmentId);
      this.department = departmentModel;
    }
    if (divisionId != null) {
      Division divisionModel = new Division();
      division.setId(divisionId);
      this.division = divisionModel;
    }
    if (jobUnitId != null) {
      JobUnit jobUnitModel = new JobUnit();
      jobUnit.setId(jobUnitId);
      this.jobUnit = jobUnitModel;
    }
    if (jobLevelId != null) {
      JobLevel jobLevelModel = new JobLevel();
      jobLevel.setId(jobLevelId);
      this.jobLevel = jobLevelModel;
    }
  }

  public User(
    UUID id,
    String name,
    String email,
    String password,
    Client client,
    Department department,
    Division division,
    JobUnit jobUnit,
    JobLevel jobLevel,
    JobTitle jobTitle,
    Role role
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.client = client;
    this.department = department;
    this.division = division;
    this.jobUnit = jobUnit;
    this.jobLevel = jobLevel;
    this.jobTitle = jobTitle;
    this.role = role;
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setClientId(UUID clientId) {
    if (clientId != null) {
      Client clientModel = new Client();
      clientModel.setId(clientId);
      this.client = clientModel;
    }
  }

  public void setDepartmentId(UUID departmentId) {
    if (departmentId != null) {
      Department departmentModel = new Department();
      departmentModel.setId(departmentId);
      this.department = departmentModel;
    }
  }

  public void setDivisionId(UUID divisionId) {
    if (divisionId != null) {
      Division divisionModel = new Division();
      divisionModel.setId(divisionId);
      this.division = divisionModel;
    }
  }

  public void setJobUnitId(UUID jobUnitId) {
    if (jobUnitId != null) {
      JobUnit jobUnitModel = new JobUnit();
      jobUnitModel.setId(jobUnitId);
      this.jobUnit = jobUnitModel;
    }
  }

  public void setJobLevelId(UUID jobLevelId) {
    if (jobLevelId != null) {
      JobLevel jobLevelModel = new JobLevel();
      jobLevelModel.setId(jobLevelId);
      this.jobLevel = jobLevelModel;
    }
  }

  public void setJobTitleId(UUID jobTitleId) {
    if (jobTitleId != null) {
      JobTitle jobTitleModel = new JobTitle();
      jobTitleModel.setId(jobTitleId);
      this.jobTitle = jobTitleModel;
    }
  }

  public void setRoleId(String roleId) {
    Role roleModel = new Role();
    roleModel.setId(roleId);
    this.role = roleModel;
  }

  public User roleId(String roleId) {
    setRoleId(roleId);
    return this;
  }

  public User clientId(UUID clientId) {
    setClientId(clientId);
    return this;
  }

  public User departmentId(UUID departmentId) {
    setDepartmentId(departmentId);
    return this;
  }

  public User divisionId(UUID divisionId) {
    setDivisionId(divisionId);
    return this;
  }

  public User jobUnitId(UUID jobUnitId) {
    setJobUnitId(jobUnitId);
    return this;
  }

  public User jobLevelId(UUID jobLevelId) {
    setJobLevelId(jobLevelId);
    return this;
  }

  public User jobTitleId(UUID jobTitleId) {
    setJobTitleId(jobTitleId);
    return this;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Division getDivision() {
    return this.division;
  }

  public void setDivision(Division division) {
    this.division = division;
  }

  public JobUnit getJobUnit() {
    return this.jobUnit;
  }

  public void setJobUnit(JobUnit jobUnit) {
    this.jobUnit = jobUnit;
  }

  public JobLevel getJobLevel() {
    return this.jobLevel;
  }

  public void setJobLevel(JobLevel jobLevel) {
    this.jobLevel = jobLevel;
  }

  public JobTitle getJobTitle() {
    return this.jobTitle;
  }

  public void setJobTitle(JobTitle jobTitle) {
    this.jobTitle = jobTitle;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return (
      Objects.equals(id, user.id) &&
      Objects.equals(name, user.name) &&
      Objects.equals(email, user.email) &&
      Objects.equals(password, user.password) &&
      Objects.equals(client, user.client) &&
      Objects.equals(role, user.role)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, client, role);
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
      ", email='" +
      getEmail() +
      "'" +
      ", password='" +
      getPassword() +
      "'" +
      ", client='" +
      getClient() +
      "'" +
      ", role='" +
      getRole() +
      "'" +
      "}"
    );
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public String getUsername() {
    return this.email;
  }
}
