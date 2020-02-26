package com.wondersgroup.FJZL.model;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.io.Serializable;

/**
 * TBCisPrescriptionDetail 主键类
 * @author 319
 */
public class TBCisPrescriptionDetailPK implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String cyh;
    private String cfmxh;
    private String yljgdm;
    public String getCyh() {
        return cyh;
    }
    public void setCyh(String cyh) {
        this.cyh = cyh;
    }
    public String getCfmxh() {
        return cfmxh;
    }
    public void setCfmxh(String cfmxh) {
        this.cfmxh = cfmxh;
    }
    public String getYljgdm() {
        return yljgdm;
    }
    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cfmxh == null) ? 0 : cfmxh.hashCode());
        result = prime * result + ((cyh == null) ? 0 : cyh.hashCode());
        result = prime * result + ((yljgdm == null) ? 0 : yljgdm.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TBCisPrescriptionDetailPK other = (TBCisPrescriptionDetailPK) obj;
        if (cfmxh == null) {
            if (other.cfmxh != null)
                return false;
        } else if (!cfmxh.equals(other.cfmxh))
            return false;
        if (cyh == null) {
            if (other.cyh != null)
                return false;
        } else if (!cyh.equals(other.cyh))
            return false;
        if (yljgdm == null) {
            if (other.yljgdm != null)
                return false;
        } else if (!yljgdm.equals(other.yljgdm))
            return false;
        return true;
    }

}
