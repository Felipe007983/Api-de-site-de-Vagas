package portaldevagas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CandidaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private usuariomodel usuario;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private vagasmodel vaga;

    private LocalDateTime dataCandidatura;

    private String status; // Ex: "ENVIADA", "EM_ANALISE", "REJEITADA", "APROVADA"

    public CandidaturaModel(Long id, usuariomodel usuario, vagasmodel vaga, LocalDateTime dataCandidatura, String status) {
        this.id = id;
        this.usuario = usuario;
        this.vaga = vaga;
        this.dataCandidatura = dataCandidatura;
        this.status = status;
    }

    public CandidaturaModel(){

    }

    @Override
    public String toString() {
        return "CandidaturaModel{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", vaga=" + vaga +
                ", dataCandidatura=" + dataCandidatura +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usuariomodel getUsuario() {
        return usuario;
    }

    public void setUsuario(usuariomodel usuario) {
        this.usuario = usuario;
    }

    public vagasmodel getVaga() {
        return vaga;
    }

    public void setVaga(vagasmodel vaga) {
        this.vaga = vaga;
    }

    public LocalDateTime getDataCandidatura() {
        return dataCandidatura;
    }

    public void setDataCandidatura(LocalDateTime dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

