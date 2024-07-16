package dev.omega.microshopapp.controller;

import dev.omega.microshopapp.model.dto.*;
import dev.omega.microshopapp.model.entity.*;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.model.response.ResultResponse;
import dev.omega.microshopapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserWebController {
    private final AdminService adminService;

    /*-----------------------------------------Tag---------------------------------------------------------*/
    @GetMapping("/tag")
    public ResponseEntity<ResultResList<TagEntityDto.SearchRes>> doSearch(@ModelAttribute TagEntityDto.SearchReq req) {
        log.info("In user web controller" + "search tag: {}", req);
        return ResponseEntity.ok(adminService.searchTag(req));
    }

    @GetMapping("/tag/light")
    public ResponseEntity<ResultResList<TagEntityDto.LightRes>> getAllTag() {
        log.info("In user web controller" + "search all tag light ");
        return ResponseEntity.ok(adminService.getAllTag());
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<ResultResponse<TagEntityDto.DetailRes>> getTagDetail(Long id) {
        log.info("In user web controller" + "get tag detail id: {}", id);
        return ResponseEntity.ok(adminService.getTag(id));
    }

    @PostMapping("/tag")
    public ResponseEntity<ResultResponse<TagEntity>> addTag(@RequestBody TagEntityDto.AddOrEditReq req) {
        log.info("In user web controller" + "add tag: {}", req);
        return ResponseEntity.ok(adminService.addOrEditTag(req));
    }

    @PutMapping("/tag")
    public ResponseEntity<ResultResponse<TagEntity>> editTag(@RequestBody TagEntityDto.AddOrEditReq req) {
        log.info("In user web controller" + "edit tag: {}", req.getId());
        return ResponseEntity.ok(adminService.addOrEditTag(req));
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<ResultResponse<TagEntity>> deleteTag(@PathVariable Long id) {
        log.info("In user web controller" + "delete tag: {}", id);
        return ResponseEntity.ok(adminService.deleteTag(id));
    }

    /*--------------------------------------------------Product Type--------------------------------------------------------------*/

    @PostMapping("/product-type")
    public ResponseEntity<ResultResponse<ProductTypeEntity>> addProductType(@RequestBody ProductTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProductType(req));
    }

    @PutMapping("/product-type")
    public ResponseEntity<ResultResponse<ProductTypeEntity>> editProductType(@RequestBody ProductTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProductType(req));
    }

    @DeleteMapping("/product-type/{id}")
    public ResponseEntity<ResultResponse<ProductTypeEntity>> deleteProductType(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteProductType(id));
    }

    @GetMapping("/product-type/all")
    public ResponseEntity<ResultResList<ProductTypeEntityDto.LightRes>> getAllProductType() {
        return ResponseEntity.ok(adminService.getAllProductType());
    }

    @GetMapping("/product-type/{id}")
    public ResponseEntity<ResultResponse<ProductTypeEntityDto.DetailRes>> getProductType(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getProductType(id));
    }
    @GetMapping("/product-type")
    public ResponseEntity<ResultResList<ProductTypeEntityDto.SearchRes>> searchProductType(@ModelAttribute ProductTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(adminService.searchProductType(req));
    }
    /*--------------------------------------------------Group Product Type--------------------------------------------------------------*/

    @GetMapping("/product-type-group/all")
    public ResponseEntity<ResultResList<GroupTypeEntityDto.LightRes>> getAllProductTypeGroup() {
        return ResponseEntity.ok(adminService.getAllProductTypeGroup());
    }

    @GetMapping("/product-type-group")
    public ResponseEntity<ResultResList<GroupTypeEntityDto.SearchRes>> searchProductTypeGroup(@ModelAttribute GroupTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(adminService.searchProductTypeGroup(req));
    }

    @GetMapping("/product-type-group/{id}")
    public ResponseEntity<ResultResponse<GroupTypeEntityDto.DetailRes>> getProductTypeGroup(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getProductTypeGroup(id));
    }

    @PostMapping("/product-type-group")
    public ResponseEntity<ResultResponse<GroupTypeEntity>> addProductTypeGroup(@RequestBody GroupTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProductTypeGroup(req));
    }

    @PutMapping("/product-type-group")
    public ResponseEntity<ResultResponse<GroupTypeEntity>> editProductTypeGroup(@RequestBody GroupTypeEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProductTypeGroup(req));
    }

    @DeleteMapping("/product-type-group/{id}")
    public ResponseEntity<ResultResponse<GroupTypeEntity>> deleteProductTypeGroup(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteProductTypeGroup(id));
    }
    /*--------------------------------------------------Product--------------------------------------------------------------*/

    @GetMapping("/product/all")
    public ResponseEntity<ResultResList<ProductEntity>> getAllProduct() {
        return ResponseEntity.ok(adminService.getAllProduct());
    }

    @GetMapping("/product")
    public ResponseEntity<ResultResList<ProductEntityDto.SearchRes>> searchProduct(@ModelAttribute ProductTypeEntityDto.SearchReq req) {
        return ResponseEntity.ok(adminService.searchProduct(req));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResultResponse<ProductEntityDto.DetailRes>> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getProduct(id));
    }

    @PostMapping("/product")
    public ResponseEntity<ResultResponse<ProductEntity>> addProduct(@RequestBody ProductEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProduct(req));
    }

    @PutMapping("/product")
    public ResponseEntity<ResultResponse<ProductEntity>> editProduct(@RequestBody ProductEntityDto.AddOrEditReq req) {
        return ResponseEntity.ok(adminService.addOrEditProduct(req));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResultResponse<ProductEntity>> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteProduct(id));
    }
    /*--------------------------------------------------Product Order--------------------------------------------------------------*/

    @GetMapping("/order/all")
    public ResponseEntity<ResultResList<OrderEntityDto.LightRes>> getAllOrder() {
        return ResponseEntity.ok(adminService.getAllOrder());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<ResultResponse<OrderEntityDto.DetailRes>> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getOrder(id));
    }
    @GetMapping("/order")
    public ResponseEntity<ResultResList<OrderEntityDto.SearchRes>> searchOrder(@ModelAttribute OrderEntityDto.SearchReq req) {
        return ResponseEntity.ok(adminService.searchOrder(req));
    }

    @PostMapping("/order")
    public ResponseEntity<ResultResponse<OrderEntity>> addOrder(@RequestBody OrderEntity orderEntity) {
        return ResponseEntity.ok(adminService.addOrEditOrder(orderEntity));
    }

    @PutMapping("/order")
    public ResponseEntity<ResultResponse<OrderEntity>> editOrder(@RequestBody OrderEntity orderEntity) {
        return ResponseEntity.ok(adminService.addOrEditOrder(orderEntity));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<ResultResponse<OrderEntity>> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteOrder(id));
    }

    /*--------------------------------------------------Product Order Detail--------------------------------------------------------------*/


    /*--------------------------------------------------Product Statics--------------------------------------------------------------*/

}
