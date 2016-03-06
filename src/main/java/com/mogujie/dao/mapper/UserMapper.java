package com.mogujie.dao.mapper;

import com.mogujie.dao.entity.User;
import com.mogujie.orm.mybatis.plugin.api.annotation.MapperInfo;

/**
 * Created by laibao
 */
@MapperInfo(entity = User.class)
public interface UserMapper extends MyMapper<User, Long> {



}
