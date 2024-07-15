package dev.omega.microshopapp.service.impl;

import dev.omega.microshopapp.model.dto.GroupTypeEntityDto;
import dev.omega.microshopapp.model.dto.OrderEntityDto;
import dev.omega.microshopapp.model.dto.ProductTypeEntityDto;
import dev.omega.microshopapp.model.dto.TagEntityDto;
import dev.omega.microshopapp.model.entity.GroupTypeEntity;
import dev.omega.microshopapp.model.entity.OrderEntity;
import dev.omega.microshopapp.model.entity.ProductTypeEntity;
import dev.omega.microshopapp.model.entity.TagEntity;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.model.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import dev.omega.microshopapp.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public ResponseEntity<ResultResList<ProductTypeEntityDto.LightRes>> getAllProductType() {
        
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<ProductTypeEntityDto.SearchRes>> searchProductType(ProductTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntity>> addOrEditProductType(ProductTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntity>> deleteProductType(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntity>> getProductType(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<GroupTypeEntity>> addOrEditProductTypeGroup(GroupTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<GroupTypeEntity>> deleteProductTypeGroup(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<GroupTypeEntityDto.DetailRes>> getProductTypeGroup(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<GroupTypeEntityDto.LightRes>> getAllProductTypeGroup() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<GroupTypeEntityDto.SearchRes>> searchProductTypeGroup(GroupTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntity>> addOrEditProduct(ProductTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntity>> deleteProduct(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<ProductTypeEntityDto.DetailRes>> getProduct(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<ProductTypeEntityDto.LightRes>> getAllProduct() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<ProductTypeEntityDto.SearchRes>> searchProduct(ProductTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<TagEntity>> addOrEditTag(TagEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<TagEntity>> deleteTag(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<TagEntityDto.DetailRes>> getTag(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<TagEntityDto.LightRes>> getAllTag() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<TagEntityDto.SearchRes>> searchTag(TagEntityDto.SearchReq req) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<OrderEntity>> addOrEditOrder(OrderEntity orderEntity) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<OrderEntity>> deleteOrder(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResponse<OrderEntityDto.DetailRes>> getOrder(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<OrderEntityDto.LightRes>> getAllOrder() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ResultResList<OrderEntityDto.SearchRes>> searchOrder(OrderEntityDto.SearchReq req) {
        return ResponseEntity.ok(null);
    }
}
