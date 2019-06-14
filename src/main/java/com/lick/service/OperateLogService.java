package com.lick.service;

import com.lick.domain.OperateLog;

import java.util.List;

public interface OperateLogService {
    int insertOperateLog(OperateLog operateLog);
    List<OperateLog> findAllOperateLog();
}
