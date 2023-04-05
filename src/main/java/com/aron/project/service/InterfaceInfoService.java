package com.aron.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.entity.InterfaceInfo;

/**
* @author aronnex
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-31 06:04:17
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceinfo, boolean add);
}
