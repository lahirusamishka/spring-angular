package lk.ijse.springboot.app.dto;

public class orderDetail_PKDTO {

    private String code;
    private String oId;

    public orderDetail_PKDTO() {
    }

    public orderDetail_PKDTO(String code, String oId) {
        this.setCode(code);
        this.setoId(oId);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }
}
