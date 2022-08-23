package vn.edu.uit.group5redis.entity;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.uit.group5redis.dto.UserRequest;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "MODIFIED_DATE", nullable = false)
    private Date modifiedDate;

    public User (UserRequest request) {
        this.userName = request.getUserName();
        this.fullName = request.getFullName();
        this.phoneNumber = request.getPhoneNumber();
        this.email = request.getEmail();
        this.address = request.getAddress();
    }
}
