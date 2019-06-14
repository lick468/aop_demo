package com.lick.service.impl;

import com.lick.domain.OperateLog;
import com.lick.mapper.OperateLogMapper;
import com.lick.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public int insertOperateLog(OperateLog operateLog) {
        return operateLogMapper.insertOperateLog(operateLog);
    }

    @Override
    public List<OperateLog> findAllOperateLog() {
        return operateLogMapper.findAllOperateLog();
    }
}
