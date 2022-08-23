package vn.edu.uit.group5redis.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID   userId;
    private String userName;
    private String phoneNumber;
    private String status;
    private String message;
}
