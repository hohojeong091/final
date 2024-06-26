package yep.greenFire.greenfirebackend.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yep.greenFire.greenfirebackend.common.exception.NotFoundException;
import yep.greenFire.greenfirebackend.common.exception.type.ExceptionCode;
import yep.greenFire.greenfirebackend.product.domain.entity.Category;
import yep.greenFire.greenfirebackend.product.domain.repository.CategoryRepository;
import yep.greenFire.greenfirebackend.product.dto.request.CategoryCreateRequest;
import yep.greenFire.greenfirebackend.product.dto.request.CategoryUpdateRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Long save(CategoryCreateRequest categoryCreateRequest) {

        final Category newCategory = Category.of(
                categoryCreateRequest.getCategoryTitle(),
                categoryCreateRequest.getRefCategoryCode()
        );

        Category category = categoryRepository.save(newCategory);
        return category.getCategoryCode();
    }


    public void modify(Long categoryCode, CategoryUpdateRequest categoryUpdateRequest) {

        Category category = categoryRepository.findById(categoryCode)
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_CATEGORY_CODE));

        category.modify(
                categoryUpdateRequest.getCategoryTitle(),
                categoryUpdateRequest.getRefCategoryCode()
        );
    }

    public void remove(Long categoryCode) {

        categoryRepository.deleteById(categoryCode);
    }
}
