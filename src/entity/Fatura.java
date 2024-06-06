package entity;

import java.sql.Date;

public class Fatura {

    private int fatura_id;
    private int socio_id;
    private int evento_id;
    private Date data_fatura;
    private double valor_total;
    private boolean pago;

    public int getFatura_id() {
        return fatura_id;
    }

    public void setFatura_id(int fatura_id) {
        this.fatura_id = fatura_id;
    }

    public int getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(int socio_id) {
        this.socio_id = socio_id;
    }

    public int getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
    }

    public Date getData_fatura() {
        return data_fatura;
    }

    public void setData_fatura(Date data_fatura) {
        this.data_fatura = data_fatura;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
