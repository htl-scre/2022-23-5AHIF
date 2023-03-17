package at.htlstp.security.presentation.web.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String passwordRepeat;

    @AssertTrue(message = "Passwords must match")
    public boolean isValid() {
        // insert pw validation
        return password.equals(passwordRepeat);
    }
}
