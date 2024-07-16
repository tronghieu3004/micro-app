package dev.omega.microshopapp.service;

import dev.omega.microshopapp.model.dto.*;
import dev.omega.microshopapp.model.entity.*;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.model.response.ResultResponse;

public interface AdminService {

    /*------------------------------------------------Product Type-----------------------------------------------------------------------------------*/
    ResultResList<ProductTypeEntityDto.LightRes> getAllProductType();

    ResultResList<ProductTypeEntityDto.SearchRes> searchProductType(ProductTypeEntityDto.SearchReq req);

    ResultResponse<ProductTypeEntity> addOrEditProductType(ProductTypeEntityDto.AddOrEditReq req);

    ResultResponse<ProductTypeEntity> deleteProductType(Long id);

    ResultResponse<ProductTypeEntityDto.DetailRes> getProductType(Long id);

    /*------------------------------------------------Product Type Group-----------------------------------------------------------------------------------*/
    ResultResponse<GroupTypeEntity> addOrEditProductTypeGroup(GroupTypeEntityDto.AddOrEditReq req);

    ResultResponse<GroupTypeEntity> deleteProductTypeGroup(Long id);

    ResultResponse<GroupTypeEntityDto.DetailRes> getProductTypeGroup(Long id);

    ResultResList<GroupTypeEntityDto.LightRes> getAllProductTypeGroup();

    ResultResList<GroupTypeEntityDto.SearchRes> searchProductTypeGroup(GroupTypeEntityDto.SearchReq req);

    /*------------------------------------------------Product -----------------------------------------------------------------------------------*/

    ResultResponse<ProductEntity> addOrEditProduct(ProductEntityDto.AddOrEditReq req);

    ResultResponse<ProductEntity> deleteProduct(Long id);

    ResultResponse<ProductEntityDto.DetailRes> getProduct(Long id);

    ResultResList<ProductEntity> getAllProduct();

    ResultResList<ProductEntityDto.SearchRes> searchProduct(ProductTypeEntityDto.SearchReq req);

    /*------------------------------------------------Product Tag-----------------------------------------------------------------------------------*/
    ResultResponse<TagEntity> addOrEditTag(TagEntityDto.AddOrEditReq req);

    ResultResponse<TagEntity> deleteTag(Long id);

    ResultResponse<TagEntityDto.DetailRes> getTag(Long id);

    ResultResList<TagEntityDto.LightRes> getAllTag();

    ResultResList<TagEntityDto.SearchRes> searchTag(TagEntityDto.SearchReq req);


    /*------------------------------------------------Product Order-----------------------------------------------------------------------------------*/

    ResultResponse<OrderEntity> addOrEditOrder(OrderEntity orderEntity);

    ResultResponse<OrderEntity> deleteOrder(Long id);

    ResultResponse<OrderEntityDto.DetailRes> getOrder(Long id);

    ResultResList<OrderEntityDto.LightRes> getAllOrder();

    ResultResList<OrderEntityDto.SearchRes> searchOrder(OrderEntityDto.SearchReq req);
}
