package entity;

public class Dependente {

    private int dependente_id;
    private int socio_id;
    private String nome;
    private String parentesco;

    public int getDependente_id() {
        return dependente_id;
    }

    public void setDependente_id(int dependente_id) {
        this.dependente_id = dependente_id;
    }

    public int getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(int socio_id) {
        this.socio_id = socio_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
