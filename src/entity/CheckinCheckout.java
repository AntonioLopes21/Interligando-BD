package entity;

import java.sql.Timestamp;

public class CheckinCheckout {

    private int checkincheckout_id;
    private int socio_id;
    private int funcionario_id;
    private Timestamp data_checkin;
    private Timestamp data_checkout;

    public int getCheckincheckout_id() {
        return checkincheckout_id;
    }

    public void setCheckincheckout_id(int checkincheckout_id) {
        this.checkincheckout_id = checkincheckout_id;
    }

    public int getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(int socio_id) {
        this.socio_id = socio_id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public Timestamp getData_checkin() {
        return data_checkin;
    }

    public void setData_checkin(Timestamp data_checkin) {
        this.data_checkin = data_checkin;
    }

    public Timestamp getData_checkout() {
        return data_checkout;
    }

    public void setData_checkout(Timestamp data_checkout) {
        this.data_checkout = data_checkout;
    }

    public void setEntrada(Timestamp timestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEntrada'");
    }
}
