package com.fincas.app.crud.Reports;

import com.fincas.app.crud.clients.clientEntity;

public class clietnCounter {
    private Long total;
    private clientEntity client;

    public clietnCounter(Long total, clientEntity clietn) {
        this.setTotal(total);
        this.setClient(clietn);
    }

    public clietnCounter() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public clientEntity getClient() {
        return client;
    }

    public void setClient(clientEntity client) {
        this.client = client;
    }
}