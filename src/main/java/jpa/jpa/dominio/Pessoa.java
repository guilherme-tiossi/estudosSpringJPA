package jpa.jpa.dominio;

import java.io.Serializable;

import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Getter
    @Setter
    @Column(nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String cpf;

    @Getter
    @Setter
    @Column(nullable = false)
    private String sobrenome;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    @Getter
    @Setter
    // // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private java.util.List<Telefone> telefones;    

    // public Pessoa() {

    // }

    // public Pessoa(Long id, String nome, String email) {
    //     super();
    //     this.nome = nome;
    //     this.email = email;
    // }

    @Override
    public String toString() {
        return "Pessoa [id="+idPessoa+", nome="+nome+", email="+email+"]";
    }

}
