package com.gk.study.service;


import com.gk.study.entity.OpLog;

import java.util.List;

public interface OpLogService {
    List<OpLog> getOpLogList();
    void createOpLog(OpLog opLog);
    void deleteOpLog(String id);
    void updateOpLog(OpLog opLog);

    List<OpLog> getLoginLogList();
}
