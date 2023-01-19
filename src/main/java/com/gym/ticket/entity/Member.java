package com.gym.ticket.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) /* 기본 생성자 PROTECTED */
@Table(name = "member",
        uniqueConstraints = @UniqueConstraint(columnNames = "userId"))
@EntityListeners(AuditingEntityListener.class)
@Validated
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;

    @NotNull @Size(min = 5, max = 15) // 최소 5 ~ 최대 15 길이의 ID
    private String userId;

    @NotNull @Size(min = 8)
    private String password;

    @Email @NotNull
    private String email;

    private Boolean certification;
    private String address;

    @NotNull @CreatedDate
    private LocalDateTime createAt;

    @Null
    private LocalDateTime deleteAt;

    @PreRemove
    public void setDeleteAt() {
        this.deleteAt = LocalDateTime.now();
    }

    @Builder
    public Member(String userId, String password, String email, Boolean certification, String address) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.certification = certification;
        this.address = address;
    }
}
