package com.example.demo3;

public class StatusUpdate {
}
package com.example.demo3;

public class StatusUpdate {
    private final String requestId;
    private final String status;
    private final String comment;

    public StatusUpdate(String requestId, String status, String comment) {
        this.requestId = requestId;
        this.status = status;
        this.comment = comment;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }
}
