package yep.greenFire.greenfirebackend.inquiry.product.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class ProductReplyCreateResponse {

    private int productCode;
    private String productName;
    private int memberCode;
    private String inquiryTitle;
    private String inquiryDetail;
    private Date inquiryWriteDate;
    private String inquiryReply;
    private String inquiryReplyStatus;

    public ProductReplyCreateResponse(int productCode, String productName, int memberCode, String inquiryTitle, String inquiryDetail, Date inquiryWriteDate, String inquiryReply, String inquiryReplyStatus) {
        this.productCode = productCode;
        this.productName = productName;
        this.memberCode = memberCode;
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
        this.inquiryWriteDate = inquiryWriteDate;
        this.inquiryReply = inquiryReply;
        this.inquiryReplyStatus = inquiryReplyStatus;
    }
}
