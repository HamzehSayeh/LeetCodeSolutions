public class DoublyLinkedList {
    String url;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    DoublyLinkedList tab;

    public BrowserHistory(String homepage) {
        tab = new DoublyLinkedList(homepage);
    }

    public void visit(String url) {
        DoublyLinkedList newTab = new DoublyLinkedList(url);
        tab.next = newTab;
        newTab.prev = tab;
        tab = newTab;

    }

    public String back(int steps) {
        while (steps > 0 && tab.prev != null) {
            tab = tab.prev;
            steps--;
        }
        return tab.url;

    }

    public String forward(int steps) {
        while (steps > 0 && tab.next != null) {
            tab = tab.next;
            steps--;
        }
        return tab.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */