package com.mogujie.dao.filter;

import com.mogujie.orm.mybatis.plugin.Configuration;
import com.mogujie.orm.mybatis.plugin.core.MapperDocumentInfo;
import com.mogujie.orm.mybatis.plugin.filter.impl.AbstractAddNodeFilter;

/**
 * 给**mapper.xml中加上deleteByWhere
 * Created by laibao
 */
public class AddListAllFilter extends AbstractAddNodeFilter{

    private static final String template =
            "<select id=\"_listAll\" resultMap=\"simpleResultMap\">" +
                    "select <include refid=\"simpleColumnList\"/> from %s \n" +
            "</select>";

    @Override
    protected String getNode(MapperDocumentInfo mapperDocumentInfo, Configuration configuration) {
        return String.format(template ,
                mapperDocumentInfo.getTableName());
    }

}
