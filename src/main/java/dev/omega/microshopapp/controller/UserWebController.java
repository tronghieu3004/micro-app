package dev.omega.microshopapp.controller;

import dev.omega.microshopapp.model.dto.TagEntityDto;
import dev.omega.microshopapp.model.entity.TagEntity;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.model.response.ResultResponse;
import dev.omega.microshopapp.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserWebController {
    private final AdminService adminService;

    /*-----------------------------------------Tag---------------------------------------------------------*/
    @GetMapping("/tag")
    public ResponseEntity<ResultResList<TagEntityDto.SearchRes>> doSearch(@ModelAttribute TagEntityDto.SearchReq req) {
        log.info("In user web controller"+"search tag: {}", req);
        return adminService.searchTag(req);
    }

    @GetMapping("/tag/light")
    public ResponseEntity<ResultResList<TagEntityDto.LightRes>> getAllTag() {
        log.info("In user web controller"+"search all tag light ");
        return adminService.getAllTag();
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<ResultResponse<TagEntityDto.DetailRes>> getTagDetail(Long id) {
        log.info("In user web controller"+"get tag detail id: {}", id);
        return adminService.getTag(id);
    }

    @PostMapping("/tag")
    public ResponseEntity<ResultResponse<TagEntity>> addTag(@RequestBody TagEntityDto.AddOrEditReq req) {
        log.info("In user web controller"+"add tag: {}", req);
        return adminService.addOrEditTag(req);
    }
    @PutMapping("/tag")
    public ResponseEntity<ResultResponse<TagEntity>> editTag(@RequestBody TagEntityDto.AddOrEditReq req) {
        log.info("In user web controller"+"edit tag: {}", req.getId());
        return adminService.addOrEditTag(req);
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<ResultResponse<TagEntity>> deleteTag(@PathVariable Long id) {
        log.info("In user web controller"+"delete tag: {}", id);
        return adminService.deleteTag(id);
    }

    /*--------------------------------------------------Product Type--------------------------------------------------------------*/

    /*--------------------------------------------------Group Product Type--------------------------------------------------------------*/

    /*--------------------------------------------------Product--------------------------------------------------------------*/

    /*--------------------------------------------------Product Order--------------------------------------------------------------*/

    /*--------------------------------------------------Product Order Detail--------------------------------------------------------------*/

    /*--------------------------------------------------Product Statics--------------------------------------------------------------*/

}
