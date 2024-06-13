package yep.greenFire.greenfirebackend.inquiry.site.dto.response;

import lombok.Getter;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;

import java.util.Date;

@Getter
public class InquiryResponse {

    //문의 등록 전 문의 목록 조회

    private Integer inquiryCode;
    private Date inquiryWriteDate;
    private String inquiryTitle;
    private String inquiryDetail;
    private String inquiryReplyStatus;


    public InquiryResponse(Integer inquiryCode, Date inquiryWriteDate, String inquiryTitle, String inquiryDetail, String inquiryReplyStatus) {
        this.inquiryCode = inquiryCode;
        this.inquiryWriteDate = inquiryWriteDate;
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
        this.inquiryReplyStatus = inquiryReplyStatus;
    }

    public static InquiryResponse from(InquiryContent inquiryContent) {
        return new InquiryResponse(
                inquiryContent.getInquiryCode(),
                inquiryContent.getInquiryWriteDate(),
                inquiryContent.getInquiryTitle(),
                inquiryContent.getInquiryDetail(),
                inquiryContent.getInquiryReplyStatus()


        );

    }
}
