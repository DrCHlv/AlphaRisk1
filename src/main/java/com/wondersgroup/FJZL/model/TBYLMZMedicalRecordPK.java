package com.wondersgroup.FJZL.model;

/**
 * Created by 319 on 2020/2/26.
 */
import java.io.Serializable;

public class TBYLMZMedicalRecordPK implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4342792380791481543L;
    private String yljgdm;
    private String jzlsh;

    public String getYljgdm() {
        return yljgdm;
    }
    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }
    public String getJzlsh() {
        return jzlsh;
    }
    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jzlsh == null) ? 0 : jzlsh.hashCode());
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
        TBYLMZMedicalRecordPK other = (TBYLMZMedicalRecordPK) obj;
        if (jzlsh == null) {
            if (other.jzlsh != null)
                return false;
        } else if (!jzlsh.equals(other.jzlsh))
            return false;
        if (yljgdm == null) {
            if (other.yljgdm != null)
                return false;
        } else if (!yljgdm.equals(other.yljgdm))
            return false;
        return true;
    }

}