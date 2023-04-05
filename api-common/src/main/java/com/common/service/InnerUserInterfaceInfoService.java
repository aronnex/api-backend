package com.common.service;
import com.common.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;


public interface InnerUserInterfaceInfoService {
    /**
     *调用接口统计
     * @Param interfaceInfoId
     * @Param userId
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    UserInterfaceInfo getUserInterfaceInfo(long interfaceInfoId, long userId);

}
