package modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import redis.clients.jedis.params.XAutoClaimParams;

@Entity @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;
    private String userName ;
    private String Email ;
    @Enumerated (EnumType.STRING)
    private enums.role role ;
}
