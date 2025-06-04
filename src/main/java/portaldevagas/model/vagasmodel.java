package portaldevagas.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class vagasmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomeVaga;

    @Temporal(TemporalType.DATE)

    private Date dataCadVaga;
    private String descricao;

    public vagasmodel(){

    }

    public vagasmodel(Long id, String nomeVaga, Date dataCadVaga, String descricao) {
        this.id = id;
        this.nomeVaga = nomeVaga;
        this.dataCadVaga = dataCadVaga;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public Date getDataCadVaga() {
        return dataCadVaga;
    }

    public void setDataCadVaga(Date dataCadVaga) {
        this.dataCadVaga = dataCadVaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
