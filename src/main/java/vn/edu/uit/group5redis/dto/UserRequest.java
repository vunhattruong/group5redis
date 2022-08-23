package vn.edu.uit.group5redis.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotNull
    private String userName;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
}
