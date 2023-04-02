package com.aron.project.service;

import com.aron.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author aronnex
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-31 06:04:17
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceinfo, boolean add);
}
