package com.lick.mapper;

import com.lick.domain.OperateLog;

import java.util.List;

public interface OperateLogMapper {
    int insertOperateLog(OperateLog operateLog);
    List<OperateLog> findAllOperateLog();
}
