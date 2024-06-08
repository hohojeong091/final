package yep.greenFire.greenfirebackend.inquiry.site.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import yep.greenFire.greenfirebackend.inquiry.site.dto.response.AdminInquiryResponse;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;


@Repository
public interface AdminInquiryRepository {
    Page<AdminInquiryResponse> findByInquiryCode(Pageable page, int inquiryCode);

    InquiryContent save(InquiryContent newAdminList);

    void deleteById(int inquiryCode);
}
