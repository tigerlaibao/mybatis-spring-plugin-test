package com.mogujie.orm.test;

import com.mogujie.dao.entity.User;
import com.mogujie.dao.mapper.UserMapper;
import com.mogujie.orm.mybatis.plugin.api.query.conditions.Conditions;
import com.mogujie.orm.mybatis.plugin.api.query.where.LimitWhere;
import com.mogujie.orm.mybatis.plugin.api.query.where.SimpleWhere;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by laibao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper ;

    @Test
    public void testSelectById(){
        User user = userMapper._selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectByIds(){
        List<User> users =  userMapper._selectByIds(Arrays.asList(1L , 2L , 3L));
        System.out.println(users);
    }

    @Test
    public void testSelectAll(){
        List<User> users =  userMapper._listAll();
        System.out.println(users);
    }

    @Test
    public void testSimpleQuery01(){
        SimpleWhere where = new SimpleWhere();
        where.setOrderBy("org_id desc , id asc");
        where.setLimit(10).setLimitOffset(5);
        where.andCondition(Conditions.betweenAnd("id" , 20 , 50));
        where.or();
        where.openParenthesis();
        where.andCondition(Conditions.like("name" , "%员工%"));
        where.andCondition(Conditions.notLike("name", "%C"));
        where.closeParenthesis();
        where.orCondition(Conditions.lessThan("id" , 30 , true));
        List<User> users = userMapper._simpleQuery(where);
        System.out.println(users);
    }


    @Test
    public void testSimpleQuery02(){
        SimpleWhere where = new SimpleWhere();
        where.setOrderBy("org_id desc , id asc");
        where.setLimit(10);
        where.andCondition(Conditions.isNull("nickname"));
        where.andCondition(Conditions.greaterThan("id", 18, false));
        where.andCondition(Conditions.in("id" , Arrays.asList(18L , 22L , 23L)));
        where.andCondition(Conditions.notIn("id" , Arrays.asList(22L)));
        List<User> users = userMapper._simpleQuery(where);
        System.out.println(users);
    }


    @Test
    public void testInsert(){
        User user = new User();
        user.setName("laibao");
        user.setOrg_id(2L);
        user.setPost_id(3L);
        user.setNickname("haha");
        int insertCount = userMapper._insert(user);
        System.out.println("insertCount:" + insertCount);
        System.out.println("user:" + user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setIdx(61L);
        user.setName("laibaox");
        user.setOrg_id(2L);
        user.setPost_id(3L);
        user.setNickname("hahax");
        LimitWhere where = new LimitWhere();
        where.setLimit(2);
        where.andCondition(Conditions.equals("id" , 61L));
        int count = userMapper._update(user , where);
        System.out.println(count);
    }

    @Test
    public void testUpdateNotNullField(){
        User user = new User();
        user.setName("laibaox");
        user.setOrg_id(2L);
        user.setPost_id(3L);
        user.setNickname("hahax");
        LimitWhere where = new LimitWhere();
        where.setLimit(2);
        where.andCondition(Conditions.equals("id", 61L));
        int count = userMapper._updateNotNullField(user, where);
        System.out.println(count);
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setIdx(61L);
        user.setName("laibaox");
        user.setOrg_id(2L);
        user.setPost_id(3L);
        user.setNickname("hahax");
        int count = userMapper._updateById(user , 61L);
        System.out.println(count);
    }


    @Test
    public void testUpdateNotNullFieldById(){
        User user = new User();
        user.setIdx(61L);
        user.setName("laibaox");
        user.setOrg_id(2L);
        user.setPost_id(3L);
        user.setNickname("hahax");
        int count = userMapper._updateNotNullFieldById(user, 61L);
        System.out.println(count);
    }

    @Test
    public void testSoftDeleteById(){
        int deleteCount = userMapper._softDeleteById(61L);
        System.out.println(deleteCount);
    }

    @Test
    public void testSoftDeleteByIds(){
        int deleteCount = userMapper._softDeleteByIds(Arrays.asList(61L , 60L));
        System.out.println(deleteCount);
    }

    @Test
    public void testDeleteById(){
        int deleteCount = userMapper._deleteById(61L);
        System.out.println(deleteCount);
    }


    @Test
    public void testDeleteByIds(){
        int deleteCount = userMapper._deleteByIds(Arrays.asList(52L , 60L));
        System.out.println(deleteCount);
    }

}
