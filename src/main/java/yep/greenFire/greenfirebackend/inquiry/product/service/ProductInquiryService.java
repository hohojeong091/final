package yep.greenFire.greenfirebackend.inquiry.product.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yep.greenFire.greenfirebackend.inquiry.product.member.domain.repository.MemberProductInquiryRepository;

@Service
public class ProductInquiryService {
    private MemberProductInquiryRepository memberProductInquiryRepository;


    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page - 1, 10, Sort.by("inquiryCode").descending());
    }
//    public Page<MemberProductInquiryResponse> getProductInquiryContent(long productCode, Integer page) {
//
//        Page<InquiryContent> productInquiry = memberProductInquiryRepository.findByProductCode(productCode, getPageable(page));
//
//        return productInquiry.map(MemberProductInquiryResponse::from);
//
//    }
//
//
//    public int save(
//            @RequestPart @Valid final MemberProductInquiryCreatRequest memberProductInquiryCreateRequest) {
//
//        final InquiryContent newProductInquiry = InquiryContent.of3(
//                memberProductInquiryCreateRequest.getProductCode(),
//                memberProductInquiryCreateRequest.getProductName(),
//                memberProductInquiryCreateRequest.getMemberCode(),
//                memberProductInquiryCreateRequest.getInquiryTitle(),
//                memberProductInquiryCreateRequest.getInquiryDetail(),
//                memberProductInquiryCreateRequest.getInquiryWriteDate()
//        );
//
//        final InquiryContent newInquiry = memberProductInquiryRepository.save(newProductInquiry);
//
//        return newInquiry.getInquiryCode();
//
//    }

    //seller

    //    public Page<SellerProductInquiryResponse> getProductInquiryList(long productCode, Integer page) {
//        Page<InquiryContent> sellerProductInquiry = sellerProductInquiryRepository.findByProductCode(productCode, getPageable(page));
//
//        return sellerProductInquiry.map(SellerProductInquiryResponse::from);
//
//    }

//    public int save(SellerProductReplyCreateRequest sellerProductReplyCreateRequest) {
//
//        final InquiryContent newProductInquiryReply = InquiryContent.of4(
//                sellerProductReplyCreateRequest.getProductCode(),
//                sellerProductReplyCreateRequest.getProductName(),
//                sellerProductReplyCreateRequest.getMemberCode(),
//                sellerProductReplyCreateRequest.getInquiryTitle(),
//                sellerProductReplyCreateRequest.getInquiryDetail(),
//                sellerProductReplyCreateRequest.getInquiryWriteDate(),
//                sellerProductReplyCreateRequest.getInquiryReply(),
//                sellerProductReplyCreateRequest.getInquiryReplyStatus()
//
//        );
//
//        final InquiryContent newProductReply = sellerProductInquiryRepository.save(newProductInquiryReply);
//        return newProductReply.getInquiryCode();
//
//    }

//    public void remove(int inquiryCode) {
//
//        sellerProductInquiryRepository.deleteById(inquiryCode);
//    }
}
