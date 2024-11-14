package Modelo;

// Classe de persistência gerada automaticamente pela IDE, baseada no bando de dados do SQL Server

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "Climas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clima.findAll", query = "SELECT c FROM Clima c"),
    @NamedQuery(name = "Clima.findById", query = "SELECT c FROM Clima c WHERE c.id = :id"),
    @NamedQuery(name = "Clima.findByTemperatura", query = "SELECT c FROM Clima c WHERE c.temperatura = :temperatura"),
    @NamedQuery(name = "Clima.findByUmidade", query = "SELECT c FROM Clima c WHERE c.umidade = :umidade"),
    @NamedQuery(name = "Clima.findByPrecipitacao", query = "SELECT c FROM Clima c WHERE c.precipitacao = :precipitacao")})
public class Clima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "temperatura")
    private String temperatura;
    @Size(max = 10)
    @Column(name = "umidade")
    private String umidade;
    @Size(max = 10)
    @Column(name = "precipitacao")
    private String precipitacao;

    public Clima() {
    }

    public Clima(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clima)) {
            return false;
        }
        Clima other = (Clima) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Clima[ id=" + id + " ]";
    }
    
}
