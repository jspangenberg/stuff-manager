package com.heroesandfriends.stuffmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author John Spangenberg
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This stuff is not found in the system")
public class StuffNotFoundException extends Exception {
}
