package yep.greenFire.greenfirebackend.inquiry.site.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@RequiredArgsConstructor
@Service
public class SiteInquiryResponse {

    //문의 등록 전 문의 목록 조회

    private int inquiryCode;
    private String inquiryStatus;
    private String inquiryReply;
    private String inquiryReplyStatus;
    private int memberCode;


    public SiteInquiryResponse(int inquiryCode, String inquiryStatus, String inquiryReply, String inquiryReplyStatus, int memberCode) {
        this.inquiryCode = inquiryCode;
        this.inquiryStatus = inquiryStatus;
        this.inquiryReply = inquiryReply;
        this.inquiryReplyStatus = inquiryReplyStatus;
        this.memberCode = memberCode;
    }

//    public static MemberInquiryResponse from(InquiryContent inquiryContent) {
//        return new MemberInquiryResponse(
//                inquiryContent.getInquiryCode(),
//                inquiryContent.getInquiryStatus(),
//                inquiryContent.getInquiryReply(),
//                inquiryContent.getInquiryReplyStatus(),
//                inquiryContent.getMemberCode()
//
//        );
//
//    }

}
