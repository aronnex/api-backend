package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.entity.InterfaceInfo;

public interface InnerInterfaceInfoService {
    /**
     * 从数据库中查询接口是否存在（请求路径、请求方法、请求参数）
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
