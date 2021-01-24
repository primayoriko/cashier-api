package my.primayoriko.cashierapi.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String name;
    private String email;
}
