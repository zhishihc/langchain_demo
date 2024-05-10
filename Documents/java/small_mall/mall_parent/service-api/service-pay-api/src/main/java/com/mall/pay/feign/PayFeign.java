package com.mall.pay.feign;

import entity.Result;
import entity.StatusCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/9 11:36 上午
 */

@FeignClient(value = "pay")
@RequestMapping("/close")
public interface PayFeign {
    @GetMapping("/{id}")
    public Result<Map>  closePay(@RequestParam Long orderId);
}


//    @RequestMapping("/close")
//    public Result<Map>  weixinClose(@RequestParam Long orderId) {
//        try {
//            Map<String, String> resultMap = weixinPayService.closePay(orderId);
//            return new Result<Map>(true, StatusCode.OK, "订单关闭成功", resultMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//@FeignClient(value = "goods")
//@RequestMapping("/category")
//public interface CategoryFeign {
//    @GetMapping("/{id}")
//    public Result<Category> findById(@PathVariable(name = "id") Integer id);
//}
