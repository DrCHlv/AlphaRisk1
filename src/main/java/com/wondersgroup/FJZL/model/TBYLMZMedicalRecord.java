package com.wondersgroup.FJZL.model;

/**
 * Created by 319 on 2020/2/26.
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_YL_MZ_Medical_Record")
@IdClass(TBYLMZMedicalRecordPK.class)
public class TBYLMZMedicalRecord {
    private String yljgdm;
    private String jzlsh;
    private String wsjgdm;
    private String cisid;
    private String kh;
    private String klx;
    private String hzxm;
    private String jzlx;
    private String bxlx;
    private String ybzhbz;
    private String jzksbm;
    private String jzksmc;
    private Date jzksrq;
    private String zzysgh;
    private String zzysxm;
    private String zzyssfz;
    private String jzzdbm;
    private String bmlx;
    private String jzzdsm;
    private String zs;
    private String zzms;
    private String xgbz;
    private String mj;

    @Id
    @Column(name="YLJGDM", length=11)
    public String getYljgdm() {
        return yljgdm;
    }
    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }

    @Id
    @Column(name="JZLSH", length=32)
    public String getJzlsh() {
        return jzlsh;
    }
    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    @Column(name="WSJGDM", length=22)
    public String getWsjgdm() {
        return wsjgdm;
    }
    public void setWsjgdm(String wsjgdm) {
        this.wsjgdm = wsjgdm;
    }

    @Column(name="CISID", length=32)
    public String getCisid() {
        return cisid;
    }
    public void setCisid(String cisid) {
        this.cisid = cisid;
    }

    @Column(name="KH", length=32, nullable=false)
    public String getKh() {
        return kh;
    }
    public void setKh(String kh) {
        this.kh = kh;
    }

    @Column(name="KLX", length=16, nullable=false)
    public String getKlx() {
        return klx;
    }
    public void setKlx(String klx) {
        this.klx = klx;
    }

    @Column(name="HZXM", length=32, nullable=false)
    public String getHzxm() {
        return hzxm;
    }
    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    @Column(name="JZLX", length=3, nullable=false)
    public String getJzlx() {
        return jzlx;
    }
    public void setJzlx(String jzlx) {
        this.jzlx = jzlx;
    }

    @Column(name="BXLX", length=20, nullable=false)
    public String getBxlx() {
        return bxlx;
    }
    public void setBxlx(String bxlx) {
        this.bxlx = bxlx;
    }

    @Column(name="YBZHBZ", length=20)
    public String getYbzhbz() {
        return ybzhbz;
    }
    public void setYbzhbz(String ybzhbz) {
        this.ybzhbz = ybzhbz;
    }

    @Column(name="JZKSBM", length=15, nullable=false)
    public String getJzksbm() {
        return jzksbm;
    }
    public void setJzksbm(String jzksbm) {
        this.jzksbm = jzksbm;
    }

    @Column(name="JZKSMC", length=30, nullable=false)
    public String getJzksmc() {
        return jzksmc;
    }
    public void setJzksmc(String jzksmc) {
        this.jzksmc = jzksmc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="JZKSRQ", nullable=false)
    public Date getJzksrq() {
        return jzksrq;
    }
    public void setJzksrq(Date jzksrq) {
        this.jzksrq = jzksrq;
    }

    @Column(name="ZZYSGH", length=18, nullable=false)
    public String getZzysgh() {
        return zzysgh;
    }
    public void setZzysgh(String zzysgh) {
        this.zzysgh = zzysgh;
    }

    @Column(name="ZZYSXM", length=18, nullable=false)
    public String getZzysxm() {
        return zzysxm;
    }
    public void setZzysxm(String zzysxm) {
        this.zzysxm = zzysxm;
    }

    @Column(name="ZZYSSFZ", length=18, nullable=false)
    public String getZzyssfz() {
        return zzyssfz;
    }
    public void setZzyssfz(String zzyssfz) {
        this.zzyssfz = zzyssfz;
    }

    @Column(name="JZZDBM", length=32, nullable=false)
    public String getJzzdbm() {
        return jzzdbm;
    }
    public void setJzzdbm(String jzzdbm) {
        this.jzzdbm = jzzdbm;
    }

    @Column(name="BMLX", length=2, nullable=false)
    public String getBmlx() {
        return bmlx;
    }
    public void setBmlx(String bmlx) {
        this.bmlx = bmlx;
    }

    @Column(name="JZZDSM", length=512)
    public String getJzzdsm() {
        return jzzdsm;
    }
    public void setJzzdsm(String jzzdsm) {
        this.jzzdsm = jzzdsm;
    }

    @Column(name="ZS", length=1024)
    public String getZs() {
        return zs;
    }
    public void setZs(String zs) {
        this.zs = zs;
    }

    @Column(name="ZZMS", length=1024)
    public String getZzms() {
        return zzms;
    }
    public void setZzms(String zzms) {
        this.zzms = zzms;
    }

    @Column(name="XGBZ", length=1, nullable=false)
    public String getXgbz() {
        return xgbz;
    }
    public void setXgbz(String xgbz) {
        this.xgbz = xgbz;
    }

    @Column(name="MJ", length=16)
    public String getMj() {
        return mj;
    }
    public void setMj(String mj) {
        this.mj = mj;
    }

}