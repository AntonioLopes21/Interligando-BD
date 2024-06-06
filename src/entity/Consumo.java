package entity;


import java.sql.Timestamp;

public class Consumo {

    private int consumo_id;
    private int socio_id;
    private int funcionario_id;
    private Timestamp data_consumo;
    private String descricao;
    private double valor;

    public int getConsumo_id() {
        return consumo_id;
    }

    public void setConsumo_id(int consumo_id) {
        this.consumo_id = consumo_id;
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

    public Timestamp getData_consumo() {
        return data_consumo;
    }

    public void setData_consumo(Timestamp data_consumo) {
        this.data_consumo = data_consumo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
