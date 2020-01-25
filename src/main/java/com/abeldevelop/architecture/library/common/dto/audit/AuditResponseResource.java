package com.abeldevelop.architecture.library.common.dto.audit;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Create Application resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuditResponseResource {

	@ApiModelProperty(notes = "Datetime when create the resource", example = "", required = true, position = 0)
	@NotNull
	private LocalDateTime auditCreatedDate;

	@ApiModelProperty(notes = "User who create the resource", example = "user", required = true, position = 1)
	@NotNull
	private String auditCreatedUser;

	@ApiModelProperty(notes = "Datetime when modify the resource", example = "", position = 2)
	private LocalDateTime auditModifiedDate;

	@ApiModelProperty(notes = "User who modify the resource", example = "user", position = 3)
	private String auditModifiedUser;

	@ApiModelProperty(notes = "Datetime when delete the resource", example = "", position = 4)
	private LocalDateTime auditDeletedDate;

	@ApiModelProperty(notes = "User who delete the resource", example = "user", position = 5)
	private String auditDeletedUser;

}