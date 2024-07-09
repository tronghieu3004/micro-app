package dev.omega.microshopapp.exceptions;

import dev.omega.microshopapp.model.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(SimpleGlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ResultResponse<String>> handleGlobalException(SimpleGlobalException simpleGlobalException, Locale locale) {
        return ResponseEntity.ok(new ResultResponse<>(simpleGlobalException.getCode(), simpleGlobalException.getMessage(), null));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ResultResponse<String>> handleGeneralException(AppException ex) {
        String message = "";
        if (ex.getMessage() != null) {
            message = ex.getMessage();
            log.error(ex.getMessage());
        }
        Locale locale = LocaleContextHolder.getLocale();
        return ResponseEntity.badRequest().body(new ResultResponse<>(ex.getCode(), messageSource.getMessage(message, null, locale), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultResponse<?>> handleException(Exception exception) {
        log.error("Exception: ", exception);
        return ResponseEntity
                .internalServerError()
                .body(new ResultResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.name(), "internal server error", null));
    }

}
