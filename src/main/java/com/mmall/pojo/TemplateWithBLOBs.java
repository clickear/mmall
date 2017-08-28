package com.mmall.pojo;

public class TemplateWithBLOBs extends Template {
    private byte[] har;

    private String variables;

    public TemplateWithBLOBs(Integer id, Integer userid, String siteurl, String sitename, Integer disabled, Integer interval, byte[] har, String variables) {
        super(id, userid, siteurl, sitename, disabled, interval);
        this.har = har;
        this.variables = variables;
    }

    public TemplateWithBLOBs() {
        super();
    }

    public byte[] getHar() {
        return har;
    }

    public void setHar(byte[] har) {
        this.har = har;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables == null ? null : variables.trim();
    }
}