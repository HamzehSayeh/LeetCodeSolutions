class BrowserHistory {
    String tab;
    Stack<String> backward = new Stack<>();
    Stack<String> forward = new Stack<>();

    public BrowserHistory(String homepage) {
        tab = homepage;
    }

    public void visit(String url) {
        if (tab != null)
            backward.push(tab);
        tab = url;
        forward.clear();

    }

    public String back(int steps) {
        while (steps > 0) {
            if (backward.empty())
                break;
            forward.push(tab);
            tab = backward.pop();
            steps--;

        }
        return tab;

    }

    public String forward(int steps) {
        while (steps > 0) {
            if (forward.empty())
                break;
            backward.push(tab);
            tab = forward.pop();
            steps--;

        }
        return tab;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */