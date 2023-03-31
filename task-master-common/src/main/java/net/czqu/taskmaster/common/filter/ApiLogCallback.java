package net.czqu.taskmaster.common.filter;

import net.czqu.taskmaster.common.dto.ApiLogDTO;

public interface ApiLogCallback {
    void onFinished(ApiLogDTO logDTO);

}
