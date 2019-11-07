package com.hyp.api.controller;

import com.next.common.NEXTJSONResult;
import com.next.service.MovieService;
import com.next.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @路径: com.hyp.api.controller.SearchController
 * @描述: 搜索Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-06 18:20
 **/
@RequestMapping("search")
@RestController
@Api(value = "搜索页",tags = {"搜索页的相关接口"})
public class SearchController extends BasicController{

    @Autowired
    private MovieService movieService;
    @Autowired
    private StaffService staffService;

    @ApiOperation(value = "搜索电影列表")
    @RequestMapping(value = "list",method = {RequestMethod.POST})
    public NEXTJSONResult list(
                                @ApiParam(name = "keywords",value = "查询的名称，中文/英文",required = false)
                               String keywords,
                               @ApiParam(name = "page",value = "查询的写一页的页数",required = false)
                               String page,
                               @ApiParam(name = "pageSize",value = "每页分页展示的数量",required = false)
                               String pageSize) {

        if (StringUtils.isBlank(keywords)) {
            keywords = "";
        }
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "8";
        }
        return NEXTJSONResult.ok(movieService.searchTrailer(keywords, Integer.valueOf(page), Integer.valueOf(pageSize)));
    }

    @ApiOperation(value = "预告片详情",notes = "预告片详情",httpMethod = "POST")
    @RequestMapping(value = "/trailer/{trailerId}",method = {RequestMethod.POST})
    public NEXTJSONResult trailer(
            @ApiParam(name = "trailerId",value = "预告片的主键id",required = true)
            @PathVariable String trailerId) {

        if (StringUtils.isBlank(trailerId)) {
            return NEXTJSONResult.errorMsg("请检查传入参数的完整性");
        }

        return NEXTJSONResult.ok(movieService.queryTrailerInfo(trailerId));
    }

    @ApiOperation(value = "查询演职人员",notes = "查询演职人员",httpMethod = "POST")
    @RequestMapping(value = "/staff/{trailerId}/{role}",method = {RequestMethod.POST})
    private NEXTJSONResult staffInfo(
             @ApiParam(name = "trailerId", value = "预告片的主键id", required = true)
             @PathVariable String trailerId,
             @ApiParam(name = "role", value = "演职人员的角色，[1：导演，2：演员]", required = true)
             @PathVariable Integer role){


        if (StringUtils.isBlank(trailerId)) {
            return NEXTJSONResult.errorMsg("请检查数据的完整性");
        }

        return NEXTJSONResult.ok(staffService.queryStaffs(trailerId, role));
    }


}
