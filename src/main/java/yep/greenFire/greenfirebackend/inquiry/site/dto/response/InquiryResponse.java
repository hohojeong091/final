package yep.greenFire.greenfirebackend.inquiry.site.dto.response;

import lombok.Getter;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;

import java.util.Date;

@Getter
public class InquiryResponse {

    //문의 등록 전 문의 목록 조회

    private final Integer inquiryCode;
    private final Date inquiryWriteDate;
    private final String inquiryTitle;
    private final String inquiryDetail;
    private final String inquiryReplyStatus;


    public InquiryResponse(final Integer inquiryCode, final Date inquiryWriteDate, final String inquiryTitle,
                           final String inquiryDetail, final String inquiryReplyStatus) {
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
