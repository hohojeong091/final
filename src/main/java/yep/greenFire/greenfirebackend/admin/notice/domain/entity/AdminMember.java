package yep.greenFire.greenfirebackend.admin.notice.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class AdminMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberCode;
    private String memberName;
}
