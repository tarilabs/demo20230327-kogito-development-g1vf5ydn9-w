package org.drools.demo;

import java.util.List;

public class StatusRequest {
    List<PartyCountry> partyCountries;
    Boolean approved;

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public List<PartyCountry> getPartyCountries() {
        return partyCountries;
    }

    public void setPartyCountries(List<PartyCountry> partyCountries) {
        this.partyCountries = partyCountries;
    }
}
