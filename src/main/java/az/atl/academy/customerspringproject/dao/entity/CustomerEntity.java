package az.atl.academy.customerspringproject.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customersSpring")
public class CustomerEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Column(name = "lastName", nullable = false, unique = true)
    String lastName;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "country", nullable = false, unique = true)
    String country;

    public static CustomerEntityBuilder builder() {
        return new CustomerEntityBuilder();
    }


    public static class CustomerEntityBuilder {
        private Long id;

        private String name;

        private String lastName;
        private String email;
        private String country;

        public CustomerEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public CustomerEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerEntityBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerEntityBuilder country(String country) {
            this.country = country;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(id, name, lastName, email, country);
        }
    }
}
