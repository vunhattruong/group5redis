package vn.edu.uit.group5redis.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCacheInfo implements Serializable {
    @Serial
    private static final long   serialVersionUID = 1L;
    private              UUID   userId;
    private              String userName;
    private              String fullName;
    private              String phoneNumber;
    private              String email;
    private              String address;

}
