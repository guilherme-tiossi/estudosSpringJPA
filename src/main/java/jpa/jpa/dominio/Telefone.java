package jpa.jpa.dominio;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTelefone;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTelefone tipo;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long numero;


    // public Telefone() {

    // }

    // public Telefone(String tipo, Long numero) {
    //     super();
    //     this.tipo = tipo;
    //     this.numero = numero;
    // }

    @Override
    public String toString() {
        return "Telefone [id="+idTelefone+", tipo="+tipo+", número="+numero+"]";
    }

}
