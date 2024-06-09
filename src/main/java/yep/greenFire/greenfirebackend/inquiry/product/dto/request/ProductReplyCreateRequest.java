package yep.greenFire.greenfirebackend.inquiry.product.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class ProductReplyCreateRequest {

    private int memberCode;
    private int inquiryCode;
    private String inquiryTitle;
    private String inquiryDetail;
    private Date inquiryWriteDate;



}
