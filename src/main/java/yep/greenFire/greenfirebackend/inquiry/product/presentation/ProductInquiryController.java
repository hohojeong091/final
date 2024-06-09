package yep.greenFire.greenfirebackend.inquiry.product.presentation;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yep.greenFire.greenfirebackend.common.paging.Pagination;
import yep.greenFire.greenfirebackend.common.paging.PagingButtonInfo;
import yep.greenFire.greenfirebackend.common.paging.PagingResponse;
import yep.greenFire.greenfirebackend.inquiry.product.dto.ProductReplyCreateResponse;
import yep.greenFire.greenfirebackend.inquiry.product.dto.request.ProductInquiryCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.product.dto.request.ProductReplyCreateRequest;
import yep.greenFire.greenfirebackend.inquiry.product.dto.response.ProductInquiryResponse;
import yep.greenFire.greenfirebackend.inquiry.product.service.ProductInquiryService;

import java.net.URI;


@RestController
@RequestMapping("/inquiry/product")
public class ProductInquiryController {

    private ProductInquiryService productInquiryService;

    //상품 문의 조회 ( 자기가 쓴 글만 조회 vs 전체 회원이 쓴 문의글 조회 => 고민해보기. 경로때문에.  )
    @GetMapping("/view")
    public ResponseEntity<PagingResponse> getProductInquiryContents(
            @RequestParam(defaultValue = "1") final Integer page
    ) {
        final Page<ProductInquiryResponse> productInquiry = productInquiryService.getProductInquiryContent(1L, page);
        final PagingButtonInfo pagingButtonInfo = Pagination.getPagingButtonInfo(productInquiry);
        final PagingResponse pagingResponse = PagingResponse.of(productInquiry.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    @PostMapping("/member/regist")
    public ResponseEntity<ProductInquiryResponse> save(
            @RequestBody @Valid final ProductInquiryCreateRequest memberProductInquiryCreateRequest

    ) {

        final int productInquiryCode = productInquiryService.save(memberProductInquiryCreateRequest);
        return ResponseEntity.created(URI.create("/inquiry/product/list" + productInquiryCode)).build();
    }

    //seller
    //상세조회

//    @GetMapping("/list")
//    public ResponseEntity<PagingResponse> getProductInquiryList(
//            @RequestParam(defaultValue = "1") final Integer page
//    ) {
//        final Page<SellerProductInquiryResponse> sellerProductInquiryResponse = sellerProductInquiryService.getProductInquiryList(1L, page);
//        final PagingButtonInfo pagingButtonInfo = Pagination.getPagingButtonInfo(sellerProductInquiryResponse);
//        final PagingResponse pagingResponse = PagingResponse.of(sellerProductInquiryResponse.getContent(), pagingButtonInfo);
//
//        return ResponseEntity.ok(pagingResponse);


    @PostMapping("seller/regist")
    public ResponseEntity<ProductReplyCreateResponse> ProductReplysave(
            @RequestBody @Valid ProductReplyCreateRequest productReplyCreateRequest

    ) {
        final int productInquiryReplyCode = productInquiryService.productReplysave(productReplyCreateRequest);

        return ResponseEntity.created(URI.create("inquiry/product/seller/list" + productInquiryReplyCode)).build();
    }


    @GetMapping("/remove")
    public ResponseEntity<Void> remove (
            @RequestParam int inquiryCode
    ) {
        productInquiryService.remove(inquiryCode);

        return ResponseEntity.noContent().build();
    }

}