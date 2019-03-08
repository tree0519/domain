package com.liu.domain.utils;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.liu.domain.entity.BaseModel;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author Administrator
 * @date 2018/4/2
 */
public class ModelInitData {
    public static void addUpdateInit(BaseModel baseModel, Long userId, String ipAddr, boolean isUpdate) {
        Date now = DateTime.now().toDate();
        if(!isUpdate) {
            baseModel.setId(IdWorker.getId());
            baseModel.setCreateIp(ipAddr);
            baseModel.setCreateTime(now);
            baseModel.setCreateUser(String.valueOf(userId));
        }

        baseModel.setUpdateIp(ipAddr);
        baseModel.setUpdateTime(now);
        baseModel.setUpdateUser(String.valueOf(userId));
    }
}
