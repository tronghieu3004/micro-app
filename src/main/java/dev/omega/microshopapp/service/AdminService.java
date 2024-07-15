package dev.omega.microshopapp.service;

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

public interface AdminService {

    /*------------------------------------------------Product Type-----------------------------------------------------------------------------------*/
    ResponseEntity<ResultResList<ProductTypeEntityDto.LightRes>> getAllProductType();

    ResponseEntity<ResultResList<ProductTypeEntityDto.SearchRes>> searchProductType(ProductTypeEntityDto.SearchReq req);

    ResponseEntity<ResultResponse<ProductTypeEntity>> addOrEditProductType(ProductTypeEntityDto.AddOrEditReq req);

    ResponseEntity<ResultResponse<ProductTypeEntity>> deleteProductType(Long id);

    ResponseEntity<ResultResponse<ProductTypeEntity>> getProductType(Long id);

    /*------------------------------------------------Product Type Group-----------------------------------------------------------------------------------*/
    ResponseEntity<ResultResponse<GroupTypeEntity>> addOrEditProductTypeGroup(GroupTypeEntityDto.AddOrEditReq req);

    ResponseEntity<ResultResponse<GroupTypeEntity>> deleteProductTypeGroup(Long id);

    ResponseEntity<ResultResponse<GroupTypeEntityDto.DetailRes>> getProductTypeGroup(Long id);

    ResponseEntity<ResultResList<GroupTypeEntityDto.LightRes>> getAllProductTypeGroup();

    ResponseEntity<ResultResList<GroupTypeEntityDto.SearchRes>> searchProductTypeGroup(GroupTypeEntityDto.SearchReq req);

    /*------------------------------------------------Product -----------------------------------------------------------------------------------*/

    /*------------------------------------------------Product Type-----------------------------------------------------------------------------------*/
    ResponseEntity<ResultResponse<ProductTypeEntity>> addOrEditProduct(ProductTypeEntityDto.AddOrEditReq req);

    ResponseEntity<ResultResponse<ProductTypeEntity>> deleteProduct(Long id);

    ResponseEntity<ResultResponse<ProductTypeEntityDto.DetailRes>> getProduct(Long id);

    ResponseEntity<ResultResList<ProductTypeEntityDto.LightRes>> getAllProduct();

    ResponseEntity<ResultResList<ProductTypeEntityDto.SearchRes>> searchProduct(ProductTypeEntityDto.SearchReq req);

    /*------------------------------------------------Product Tag-----------------------------------------------------------------------------------*/
    ResponseEntity<ResultResponse<TagEntity>> addOrEditTag(TagEntityDto.AddOrEditReq req);

    ResponseEntity<ResultResponse<TagEntity>> deleteTag(Long id);

    ResponseEntity<ResultResponse<TagEntityDto.DetailRes>> getTag(Long id);

    ResponseEntity<ResultResList<TagEntityDto.LightRes>> getAllTag();

    ResponseEntity<ResultResList<TagEntityDto.SearchRes>> searchTag(TagEntityDto.SearchReq req);


    /*------------------------------------------------Product Order-----------------------------------------------------------------------------------*/

    ResponseEntity<ResultResponse<OrderEntity>> addOrEditOrder(OrderEntity orderEntity);

    ResponseEntity<ResultResponse<OrderEntity>> deleteOrder(Long id);

    ResponseEntity<ResultResponse<OrderEntityDto.DetailRes>> getOrder(Long id);

    ResponseEntity<ResultResList<OrderEntityDto.LightRes>> getAllOrder();

    ResponseEntity<ResultResList<OrderEntityDto.SearchRes>> searchOrder(OrderEntityDto.SearchReq req);
}
