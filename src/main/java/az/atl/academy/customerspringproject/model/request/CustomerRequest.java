package az.atl.academy.customerspringproject.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    @NotBlank
    String name;

    @NotBlank
    String lastName;

    @NotBlank
    String email;

    @NotBlank
    String country;
}
