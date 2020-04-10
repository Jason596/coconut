package ccc.springboot.coconut.model.entity;

public class VirusModel {
  private String State;
  private String Country;
  private int lastConfirmedNum;

    @Override
    public String toString() {
        return "VirusModel{" +
                "State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", lastConfirmedNum=" + lastConfirmedNum +
                '}';
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getLastConfirmedNum() {
        return lastConfirmedNum;
    }

    public void setLastConfirmedNum(int lastConfirmedNum) {
        this.lastConfirmedNum = lastConfirmedNum;
    }
}
