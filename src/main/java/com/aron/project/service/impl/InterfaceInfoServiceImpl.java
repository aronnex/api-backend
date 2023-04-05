package com.aron.project.service.impl;

import com.aron.project.common.ErrorCode;
import com.aron.project.exception.BusinessException;
import com.aron.project.mapper.InterfaceInfoMapper;
import com.aron.project.service.InterfaceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author aronnex
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-03-31 06:04:17
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceinfo, boolean add) {
        if (interfaceinfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceinfo.getName();
        String method = interfaceinfo.getMethod();
        String url = interfaceinfo.getUrl();
        Long userId = interfaceinfo.getUserId();

        // 创建时校验，所有参数必须非空，这只是部分，可以自己补全
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }

        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




