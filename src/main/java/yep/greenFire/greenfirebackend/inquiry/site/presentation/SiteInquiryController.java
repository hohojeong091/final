package yep.greenFire.greenfirebackend.inquiry.site.presentation;



import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import yep.greenFire.greenfirebackend.auth.type.CustomUser;
import yep.greenFire.greenfirebackend.common.paging.Pagination;
import yep.greenFire.greenfirebackend.common.paging.PagingButtonInfo;
import yep.greenFire.greenfirebackend.common.paging.PagingResponse;
import yep.greenFire.greenfirebackend.inquiry.entity.InquiryContent;
import yep.greenFire.greenfirebackend.inquiry.site.dto.request.ReplyInquiryCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.site.dto.response.AdminInquiryResponse;
import yep.greenFire.greenfirebackend.inquiry.site.service.SiteInquiryService;
import yep.greenFire.greenfirebackend.inquiry.site.dto.request.InquiryCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.site.dto.response.MemberInquiryResponse;

import java.net.URI;

@RestController
@RequestMapping("/inquiry")
public class SiteInquiryController {

        private SiteInquiryService siteInquiryService;
        @GetMapping("/inquiry/view")
        public ResponseEntity<PagingResponse> getInquiryContent(
            @RequestParam(defaultValue = "1") final Integer page

    ) {
            //엑세스 토큰에 유저롤에 대한 정보가 있을 경우에
//            if(userGrant.equals("MANAGER")) {
//                sdfsdf
//            }
//
//            else if(userGrant.equalt("user")) {
//                sdfsdf
//            }

        final Page<MemberInquiryResponse> inquiryResponse = siteInquiryService.getInquiryContent(1L, page);
        final PagingButtonInfo pagingButtonInfo = Pagination.getPagingButtonInfo(inquiryResponse);
        final PagingResponse pagingResponse = PagingResponse.of(inquiryResponse.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    @PostMapping("/members/regist")
    public ResponseEntity<MemberInquiryResponse> save (
            @RequestBody @Valid final InquiryCreateRequest inquiryCreateRequest,
            @AuthenticationPrincipal CustomUser customUser
    ) {
        System.out.println("save실행 ");
        System.out.println("getInquiryTitle : " + inquiryCreateRequest.getInquiryTitle());
        System.out.println("getInquiryDetail : " + inquiryCreateRequest.getInquiryDetail());
        System.out.println(("customUser : " + customUser.getAuthorities()) );

        final int inquiryCode = siteInquiryService.save(inquiryCreateRequest, customUser);

        return ResponseEntity.created(URI.create("/view" +inquiryCode)).build();


    }


    //사이트 문의 답변 등록
    @GetMapping("/admin/regist")
    public ResponseEntity<AdminInquiryResponse> save (
            @RequestBody @Valid final ReplyInquiryCreateRequest replyInquiryCreateRequest,
            @AuthenticationPrincipal CustomUser customUser
    ) {
        final int inquiryCode = siteInquiryService.Replysave(replyInquiryCreateRequest, customUser);
        return ResponseEntity.created(URI.create("/admin/list" + inquiryCode)).build();
    }


    //문의 삭제

    @GetMapping("admin/remove")
    public ResponseEntity<Void> remove (@RequestParam final int inquiryCode) {
        siteInquiryService.remove(inquiryCode);

        return ResponseEntity.noContent().build();
    }
}


