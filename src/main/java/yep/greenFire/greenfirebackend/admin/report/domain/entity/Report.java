package yep.greenFire.greenfirebackend.admin.report.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import yep.greenFire.greenfirebackend.admin.member.domain.entity.AdminMember;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_report")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportCode;

    @Enumerated(EnumType.STRING)
    private Long reportReason;

    private LocalDateTime reportDate;

    private String reportType;

    private Long commentCode;

    private Long reviewCode;

    private Long storeCode;

    private Long memberCode;
}
