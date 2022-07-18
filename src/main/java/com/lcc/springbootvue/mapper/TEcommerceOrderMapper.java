package com.lcc.springbootvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcc.springbootvue.domain.entity.TEcommerceOrder;
import com.lcc.springbootvue.domain.vo.CheckVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/7/6 6:28 PM
 **/
@Mapper
public interface TEcommerceOrderMapper  extends BaseMapper<TEcommerceOrder> {

    List<CheckVO> checkVo();
}
