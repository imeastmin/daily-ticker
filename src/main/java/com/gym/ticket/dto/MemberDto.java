package com.gym.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gym.ticket.entity.Member;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {

        @ApiModelProperty(hidden = true)
        private Long no;

        @ApiModelProperty(example = "아아디")
        private String userId;

        @ApiModelProperty(example = "비밀번호")
        private String password;

        @ApiModelProperty(example = "이메일")
        private String email;

        @ApiModelProperty(example = "false", notes = "이메일 인증여부")
        private Boolean certification;

        @ApiModelProperty(example = "주소")
        private String address;

        @ApiModelProperty(hidden = true)
        private LocalDateTime createAt;

        @ApiModelProperty(hidden = true)
        private LocalDateTime deleteAt;

        public static MemberDto of(Member member) {
            return MemberDto.builder()
                    .no(member.getNo())
                    .userId(member.getUserId())
                    .password(member.getPassword())
                    .email(member.getEmail())
                    .certification(member.getCertification())
                    .address(member.getAddress())
                    .createAt(member.getCreateAt())
                    .deleteAt(member.getDeleteAt())
                    .build();
        }

        public Member toEntity() {
                return Member.builder()
                        .userId(this.userId)
                        .password(this.password)
                        .email(this.email)
                        .certification(this.certification)
                        .address(this.address).build();
        }
}

