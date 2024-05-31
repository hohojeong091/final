package yep.greenFire.greenfirebackend.product.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yep.greenFire.greenfirebackend.admin.category.domain.entity.Category;
import yep.greenFire.greenfirebackend.product.domain.entity.Product;
import yep.greenFire.greenfirebackend.user.seller.domain.entity.Store;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsResponse {

    private final Long productCode;
    private final String productName;
    private final Long categoryCode;
    private final Long storeCode;

    public static ProductsResponse from(final Product product) {
        return new ProductsResponse (
            product.getProductCode(),
            product.getProductName(),
            product.getCategoryCode(),
            product.getStoreCode()

        );
    }

}
