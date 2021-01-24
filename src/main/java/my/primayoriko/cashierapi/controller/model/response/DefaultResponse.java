package my.primayoriko.cashierapi.controller.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefaultResponse {
    private int statusCode;
    private String message;
}
