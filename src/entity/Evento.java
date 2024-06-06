package entity;

import java.sql.Date;

public class Evento {

    private int evento_id;
    private int socio_id;
    private int funcionario_id;
    private Date data_evento;
    private String descricao;
    private String local_evento;

    public int getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
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

    public Date getData_evento() {
        return data_evento;
    }

    public void setData_evento(Date data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal_evento() {
        return local_evento;
    }

    public void setLocal_evento(String local_evento) {
        this.local_evento = local_evento;
    }

    public String getLocal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Date getData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
