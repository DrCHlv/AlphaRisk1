package com.wondersgroup.common.util;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;
/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
@Component("partitionInterceptor")
public class PartitionInterceptor extends EmptyInterceptor{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String sourceTableName;
    private String targetTableName;

    public PartitionInterceptor(){}

    @Override
    public String onPrepareStatement(String sql){
        sql = sql.replaceAll(sourceTableName, targetTableName);
        return sql;
    }

    public String getSourceTableName() {
        return sourceTableName;
    }
    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }
    public String getTargetTableName() {
        return targetTableName;
    }
    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }

}
