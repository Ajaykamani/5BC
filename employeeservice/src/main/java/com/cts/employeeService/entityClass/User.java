package com.cts.employeeService.entityClass;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {
	@Id
	@ApiModelProperty(notes="Id auto-increment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@ApiModelProperty(notes="userName for user to login")
	@Column(name="username",length = 100)
	private String userName;
	@ApiModelProperty(notes="Password for user to login ")
	@Column(name="password")
	private String password;
	@ApiModelProperty(notes="login to webpage based on role of the employee")
	@Column(name="role")
	private String role;
	@Column
	private Boolean enabled;
}
