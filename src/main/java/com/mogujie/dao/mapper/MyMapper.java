package com.mogujie.dao.mapper;

import com.mogujie.orm.mybatis.plugin.mapper.SimpleMapper;

import java.util.List;

/**
 * 扩展mapper
 * Created by laibao
 */
public interface MyMapper<T , PK> extends SimpleMapper<T , PK> {

    List<T> _listAll();

}
