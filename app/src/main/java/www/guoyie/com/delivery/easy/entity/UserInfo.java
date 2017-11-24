package www.guoyie.com.delivery.easy.entity;

import java.io.Serializable;

/**
 * Created by kejun on 2017/3/17.
 */

public class UserInfo implements Serializable {

    private String sysno;
    private String username;
    private String employee_sysno;
    private String employeename;
    private String lastlogintime;
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    private String lastloginip;

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmployee_sysno() {
        return employee_sysno;
    }

    public void setEmployee_sysno(String employee_sysno) {
        this.employee_sysno = employee_sysno;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }
}
