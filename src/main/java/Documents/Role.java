package Documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    private String id;

    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
}
