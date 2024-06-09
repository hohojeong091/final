package yep.greenFire.greenfirebackend.inquiry.product.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;

@Repository
public interface ProductInquiryRepository extends JpaRepository<InquiryContent, Integer> {
    Page<InquiryContent> findByProductCode(long productCode, Pageable pageable);

    InquiryContent save(InquiryContent newProductInquiry);
}
