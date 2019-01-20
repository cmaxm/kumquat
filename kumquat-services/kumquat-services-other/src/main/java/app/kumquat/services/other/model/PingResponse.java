package app.kumquat.services.other.model;

import org.joda.time.DateTime;

public class PingResponse {

    private String responseText;
    private String time;

    public PingResponse(String responseText, String timeout) {
        this.responseText = responseText;
        this.time = timeout;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
