package com.bhat.omnicell.challenge.recipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ApiError
 */
@Validated
public class ApiError {
    @JsonProperty("status")
    private String code = null;

    @JsonProperty("message")
    private String message = null;


    public ApiError(String code, String message) {
        this.code = code;

        this.message = message;
    }

    public ApiError code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The HTTP error code.
     * @return code
     **/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    /**
     * The HTTP error status
     * @return status
     **/


    public ApiError message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The error message
     * @return message
     **/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiError apiError = (ApiError) o;
        return Objects.equals(this.code, apiError.code) &&
                Objects.equals(this.message, apiError.message) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiError {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
