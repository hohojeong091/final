package yep.greenFire.greenfirebackend.inquiry.product.service;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;
import yep.greenFire.greenfirebackend.inquiry.product.domain.repository.ProductInquiryRepository;
import yep.greenFire.greenfirebackend.inquiry.product.dto.request.ProductInquiryCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.product.dto.request.ProductReplyCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.product.dto.response.ProductInquiryResponse;

import java.util.Date;


@Service

public class ProductInquiryService {
    private ProductInquiryRepository productInquiryRepository;


    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page - 1, 10, Sort.by("inquiryCode").descending());
    }
    public Page<ProductInquiryResponse> getProductInquiryContent(long productCode, Integer page) {

        Page<InquiryContent> productInquiry = productInquiryRepository.findByProductCode(productCode, getPageable(page));

        return productInquiry.map(ProductInquiryResponse::from);

    }




    public int save(
            @RequestBody @Valid final ProductInquiryCreateRequest ProductInquiryCreateRequest) {

        final InquiryContent newProductInquiry = InquiryContent.of3(
                ProductInquiryCreateRequest.getProductCode(),
                ProductInquiryCreateRequest.getProductName(),
                ProductInquiryCreateRequest.getMemberCode(),
                ProductInquiryCreateRequest.getInquiryTitle(),
                ProductInquiryCreateRequest.getInquiryDetail(),
                ProductInquiryCreateRequest.getInquiryWriteDate()
        );

        final InquiryContent newInquiry = productInquiryRepository.save(newProductInquiry);

        return newInquiry.getInquiryCode();

    }

    //seller

    //    public Page<SellerProductInquiryResponse> getProductInquiryList(long productCode, Integer page) {
//        Page<InquiryContent> sellerProductInquiry = sellerProductInquiryRepository.findByProductCode(productCode, getPageable(page));
//
//        return sellerProductInquiry.map(SellerProductInquiryResponse::from);
//
//    }


    public int productReplysave(ProductReplyCreateRequest ProductReplyCreateRequest) {

        final InquiryContent newProductInquiryReply = InquiryContent.of4(
                ProductReplyCreateRequest.getProductCode(),
                ProductReplyCreateRequest.getMemberCode(),
                ProductReplyCreateRequest.getInquiryTitle(),
                ProductReplyCreateRequest.getInquiryDetail(),
                ProductReplyCreateRequest.getInquiryWriteDate(),
                ProductReplyCreateRequest.getInquiryReply(),
                ProductReplyCreateRequest.getInquiryReplyStatus()

        );

        final InquiryContent newProductReply =productInquiryRepository.ProductReplysave(newProductInquiryReply);
        return newProductReply.getInquiryCode();

    }



    public void remove(int inquiryCode) {

        productInquiryRepository.deleteById(inquiryCode);
    }
}
