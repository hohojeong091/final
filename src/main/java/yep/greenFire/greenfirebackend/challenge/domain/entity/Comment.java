package yep.greenFire.greenfirebackend.challenge.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import yep.greenFire.greenfirebackend.member.domain.entity.Member;

@Entity
@Table(name = "tbl_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentCode;

    private String commentContent;

    private Long memberCode;
}
