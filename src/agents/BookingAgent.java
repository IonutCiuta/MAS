package agents;

import communication.Message;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class BookingAgent extends AbstractAgent {
    private String proxyId;
    private Queue<Message> messages;

    public BookingAgent(String id) {
        super(id);
        this.messages = new PriorityQueue<>();
    }

    public String getProxyId() {
        return proxyId;
    }

    public void setProxyId(String proxyId) {
        this.proxyId = proxyId;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
