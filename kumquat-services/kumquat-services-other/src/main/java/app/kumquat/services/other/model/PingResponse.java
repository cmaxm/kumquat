package app.kumquat.services.other.model;

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

    @Override
    public String toString() {
        return "PingResponse{" +
                "responseText='" + responseText + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
