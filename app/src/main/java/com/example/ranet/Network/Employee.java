package com.example.ranet.Network;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_lang")
    @Expose
    private String idLang;
    @SerializedName("last_passwd_gen")
    @Expose
    private String lastPasswdGen;
    @SerializedName("stats_date_from")
    @Expose
    private String statsDateFrom;
    @SerializedName("stats_date_to")
    @Expose
    private String statsDateTo;
    @SerializedName("stats_compare_from")
    @Expose
    private String statsCompareFrom;
    @SerializedName("stats_compare_to")
    @Expose
    private String statsCompareTo;
    @SerializedName("passwd")
    @Expose
    private String passwd;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("optin")
    @Expose
    private String optin;
    @SerializedName("id_profile")
    @Expose
    private String idProfile;
    @SerializedName("bo_color")
    @Expose
    private String boColor;
    @SerializedName("default_tab")
    @Expose
    private String defaultTab;
    @SerializedName("bo_theme")
    @Expose
    private String boTheme;
    @SerializedName("bo_css")
    @Expose
    private String boCss;
    @SerializedName("bo_width")
    @Expose
    private String boWidth;
    @SerializedName("bo_menu")
    @Expose
    private String boMenu;
    @SerializedName("stats_compare_option")
    @Expose
    private String statsCompareOption;
    @SerializedName("preselect_date_range")
    @Expose
    private String preselectDateRange;
    @SerializedName("id_last_order")
    @Expose
    private String idLastOrder;
    @SerializedName("id_last_customer_message")
    @Expose
    private String idLastCustomerMessage;
    @SerializedName("id_last_customer")
    @Expose
    private String idLastCustomer;
    @SerializedName("reset_password_token")
    @Expose
    private String resetPasswordToken;
    @SerializedName("reset_password_validity")
    @Expose
    private String resetPasswordValidity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    public String getLastPasswdGen() {
        return lastPasswdGen;
    }

    public void setLastPasswdGen(String lastPasswdGen) {
        this.lastPasswdGen = lastPasswdGen;
    }

    public String getStatsDateFrom() {
        return statsDateFrom;
    }

    public void setStatsDateFrom(String statsDateFrom) {
        this.statsDateFrom = statsDateFrom;
    }

    public String getStatsDateTo() {
        return statsDateTo;
    }

    public void setStatsDateTo(String statsDateTo) {
        this.statsDateTo = statsDateTo;
    }

    public String getStatsCompareFrom() {
        return statsCompareFrom;
    }

    public void setStatsCompareFrom(String statsCompareFrom) {
        this.statsCompareFrom = statsCompareFrom;
    }

    public String getStatsCompareTo() {
        return statsCompareTo;
    }

    public void setStatsCompareTo(String statsCompareTo) {
        this.statsCompareTo = statsCompareTo;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getOptin() {
        return optin;
    }

    public void setOptin(String optin) {
        this.optin = optin;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    public String getBoColor() {
        return boColor;
    }

    public void setBoColor(String boColor) {
        this.boColor = boColor;
    }

    public String getDefaultTab() {
        return defaultTab;
    }

    public void setDefaultTab(String defaultTab) {
        this.defaultTab = defaultTab;
    }

    public String getBoTheme() {
        return boTheme;
    }

    public void setBoTheme(String boTheme) {
        this.boTheme = boTheme;
    }

    public String getBoCss() {
        return boCss;
    }

    public void setBoCss(String boCss) {
        this.boCss = boCss;
    }

    public String getBoWidth() {
        return boWidth;
    }

    public void setBoWidth(String boWidth) {
        this.boWidth = boWidth;
    }

    public String getBoMenu() {
        return boMenu;
    }

    public void setBoMenu(String boMenu) {
        this.boMenu = boMenu;
    }

    public String getStatsCompareOption() {
        return statsCompareOption;
    }

    public void setStatsCompareOption(String statsCompareOption) {
        this.statsCompareOption = statsCompareOption;
    }

    public String getPreselectDateRange() {
        return preselectDateRange;
    }

    public void setPreselectDateRange(String preselectDateRange) {
        this.preselectDateRange = preselectDateRange;
    }

    public String getIdLastOrder() {
        return idLastOrder;
    }

    public void setIdLastOrder(String idLastOrder) {
        this.idLastOrder = idLastOrder;
    }

    public String getIdLastCustomerMessage() {
        return idLastCustomerMessage;
    }

    public void setIdLastCustomerMessage(String idLastCustomerMessage) {
        this.idLastCustomerMessage = idLastCustomerMessage;
    }

    public String getIdLastCustomer() {
        return idLastCustomer;
    }

    public void setIdLastCustomer(String idLastCustomer) {
        this.idLastCustomer = idLastCustomer;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getResetPasswordValidity() {
        return resetPasswordValidity;
    }

    public void setResetPasswordValidity(String resetPasswordValidity) {
        this.resetPasswordValidity = resetPasswordValidity;
    }

}
