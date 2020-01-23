
public class temp {

private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
	
INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
NOT_IMPLEMENTED(501, "Not Implemented"),
BAD_GATEWAY(502, "Bad Gateway"),
SERVICE_UNAVAILABLE(503, "Service Unavailable"),
GATEWAY_TIMEOUT(504, "Gateway Timeout"),
HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
LOOP_DETECTED(508, "Loop Detected"),
BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
NOT_EXTENDED(510, "Not Extended"),
NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");
	
}
