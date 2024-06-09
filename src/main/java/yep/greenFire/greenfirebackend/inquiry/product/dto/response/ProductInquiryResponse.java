package yep.greenFire.greenfirebackend.inquiry.product.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public class ProductInquiryResponse {

    //상품문의에서 보여줘야할 것들

    //상품관련
    private int productCode;
    private String inquiryTitle;
    private String inquiryDetail;
    private Date inquiryWriteDate;
    private String inquiryReplyStatus;

    public ProductInquiryResponse(int productCode, String inquiryTitle, String inquiryDetail, Date inquiryWriteDate, String inquiryReplyStatus) {
        this.productCode = productCode;
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
        this.inquiryWriteDate = inquiryWriteDate;
        this.inquiryReplyStatus = inquiryReplyStatus;
    }



    public static ProductInquiryResponse from(InquiryContent inquiryContent) {

        return new ProductInquiryResponse(
                inquiryContent.getInquiryProduct(),
                inquiryContent.getInquiryTitle(),
                inquiryContent.getInquiryDetail(),
                inquiryContent.getInquiryWriteDate(),
                inquiryContent.getInquiryReplyStatus()


        );
    }
}
