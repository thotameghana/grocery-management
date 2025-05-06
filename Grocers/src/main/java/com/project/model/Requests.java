package com.project.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "requests")
public class Requests {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestId;

	private Long employeeId;
	private Long itemId;

	@Enumerated(EnumType.STRING) // Stores as String in DB
	private RequestType requestType;

	@Enumerated(EnumType.STRING) // Stores as String in DB
	private RequestStatus status;

	private LocalDate created_at;

	public Requests() {
	}

	public Requests(Long requestId, Long employeeId, Long itemId, RequestType requestType, RequestStatus status,
			LocalDate created_at) {
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.itemId = itemId;
		this.requestType = requestType;
		this.status = status;
		this.created_at = created_at;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", itemId=" + itemId
				+ ", requestType=" + requestType + ", status=" + status + ", created_at=" + created_at + "]";
	}
}
