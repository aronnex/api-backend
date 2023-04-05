package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.entity.User;

public interface InnerUserService{
    /**
     * 数据库中是否已分配给用户秘钥(accessKey)
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
