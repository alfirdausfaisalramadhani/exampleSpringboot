package com.mycompany.app.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Users {
    @Id
    @GeneratedValue(generator = "UUID")
    private String userId;
    @Column( nullable=true)
    private String roleId;
    @Column(length=60, nullable=false, unique=true)
    private String userName;
    @Column(length=200, nullable=false)
    private String FullName;
    @Column(length=200, nullable=false)
    private String password;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "roles_id")
//    private Roles roles;


}
