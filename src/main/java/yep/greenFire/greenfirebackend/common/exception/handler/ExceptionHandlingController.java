package yep.greenFire.greenfirebackend.common.exception.handler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yep.greenFire.greenfirebackend.common.exception.ConflictException;
import yep.greenFire.greenfirebackend.common.exception.dto.response.ExceptionResponse;
import yep.greenFire.greenfirebackend.common.exception.ServerInternalException;

@RestControllerAdvice
public class ExceptionHandlingController {

    /* Not Found Exception */
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundException(ChangeSetPersister.NotFoundException e) {

        final ExceptionResponse exceptionResponse = ExceptionResponse.of(e.getCode(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    /* Server Error */
    @ExceptionHandler(ServerInternalException.class)
    public ResponseEntity<ExceptionResponse> serverInternalException(ServerInternalException e) {

        final ExceptionResponse exceptionResponse = ExceptionResponse.of(e.getCode(), e.getMessage());

        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

    /* Conflict : 충돌 (논리적으로 수행할 수 없을 경우 처리) 409 */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionResponse> conflictException(ConflictException e) {

        final ExceptionResponse exceptionResponse = ExceptionResponse.of(e.getCode(), e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }

    /* Valid Exception */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();

        final ExceptionResponse exceptionResponse = ExceptionResponse.of(9000, defaultMessage);

        return ResponseEntity.badRequest().body(exceptionResponse);
    }








}