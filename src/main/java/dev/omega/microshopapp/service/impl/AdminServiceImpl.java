package dev.omega.microshopapp.service.impl;

import dev.omega.microshopapp.configuration.GlobalErrorCode;
import dev.omega.microshopapp.model.dto.*;
import dev.omega.microshopapp.model.entity.*;
import dev.omega.microshopapp.model.response.Pagination;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.model.response.ResultResponse;
import dev.omega.microshopapp.repository.*;
import dev.omega.microshopapp.service.AdminService;
import dev.omega.microshopapp.utils.BaseUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final TagEntityRepository tagRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailEntityRepository orderDetailRepository;
    private final GroupTypeRepository groupTypeRepository;

    @Override
    public ResultResList<ProductTypeEntityDto.LightRes> getAllProductType() {
        log.info("In admin service, get all product type light");
        List<ProductTypeEntityDto.LightRes> lightResList = productTypeRepository.findAllLightRes();
        return new ResultResList<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, null,lightResList);
    }

    @Override
    public ResultResList<ProductTypeEntityDto.SearchRes> searchProductType(ProductTypeEntityDto.SearchReq req) {
        log.info("In admin service, search product type: {}", req);
        Pageable pageable = PageRequest.ofSize(req.getPageSize()).withPage(Math.toIntExact(req.getPageNo())).withSort(Sort.by("id").descending());
        Page<ProductTypeEntityDto.SearchRes> page = productTypeRepository.doSearch(req.getCode(), req.getGroupTypeCode(),req.getNoOfProduct(),pageable);
        Pagination pag = Pagination.builder()
                .pageNo(req.getPageNo())
                .pageSize(req.getPageSize())
                .totalPages(page.getTotalPages())
                .totalItems(page.getTotalElements())
                .build();
        return new ResultResList<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, page.getContent(), pag);
    }

    @Override
    public ResultResponse<ProductTypeEntity> addOrEditProductType(ProductTypeEntityDto.AddOrEditReq req) {
        log.info("In admin service, add or edit product type: {}", req);
        boolean existCode = productTypeRepository.findByCode(req.getCode()).isPresent();
        ProductTypeEntity entity = new ProductTypeEntity();

        if (req.getId() != null) {
            entity = productTypeRepository.findById(req.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Product type")
            );
            if (existCode && !entity.getCode().equals(req.getCode())) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "type.edit.success", null);
            }
        }else {
            if (existCode) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "type.add.success", null);
            }
        }
        BeanUtils.copyProperties(entity, req);
        ProductTypeEntity save = productTypeRepository.save(entity);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "type.saved.success" , save);
    }

    @Override
    public ResultResponse<ProductTypeEntity> deleteProductType(Long id) {
        log.info("In admin service, delete product type: {}", id);
        ProductTypeEntity entity = productTypeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product type")
        );
        productTypeRepository.delete(entity);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "type.deleted.success" , entity);
    }

    @Override
    public ResultResponse<ProductTypeEntityDto.DetailRes> getProductType(Long id) {
        return null;
    }
/*------------------------------------------------Group Type--------------------------------------------------------------*/
    @Override
    public ResultResponse<GroupTypeEntity> addOrEditProductTypeGroup(GroupTypeEntityDto.AddOrEditReq req) {
        return null;
    }

    @Override
    public ResultResponse<GroupTypeEntity> deleteProductTypeGroup(Long id) {
        return null;
    }

    @Override
    public ResultResponse<GroupTypeEntityDto.DetailRes> getProductTypeGroup(Long id) {
        return null;
    }

    @Override
    public ResultResList<GroupTypeEntityDto.LightRes> getAllProductTypeGroup() {
        return null;
    }

    @Override
    public ResultResList<GroupTypeEntityDto.SearchRes> searchProductTypeGroup(GroupTypeEntityDto.SearchReq req) {
        return null;
    }
