package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Address;
import com.gk.study.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
/**
 * @author lengqin1024(微信)
 * @email net936@163.com
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(String userId){
        List<Address> list =  service.getAddressList(userId);
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(Address address) throws IOException {
        if(address.getDef().equals("1")){
            // 其它置0
            List<Address> list =  service.getAddressList(address.getUserId());
            for(Address address1: list) {
                address1.setDef("0");
                service.updateAddress(address1);
            }
        }
        service.createAddress(address);
        return new APIResponse(ResponeCode.SUCCESS, "创建成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.deleteAddress(id);
        }
        return new APIResponse(ResponeCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(Address address) throws IOException {
        if(address.getDef().equals("1")){
            // 其它置0
            List<Address> list =  service.getAddressList(address.getUserId());
            for(Address address1: list) {
                address1.setDef("0");
                service.updateAddress(address1);
            }
        }
        service.updateAddress(address);
        return new APIResponse(ResponeCode.SUCCESS, "更新成功");
    }

}
