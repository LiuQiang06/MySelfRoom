package com.room.pojo;

public class SeatInfo {
    private Integer id; //ID
    private String deskId; //桌号
    private String seatNo; //桌号
    private Integer deskStatus; //当前状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(Integer deskStatus) {
        this.deskStatus = deskStatus;
    }
}