/*------------------------------------------------Product-------------------------------------------------------------*/
    @Override
    public ResultResponse<ProductEntity> addOrEditProduct(ProductEntityDto.AddOrEditReq req) {
        log.info("In admin service, add or edit product: {}", req);
        boolean existCode = productRepository.findByCode(req.getCode()).isPresent();
        ProductEntity entity = new ProductEntity();
        if (req.getId() != null) {
            entity = productRepository.findById(req.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Product")
            );
            if (existCode && !entity.getCode().equals(req.getCode())) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "product.edit.success", null);
            }
        }else {
            if (existCode) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "product.add.success", null);
            }
        }
        BeanUtils.copyProperties(entity, req);
        if (req.getProductType() != null) {
            ProductTypeEntity productType = productTypeRepository.findById(req.getProductType().getId()).orElseThrow(
                    () -> new EntityNotFoundException("Product type")
            );
            entity.setProductType(productType);
        }
        if (!req.getTags().isEmpty()){
            List<TagEntity> tags = tagRepository.findAllById(req.getTags().stream().map(TagEntityDto.LightRes::getId).toList());
            entity.setTags(tags);
        }
        ProductEntity save = productRepository.save(entity);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "product.saved.success", save);
    }

    @Override
    public ResultResponse<ProductEntity> deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResultResponse<ProductEntityDto.DetailRes> getProduct(Long id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product")
        );
        ProductEntityDto.DetailRes res = new ProductEntityDto.DetailRes();
        BeanUtils.copyProperties(entity, res);
        ProductTypeEntity eType = productTypeRepository.findById(entity.getProductType().getId())
                .orElseThrow(() -> new EntityNotFoundException("Product type"));
        ProductTypeEntityDto.DetailRes type = new ProductTypeEntityDto.DetailRes();
        BeanUtils.copyProperties(type, eType);
        res.setProductType(type);
        entity.getTags().forEach(tag -> res.getTags().add(new TagEntityDto.LightRes(tag.getId(), tag.getName())));
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "product.get.success", res);
    }

    @Override
    public ResultResList<ProductEntity> getAllProduct() {
        return null;
    }

    @Override
    public ResultResList<ProductEntityDto.SearchRes> searchProduct(ProductTypeEntityDto.SearchReq req) {
        return null;
    }
/*--------------------------------------------------------------Tag--------------------------------------------------------------*/
    @Override
    public ResultResponse<TagEntity> addOrEditTag(TagEntityDto.AddOrEditReq req) {
        log.info("In admin service, add or edit tag: {}", req);
        boolean exist = tagRepository.findByNameContaining(req.getName()).isPresent();
        TagEntity entity = new TagEntity();
        if (req.getId() != null) {
            entity = tagRepository.findById(req.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Tag")
            );
            if (exist && !entity.getName().equals(req.getName())) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "tag.edit.success", null);
            }
        }else {
            if (exist) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "tag.add.success", null);
            }
        }
        BeanUtils.copyProperties(entity, req);
        TagEntity save = tagRepository.save(entity);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "tag.saved.success", save);
    }

    @Override
    public ResultResponse<TagEntity> deleteTag(Long id) {
        TagEntity tag = tagRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tag")
        );
        tagRepository.delete(tag);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "tag.deleted.success", null);
    }

    @Override
    public ResultResponse<TagEntityDto.DetailRes> getTag(Long id) {
        log.info("In admin service, get tag: {}", id);
        TagEntity entity = tagRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tag")
        );
        TagEntityDto.DetailRes res = new TagEntityDto.DetailRes();
        BeanUtils.copyProperties(entity, res);
        entity.getProducts().forEach(product -> res.getProducts().add(new ProductEntityDto.LightRes(product.getId(), product.getName())));
        res.setNoOfProduct(entity.getProducts().size());
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "tag.get.success", res);
    }

    @Override
    public ResultResList<TagEntityDto.LightRes> getAllTag() {
        log.info("In admin service, get all tag");
        List<TagEntityDto.LightRes> res = tagRepository.findAllLightRes();
        return new ResultResList<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "tag.get.success", res);
    }

    @Override
    public ResultResList<TagEntityDto.SearchRes> searchTag(TagEntityDto.SearchReq req) {
        return null;
    }

    @Override
    public ResultResponse<OrderEntity> addOrEditOrder(OrderEntity orderEntity) {
        log.info("In admin service, add or edit order: {}", orderEntity);
        boolean exist = orderRepository.findByCode(orderEntity.getCode()).isPresent();
        if (orderEntity.getId() != null) {
            orderEntity = orderRepository.findById(orderEntity.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Order")
            );
            if (exist && !orderRepository.findById(orderEntity.getId()).get().getCode().equals(orderEntity.getCode())) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "order.edit.success", null);
            }
        }else {
            if (exist) {
                return new ResultResponse<>(GlobalErrorCode.GeneralCode.DUPLICATE, "order.add.success", null);
            }
            orderEntity.setCode(orderRepository.findNextCode());
        }
        OrderEntity save = orderRepository.save(orderEntity);

        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "order.saved.success", save);
    }

    @Override
    public ResultResponse<OrderEntity> deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Order")
        );
        orderRepository.delete(order);
        return new ResultResponse<>(BaseUtils.GlobalSuccessCode.CALL_API_SUCCESS, "order.deleted.success", null);
    }

    @Override
    public ResultResponse<OrderEntityDto.DetailRes> getOrder(Long id) {
        return null;
    }

    @Override
    public ResultResList<OrderEntityDto.LightRes> getAllOrder() {
        return null;
    }

    @Override
    public ResultResList<OrderEntityDto.SearchRes> searchOrder(OrderEntityDto.SearchReq req) {
        return null;
    }
}
