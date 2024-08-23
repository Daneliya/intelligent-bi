package com.xxl.xubi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.xubi.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
 * @Entity com.xxl.xubi.model.entity.Chart
 */
public interface ChartMapper extends BaseMapper<Chart> {

    List<Map<String, Object>> queryChartData(String querySql);
}




