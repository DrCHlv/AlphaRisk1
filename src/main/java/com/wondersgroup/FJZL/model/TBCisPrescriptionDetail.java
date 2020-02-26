package com.wondersgroup.FJZL.model;

/**
 * Created by WJW_DB_JX on 2020/2/26.
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
@Table(name="TB_CIS_Prescription_Detail")
@IdClass(TBCisPrescriptionDetailPK.class)
public class TBCisPrescriptionDetail {
    private String cyh;
    private String cfmxh;
    private String yljgdm;
    private String wsjgdm;
    private String jzlsh;
    private String cxbz;
    private String kh;
    private String klx;
    private String jzksdm;
    private String kfys;
    private String kfysxm;
    private String kfyssfz;
    private Date kfrq;
    private String xmbm;
    private String xmbmyb;
    private String scph;
    private String yxqz;
    private String xmmc;
    private String cflx;
    private String jxdm;
    private String ypgg;
    private String ypyf;
    private String ypsl;
    private String ypdw;
    private String cfts;
    private String yzzh;
    private String sypcdm;
    private String sypc;
    private String jl;
    private String dw;
    private String mcsl;
    private String mcdw;
    private String yf;
    private String yyts;
    private String jydm;
    private String sfps;
    private String jcbw;
    private String bz;
    private String mj;
    /**
     * 补传标志位:用于记录本条数据是否补传到响应的数据库中
     * 0:不用补传,1:需要补传
     */
    private String bcbz;

    @Id
    @Column(name="CYH", length=64)
    public String getCyh() {
        return cyh;
    }

    @Id
    @Column(name="CFMXH", length=64)
    public String getCfmxh() {
        return cfmxh;
    }

    @Id
    @Column(name="YLJGDM", length=11)
    public String getYljgdm() {
        return yljgdm;
    }

    @Column(name="WSJGDM", length=22)
    public String getWsjgdm() {
        return wsjgdm;
    }

    @Column(name="JZLSH", length=32)
    public String getJzlsh() {
        return jzlsh;
    }

    @Column(name="CXBZ", length=1)
    public String getCxbz() {
        return cxbz;
    }

    @Column(name="KH", length=32)
    public String getKh() {
        return kh;
    }

    @Column(name="KLX", length=16)
    public String getKlx() {
        return klx;
    }

    @Column(name="JZKSDM", length=16)
    public String getJzksdm() {
        return jzksdm;
    }

    @Column(name="KFYS", length=16)
    public String getKfys() {
        return kfys;
    }

    @Column(name="KFYSXM", length=32)
    public String getKfysxm() {
        return kfysxm;
    }

    @Column(name="KFYSSFZ", length=18)
    public String getKfyssfz() {
        return kfyssfz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="KFRQ")
    public Date getKfrq() {
        return kfrq;
    }

    @Column(name="XMBM", length=32)
    public String getXmbm() {
        return xmbm;
    }

    @Column(name="XMBMYB", length=32)
    public String getXmbmyb() {
        return xmbmyb;
    }

    @Column(name="SCPH", length=32)
    public String getScph() {
        return scph;
    }

    @Column(name="YXQZ", length=8)
    public String getYxqz() {
        return yxqz;
    }

    @Column(name="XMMC", length=128)
    public String getXmmc() {
        return xmmc;
    }

    @Column(name="CFLX", length=2)
    public String getCflx() {
        return cflx;
    }

    @Column(name="JXDM", length=4)
    public String getJxdm() {
        return jxdm;
    }

    @Column(name="YPGG", length=64)
    public String getYpgg() {
        return ypgg;
    }

    @Column(name="YPYF", length=32)
    public String getYpyf() {
        return ypyf;
    }

    @Column(name="YPSL")
    public String getYpsl() {
        return ypsl;
    }

    @Column(name="YPDW")
    public String getYpdw() {
        return ypdw;
    }

    @Column(name="CFTS")
    public String getCfts() {
        return cfts;
    }

    @Column(name="YZZH")
    public String getYzzh() {
        return yzzh;
    }

    @Column(name="SYPCDM")
    public String getSypcdm() {
        return sypcdm;
    }

    @Column(name="SYPC")
    public String getSypc() {
        return sypc;
    }

    @Column(name="JL")
    public String getJl() {
        return jl;
    }

    @Column(name="DW")
    public String getDw() {
        return dw;
    }

    @Column(name="MCSL")
    public String getMcsl() {
        return mcsl;
    }

    @Column(name="MCDW")
    public String getMcdw() {
        return mcdw;
    }

    @Column(name="YF")
    public String getYf() {
        return yf;
    }

    @Column(name="YYTS")
    public String getYyts() {
        return yyts;
    }

    @Column(name="JYDM")
    public String getJydm() {
        return jydm;
    }

    @Column(name="SFPS")
    public String getSfps() {
        return sfps;
    }

    @Column(name="JCBW")
    public String getJcbw() {
        return jcbw;
    }

    @Column(name="BZ")
    public String getBz() {
        return bz;
    }

    @Column(name="MJ")
    public String getMj() {
        return mj;
    }

    @Column(name="BCBZ")
    public String getBcbz() {
        return bcbz;
    }


    public void setCyh(String cyh) {
        this.cyh = cyh;
    }
    public void setCfmxh(String cfmxh) {
        this.cfmxh = cfmxh;
    }
    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }
    public void setWsjgdm(String wsjgdm) {
        this.wsjgdm = wsjgdm;
    }
    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
    public void setCxbz(String cxbz) {
        this.cxbz = cxbz;
    }
    public void setKh(String kh) {
        this.kh = kh;
    }
    public void setKlx(String klx) {
        this.klx = klx;
    }
    public void setJzksdm(String jzksdm) {
        this.jzksdm = jzksdm;
    }
    public void setKfys(String kfys) {
        this.kfys = kfys;
    }
    public void setKfysxm(String kfysxm) {
        this.kfysxm = kfysxm;
    }
    public void setKfyssfz(String kfyssfz) {
        this.kfyssfz = kfyssfz;
    }
    public void setKfrq(Date kfrq) {
        this.kfrq = kfrq;
    }
    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }
    public void setXmbmyb(String xmbmyb) {
        this.xmbmyb = xmbmyb;
    }
    public void setScph(String scph) {
        this.scph = scph;
    }
    public void setYxqz(String yxqz) {
        this.yxqz = yxqz;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    public void setCflx(String cflx) {
        this.cflx = cflx;
    }
    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }
    public void setYpgg(String ypgg) {
        this.ypgg = ypgg;
    }
    public void setYpyf(String ypyf) {
        this.ypyf = ypyf;
    }
    public void setYpsl(String ypsl) {
        this.ypsl = ypsl;
    }
    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }
    public void setCfts(String cfts) {
        this.cfts = cfts;
    }
    public void setYzzh(String yzzh) {
        this.yzzh = yzzh;
    }
    public void setSypcdm(String sypcdm) {
        this.sypcdm = sypcdm;
    }
    public void setSypc(String sypc) {
        this.sypc = sypc;
    }
    public void setJl(String jl) {
        this.jl = jl;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public void setMcsl(String mcsl) {
        this.mcsl = mcsl;
    }
    public void setMcdw(String mcdw) {
        this.mcdw = mcdw;
    }
    public void setYf(String yf) {
        this.yf = yf;
    }
    public void setYyts(String yyts) {
        this.yyts = yyts;
    }
    public void setJydm(String jydm) {
        this.jydm = jydm;
    }
    public void setSfps(String sfps) {
        this.sfps = sfps;
    }
    public void setJcbw(String jcbw) {
        this.jcbw = jcbw;
    }
    public void setBz(String bz) {
        this.bz = bz;
    }
    public void setMj(String mj) {
        this.mj = mj;
    }
    public void setBcbz(String bcbz) {
        this.bcbz = bcbz;
    }

}
