package com.example.prateek.bottom_navigation.Contests.PortfolioRV;

public class PortfolioModel {
    private String portfolioname;
    private double returns;

    public PortfolioModel(String portfolioname, double returns) {
        this.portfolioname = portfolioname;
        this.returns = returns;
    }

    public String getPortfolioName() {

        return portfolioname;
    }

    public void setPortfolioName(String portfolioname) {
        this.portfolioname = portfolioname;
    }

    public double getReturns() {
        return returns;
    }

    public void setReturns(double returns) {
        this.returns = returns;
    }
}
