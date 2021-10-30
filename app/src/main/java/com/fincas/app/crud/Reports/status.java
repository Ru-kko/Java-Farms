package com.fincas.app.crud.Reports;

public class status {
    private int completed;
    private int cancelled;

    public status() {
    }

    public status(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }
    public int getCancelled() {
        return cancelled;
    }
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
