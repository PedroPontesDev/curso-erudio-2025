package com.curso_erudio.course.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
