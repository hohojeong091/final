package yep.greenFire.greenfirebackend.inquiry.product.member.presentation;

import org.springframework.web.bind.annotation.*;
import yep.greenFire.greenfirebackend.inquiry.product.member.service.MemberProductInquiryService;

@RestController
@RequestMapping("/inquiry/product")
public class MemberProdutInquiryController {
    private MemberProductInquiryService memberProductInquiryService;

    //상품 문의 조회 ( 자기가 쓴 글만 조회 vs 전체 회원이 쓴 문의글 조회 => 고민해보기. 경로때문에.  )
//    @GetMapping("/list")
//    public ResponseEntity<PagingResponse> getProductInquiryContents(
//            @RequestParam(defaultValue = "1") final Integer page
//    ) {
//        final Page<MemberProductInquiryResponse> productInquiry = memberProductInquiryService.getProductInquiryContent(1L, page);
//        final PagingButtonInfo pagingButtonInfo = Pagination.getPagingButtonInfo(productInquiry);
//        final PagingResponse pagingResponse = PagingResponse.of(productInquiry.getContent(), pagingButtonInfo);
//
//        return ResponseEntity.ok(pagingResponse);
//    }
//
//    @PostMapping("/regist")
//    public ResponseEntity<MemberProductInquiryResponse> save(
//            @RequestPart @Valid final MemberProductInquiryCreatRequest memberProductInquiryCreateRequest
//    ) {
//
//        final int productInquiryCode = memberProductInquiryService.save(memberProductInquiryCreateRequest);
//        return ResponseEntity.created(URI.create("/inquiry/product/list" + productInquiryCode)).build();
//    }

}
