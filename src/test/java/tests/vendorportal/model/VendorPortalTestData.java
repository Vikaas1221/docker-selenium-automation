package tests.vendorportal.model;

public class VendorPortalTestData
{
    private String username,password,monthlyEarning,annualEarning,profitMargin,availableInventory,searchKeyword;
    private int searchResultsCount;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMonthlyEarning(String monthlyEarning) {
        this.monthlyEarning = monthlyEarning;
    }

    public void setAnnualEarning(String annualEarning) {
        this.annualEarning = annualEarning;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    public void setAvailableInventory(String availableInventory) {
        this.availableInventory = availableInventory;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setSearchResultsCount(int searchResultsCount) {
        this.searchResultsCount = searchResultsCount;
    }

    public VendorPortalTestData()
    {
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMonthlyEarning() {
        return monthlyEarning;
    }

    public String getAnnualEarning() {
        return annualEarning;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public String getAvailableInventory() {
        return availableInventory;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public int getSearchResultsCount() {
        return searchResultsCount;
    }
}
