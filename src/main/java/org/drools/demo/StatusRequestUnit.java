package org.drools.demo;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class StatusRequestUnit implements RuleUnitData {
    private DataStore<StatusRequest> statusRequests;

    public DataStore<StatusRequest> getStatusRequests() {
        return statusRequests;
    }

    public StatusRequestUnit() {
        this(DataSource.createStore());
    }

    public StatusRequestUnit(DataStore<StatusRequest> statusRequests) {
        this.statusRequests = statusRequests;
    }
}
